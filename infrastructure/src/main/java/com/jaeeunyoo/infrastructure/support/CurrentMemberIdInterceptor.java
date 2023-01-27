package com.jaeeunyoo.infrastructure.support;

import com.jaeeunyoo.common.constant.SessionKey;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Slf4j
@RequiredArgsConstructor
@Component
public class CurrentMemberIdInterceptor implements HandlerInterceptor {

    public static final String CURRENT_MEMBER_ID_KEY = "currentMemberId";

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler) {
        if(!(handler instanceof HandlerMethod)) {
            return true;
        }

        boolean isCurrentMemberIdRequired = isCurrentMemberIdRequired(handler);
        Integer currentMemberId = getCurrentMemberId(httpServletRequest);
        if(isCurrentMemberIdRequired && currentMemberId == null) {
            throw new RuntimeException();
        }

        if(currentMemberId != null) {
            httpServletRequest.setAttribute(CURRENT_MEMBER_ID_KEY, currentMemberId);
        }

        return true;
    }

    private boolean isCurrentMemberIdRequired(Object handler) {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        MemberRequired memberRequired = handlerMethod.getMethodAnnotation(MemberRequired.class);
        return memberRequired != null;
    }

    private Integer getCurrentMemberId(HttpServletRequest httpServletRequest) {
        HttpSession httpSession = httpServletRequest.getSession(false);
        if(httpSession == null || httpSession.getAttribute(SessionKey.CURRENT_MEMBER) == null) {
            return null;
        }

        Object sessionObj = httpSession.getAttribute(SessionKey.CURRENT_MEMBER);
        if(sessionObj == null) {
            return null;
        }

        return (Integer) sessionObj;
    }
}
