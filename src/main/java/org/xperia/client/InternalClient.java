package org.xperia.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.xperia.models.SharedMailDetails;
import org.xperia.models.SharedUserSetting;
import org.xperia.models.UserOauthToken;
import org.xperia.models.response.SuccessResponse;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

//TODO To be used completely replacing InternalClient for single packages
@Component
public class InternalClient extends AbstractHttpClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(InternalClient.class);

    @Value("${xpense.internal.tracker.url}")
    private String trackerUrl;

    @Value("${xpense.internal.tracker.username}")
    private String username;

    @Value("${xpense.internal.tracker.password}")
    private String password;

    private final RestTemplate restTemplate;


    @Autowired
    public InternalClient(RestTemplate restTemplate){
        super(restTemplate);
        this.restTemplate = restTemplate;
    }

    //TODO Move the settingsType to common package and use the proper type here
    public SharedUserSetting findUserSettingByType(String email, String type){

        String url = trackerUrl + "/api/internal/user/settings"
                + "?email=" + URLEncoder.encode(email, StandardCharsets.UTF_8)
                + "&settingsType=mailLabelId";
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setBasicAuth(username, password);
        try{
            ResponseEntity<SuccessResponse<SharedUserSetting>> response = this.executeGet(
                    url,
                    httpHeaders,
                    new ParameterizedTypeReference<>() {}
            );
            if (response.getBody() != null){
                return response.getBody().getData();
            }
            LOGGER.error("findUserSettingByType response returned body as null");
        }catch (Exception ex){
            LOGGER.error("Error fetching user settings from tracker service : {}", ex.getMessage(), ex);
        }
        return null;
    }

    public SharedMailDetails findMailDetailsOfUser(String email) {

        String url = trackerUrl + "/api/internal/user/mailDetails"
                + "?email=" + URLEncoder.encode(email, StandardCharsets.UTF_8);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setBasicAuth(username, password);
        try{
            ResponseEntity<SuccessResponse<SharedMailDetails>> response = this.executeGet(
                    url,
                    httpHeaders,
                    new ParameterizedTypeReference<>() {}
            );
            if (response.getBody() != null){
                return response.getBody().getData();
            }
            LOGGER.error("findMailDetailsOfUser response returned body as null");
        }catch (Exception ex){
            LOGGER.error("Error fetching user mail details from tracker services : {}", ex.getMessage(), ex);
        }
        return null;
    }

    public UserOauthToken refreshOauth2Token(String email){

        String url = trackerUrl + "/api/internal/refresh/token" + "?email=" + URLEncoder.encode(email, StandardCharsets.UTF_8);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setBasicAuth(username, password);

        try{
            ResponseEntity<SuccessResponse<UserOauthToken>> response = this.executePost(
                    url,
                    null,
                    httpHeaders,
                    new ParameterizedTypeReference<>() {}
            );
            if (response.getBody() != null){
                return response.getBody().getData();
            }
            LOGGER.error("refreshOauth2Token response returned body as null");
        }catch (Exception ex){
            LOGGER.error("Error refreshing token using Internal Client : {}", ex.getMessage(), ex);
        }
        return null;
    }

    public List<UserOauthToken> findAllAuthTokens(){

        String url = trackerUrl + "/api/internal/users/google";
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setBasicAuth(username, password);
        try{
            ResponseEntity<SuccessResponse<List<UserOauthToken>>> response = this.executeGet(
                    url,
                    httpHeaders,
                    new ParameterizedTypeReference<>() {}
            );
            if (response.getBody() != null){
                return response.getBody().getData();
            }
            LOGGER.error("find auth tokens response returned body as null");
        }catch (Exception ex){
            LOGGER.error("Error fetching oauth tokens from tracker : {}", ex.getMessage(), ex);
        }
        return null;
    }

    public UserOauthToken findUserAuthToken(String userId){

        String url = trackerUrl + "/api/internal/users/google?userId=" + userId;
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setBasicAuth(username, password);
        HttpEntity<Void> request = new HttpEntity<>(httpHeaders);
        try{
            ResponseEntity<SuccessResponse<UserOauthToken>> response = this.executeGet(
                    url,
                    httpHeaders,
                    new ParameterizedTypeReference<>() {}
            );
            if (response.getBody() != null){
                return response.getBody().getData();
            }
            LOGGER.error("findUserAuthToken response returned body as null");
        }catch (Exception ex){
            LOGGER.error("Error fetching user oauth token from tracker : {}", ex.getMessage(), ex);
        }
        return null;
    }
}
