package com.jaeeunyoo.apimember.presentation.dto;

import com.jaeeunyoo.common.constant.OAuthPlatform;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class OAuthSignInRequest {

    @NotNull
    private OAuthPlatform oauthPlatform;

    @NotEmpty
    private String authorizationCode;   // accessToken 발급을 위한 임시 코드
}
