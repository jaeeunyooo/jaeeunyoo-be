package com.jaeeunyoo.apimember.presentation;

import com.jaeeunyoo.apimember.application.GithubMemberService;
import com.jaeeunyoo.apimember.presentation.dto.OAuthSignInRequest;
import com.jaeeunyoo.common.constant.SessionKey;
import com.jaeeunyoo.common.dto.CommonApiResponse;
import com.jaeeunyoo.domain.member.entity.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/members")
public class MemberController {

    private final GithubMemberService githubMemberService;

    @PostMapping("/sign-in")
    public CommonApiResponse<Member> signIn(HttpServletRequest httpServletRequest,
                                            @RequestBody @Valid OAuthSignInRequest oAuthSignInRequest) {
        Member member = githubMemberService.getGithubSignedInMember(oAuthSignInRequest.getAuthorizationCode());
        httpServletRequest.getSession().setAttribute(SessionKey.CURRENT_MEMBER, member.getMemberId());
        return CommonApiResponse.success(member);
    }

    @DeleteMapping("/sign-out")
    public CommonApiResponse<Object> signOut(HttpServletRequest httpServletRequest) {
        Object currentMemberSessionObject = httpServletRequest.getSession().getAttribute(SessionKey.CURRENT_MEMBER);
        if(currentMemberSessionObject == null) {
            return CommonApiResponse.success(null);
        }
        String sessionValue = (String) currentMemberSessionObject;
        httpServletRequest.getSession(false).invalidate();
        return CommonApiResponse.success(null);
    }
}
