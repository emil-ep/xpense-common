package org.xperia.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.xperia.models.google.GoogleMailLabelResponse;
import org.xperia.models.google.GoogleTokenResponse;

@Component
public class GoogleClient extends AbstractHttpClient{


    @Autowired
    public GoogleClient(RestTemplate restTemplate){
        super(restTemplate);
    }

    /**
     * The function fetches all labels of the user's gmail account. The response would contain list of labels and their corresponding id's
     * @param accessToken The google oauth token of the user
     * @return list of labels and their ids in string format
     */
    public GoogleMailLabelResponse getLabelIds(String accessToken){

        String url = "https://gmail.googleapis.com/gmail/v1/users/me/labels";
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setBearerAuth(accessToken);

        ResponseEntity<GoogleMailLabelResponse> response = executeGet(url, httpHeaders, GoogleMailLabelResponse.class);
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

        ResponseEntity<String> response = executeGet(url, httpHeaders, String.class);
        return response.getBody();
    }

    public GoogleTokenResponse refreshAccessToken(String refreshToken, String clientId, String clientSecret){

        String url = "https://oauth2.googleapis.com/token";
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("client_id", clientId);
        body.add("client_secret", clientSecret);
        body.add("refresh_token", refreshToken);
        body.add("grant_type", "refresh_token");

        ResponseEntity<GoogleTokenResponse> response = executePost(url, body, httpHeaders, GoogleTokenResponse.class);
        GoogleTokenResponse tokenResponse = response.getBody();
        if (tokenResponse == null || tokenResponse.getAccessToken() == null) {
            throw new IllegalStateException(
                    "Failed to refresh Google access token"
            );
        }
        return tokenResponse;
    }
}
