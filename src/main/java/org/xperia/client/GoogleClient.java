package org.xperia.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.xperia.models.google.GoogleTokenResponse;

@Component
public class GoogleClient {

    private final RestTemplate restTemplate;

    @Autowired
    public GoogleClient(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    /**
     * The function fetches all labels of the user's gmail account. The response would contain list of labels and their corresponding id's
     * @param accessToken The google oauth token of the user
     * @return list of labels and their ids in string format
     */
    public String getLabelIds(String accessToken){

        String url = "https://gmail.googleapis.com/gmail/v1/users/me/labels";
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setBearerAuth(accessToken);

        HttpEntity<Void> request = new HttpEntity<>(httpHeaders);
        ResponseEntity<String> response =
                restTemplate.exchange(
                        url,
                        HttpMethod.GET,
                        request,
                        String.class
                );
        return response.getBody();
    }

    /**
     * The function fetches all the gmail messages based on the labelId provided
     * @param accessToken The google oauth token of the user
     * @param labelId The labelId based on which the gmail messages needs to be fetched
     * @return The list of messages (message id's) in string format
     */
    public String getMessages(String accessToken, String labelId){

        String url = "https://gmail.googleapis.com/gmail/v1/users/me/messages" +
                "?labelIds=" + labelId;
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setBearerAuth(accessToken);

        HttpEntity<Void> request = new HttpEntity<>(httpHeaders);

        ResponseEntity<String> response =
                restTemplate.exchange(
                        url,
                        HttpMethod.GET,
                        request,
                        String.class
                );
        return response.getBody();
    }

    public GoogleTokenResponse refreshAccessToken(String refreshToken, String clientId, String clientSecret){

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("client_id", clientId);
        body.add("client_secret", clientSecret);
        body.add("refresh_token", refreshToken);
        body.add("grant_type", "refresh_token");

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(body, httpHeaders);
        ResponseEntity<GoogleTokenResponse> response =
                restTemplate.exchange(
                        "https://oauth2.googleapis.com/token",
                        HttpMethod.POST,
                        request,
                        GoogleTokenResponse.class
                );
        GoogleTokenResponse tokenResponse = response.getBody();
        if (tokenResponse == null || tokenResponse.getAccessToken() == null) {
            throw new IllegalStateException(
                    "Failed to refresh Google access token"
            );
        }
        return tokenResponse;
    }
}
