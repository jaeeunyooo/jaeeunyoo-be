package com.jaeeunyoo.apimember.presentation.dto;

import com.jaeeunyoo.common.constant.OAuthPlatform;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class CreateMemberRequest {

    @NotEmpty
    private String email;

    @NotEmpty
    private String name;

    @NotEmpty
    private String nickname;

    private String introduction;

    @NotNull
    private OAuthPlatform oAuthPlatform;

    @NotNull
    private Long oAuthPlatformUserId;
}
