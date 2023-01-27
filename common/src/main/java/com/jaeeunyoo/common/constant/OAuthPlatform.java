package com.jaeeunyoo.common.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum OAuthPlatform {

    GITHUB("https://api.github.com/user");

    private final String platformInfoUrl;
}
