package com.jaeeunyoo.apimember.application;

import com.jaeeunyoo.apimember.presentation.dto.CreateMemberRequest;
import com.jaeeunyoo.common.constant.MemberType;
import com.jaeeunyoo.common.constant.OAuthPlatform;
import com.jaeeunyoo.domain.member.entity.Member;
import com.jaeeunyoo.domain.member.exception.MemberException;
import com.jaeeunyoo.domain.member.MemberDomainService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberManagementService {

    private final MemberDomainService memberDomainService;

    public Member createNewMember(CreateMemberRequest createMemberRequest) {
        if(OAuthPlatform.GITHUB != createMemberRequest.getOAuthPlatform()) {
            throw new MemberException(HttpStatus.BAD_REQUEST, "깃허브 로그인만 지원");
        }

        if(isDuplicatedEmail(createMemberRequest.getEmail())) {
            throw new MemberException(HttpStatus.BAD_REQUEST, "이미 가입된 이메일");
        }

        LocalDateTime now = LocalDateTime.now();
        Member newMember = Member.builder()
            .memberId(null)
            .email(createMemberRequest.getEmail())
            .nickname(createMemberRequest.getNickname())
            .introduction(createMemberRequest.getIntroduction())
            .memberType(MemberType.BLOG_USER)
            .githubUserId(createMemberRequest.getOAuthPlatformUserId())
            .createdAt(now)
            .updatedAt(now)
            .build();
        return memberDomainService.createMember(newMember);
    }

    private Boolean isDuplicatedEmail(String email) {
        return memberDomainService.isJoinedUserBy(email);
    }
}
