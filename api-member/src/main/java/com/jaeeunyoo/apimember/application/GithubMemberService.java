package com.jaeeunyoo.apimember.application;

import com.jaeeunyoo.common.constant.MemberType;
import com.jaeeunyoo.domain.member.MemberDomainService;
import com.jaeeunyoo.domain.member.exception.MemberException;
import com.jaeeunyoo.domain.member.entity.Member;
import com.jaeeunyoo.outbound.webclient.github.GithubApiClient;
import com.jaeeunyoo.outbound.webclient.github.dto.GetAccessTokenResponse;
import com.jaeeunyoo.outbound.webclient.github.dto.GetUserResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class GithubMemberService {

    private final GithubApiClient githubApiClient;
    private final MemberDomainService memberDomainService;


    public Member getGithubSignedInMember(final String authorizationCode) {
        GetAccessTokenResponse accessTokenResponse = githubApiClient.getAccessToken(authorizationCode);
        if(accessTokenResponse == null || StringUtils.isBlank(accessTokenResponse.getAccessToken())) {
            throw new MemberException(HttpStatus.BAD_REQUEST, "GIHUB 액세스 토큰 획득 실패");
        }

        GetUserResponse getUserResponse = githubApiClient.getUser(accessTokenResponse.getAuthorizationHeader());
        if(getUserResponse == null || getUserResponse.getGithubUserId() == null) {
            throw new MemberException(HttpStatus.BAD_REQUEST, "깃허브 유저 정보 획득 실패");
        }

        Member member = memberDomainService.getMemberByGithubUserId(getUserResponse.getGithubUserId());
        return member != null ?
               member :
               memberDomainService.createMember(newMemberByGithub(getUserResponse));    // 회원가입 처리
    }

    private Member newMemberByGithub(GetUserResponse getUserResponse) {
        LocalDateTime now = LocalDateTime.now();
        return Member.builder()
            .memberId(null)     // AutoIncrement
            .email(getUserResponse.getGithubUserEmail())
            .name(getUserResponse.getGithubUserName())
            .nickname(null)
            .introduction(null)
            .memberType(MemberType.BLOG_USER)
            .githubUserId(getUserResponse.getGithubUserId())
            .createdAt(now)
            .updatedAt(now)
            .deletedAt(null)
            .build();
    }
}
