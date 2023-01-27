package com.jaeeunyoo.outbound.webclient.github.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

@Data
public class GetAccessTokenResponse {

    @JsonProperty("error")
    private String error;

    @JsonProperty("error_description")
    private String errorDescription;

    @JsonProperty("error_uri")
    private String errorUri;

    @JsonProperty("access_token")
    private String accessToken;

    @JsonProperty("token_type")
    private String tokenType;

    public String getAuthorizationHeader() {
        return StringUtils.isNotBlank(tokenType) && StringUtils.isNotBlank(accessToken) ?
               tokenType + " " + accessToken :
               null;
    }
}
