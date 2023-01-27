package com.jaeeunyoo.outbound.webclient.github;
import com.jaeeunyoo.outbound.webclient.github.dto.GetAccessTokenResponse;
import com.jaeeunyoo.outbound.webclient.github.dto.GetUserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
@RequiredArgsConstructor
public class GithubApiClient {

    public GetAccessTokenResponse getAccessToken(final String authorizationCode) {
        return WebClient.create("https://github.com")
            .get()
            .uri(uriBuilder -> uriBuilder.path("/login/oauth/access_token")
                .queryParam("client_id", "6a5ea0dfd6893cf7bbf9")
                .queryParam("client_secret", "1761c0cf53ccf6bdf1061f6ea4e989f0293681d1")
                .queryParam("code", authorizationCode)
                .build())
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .bodyToMono(GetAccessTokenResponse.class)
            .block();
    }

    public GetUserResponse getUser(final String authorizationHeader) {
        return WebClient.create("https://api.github.com")
            .get()
            .uri(uriBuilder -> uriBuilder.path("/user").build())
            .headers((httpHeaders -> httpHeaders.add("Authorization", authorizationHeader)))
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .bodyToMono(GetUserResponse.class)
            .block();
    }
}
