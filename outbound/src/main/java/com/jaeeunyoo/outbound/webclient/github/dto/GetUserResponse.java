package com.jaeeunyoo.outbound.webclient.github.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GetUserResponse {

    @JsonProperty("login")
    private String githubLoginId;

    @JsonProperty("id")
    private Long githubUserId;

    @JsonProperty("avatar_url")
    private String githubProfileImageUrl;

    @JsonProperty("email")
    private String githubUserEmail;

    @JsonProperty("name")
    private String githubUserName;

    @JsonProperty("company")
    private String company;

    @JsonProperty("blog")
    private String blogUrl;

    @JsonProperty("location")
    private String location;

    @JsonProperty("followers")
    private Long followerCount;

    @JsonProperty("following")
    private Long followingCount;

    @JsonProperty("public_repos")
    private Long publicRepoCount;

    @JsonProperty("public_gists")
    private Long publicGistCount;
}