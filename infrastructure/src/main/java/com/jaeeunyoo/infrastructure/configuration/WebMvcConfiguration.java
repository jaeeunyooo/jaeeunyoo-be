package com.jaeeunyoo.infrastructure.configuration;

import com.jaeeunyoo.infrastructure.support.CurrentMemberIdInterceptor;
import com.jaeeunyoo.infrastructure.support.CurrentMemberIdResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class WebMvcConfiguration implements WebMvcConfigurer {

    private final CurrentMemberIdInterceptor currentMemberIdInterceptor;
    private final CurrentMemberIdResolver currentMemberIdResolver;

    @Override
    public void addInterceptors(InterceptorRegistry interceptorRegistry) {
        interceptorRegistry.addInterceptor(currentMemberIdInterceptor);
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(currentMemberIdResolver);
    }
}
