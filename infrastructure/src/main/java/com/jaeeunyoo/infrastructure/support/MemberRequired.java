package com.jaeeunyoo.infrastructure.support;

import com.jaeeunyoo.common.constant.MemberType;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target(METHOD)
public @interface MemberRequired {

    MemberType memberType() default MemberType.BLOG_USER;
}
