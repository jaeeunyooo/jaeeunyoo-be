package com.jaeeunyoo.infrastructure.support;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import static com.jaeeunyoo.infrastructure.support.CurrentMemberIdInterceptor.CURRENT_MEMBER_ID_KEY;

@Slf4j
@RequiredArgsConstructor
@Component
public class CurrentMemberIdResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return Integer.class.isAssignableFrom(methodParameter.getParameterType());
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter,
                                  ModelAndViewContainer modelAndViewContainer,
                                  NativeWebRequest nativeWebRequest,
                                  WebDataBinderFactory webDataBinderFactory) throws Exception {
        Object currentMemberIdObject = nativeWebRequest.getAttribute(CURRENT_MEMBER_ID_KEY, RequestAttributes.SCOPE_REQUEST);
        return currentMemberIdObject == null ? null : (Integer) currentMemberIdObject;
    }
}
