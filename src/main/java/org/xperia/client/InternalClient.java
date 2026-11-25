package org.xperia.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.xperia.models.SharedMailDetails;
import org.xperia.models.SharedUserSetting;
import org.xperia.models.UserOauthToken;

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
            ResponseEntity<SharedUserSetting> response = this.executeGet(url, httpHeaders, SharedUserSetting.class);
            return response.getBody();
        }catch (Exception ex){
            LOGGER.error("Error fetching user settings from tracker service : {}", ex.getMessage(), ex);
            throw ex;
        }
    }

    public SharedMailDetails findMailDetailsOfUser(String email) {

        String url = trackerUrl + "/api/internal/user/mailDetails"
                + "?email=" + URLEncoder.encode(email, StandardCharsets.UTF_8);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setBasicAuth(username, password);
        try{
            ResponseEntity<SharedMailDetails> response = this.executeGet(url, httpHeaders, SharedMailDetails.class);
            return response.getBody();
        }catch (Exception ex){
            LOGGER.error("Error fetching user mail details from tracker services : {}", ex.getMessage(), ex);
            throw ex;
        }
    }

    public UserOauthToken refreshOauth2Token(String email){

        String url = trackerUrl + "/api/internal/refresh/token" + "?email=" + URLEncoder.encode(email, StandardCharsets.UTF_8);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setBasicAuth(username, password);

        try{
            ResponseEntity<UserOauthToken> response = this.executePost(url, null, httpHeaders, UserOauthToken.class);
            return response.getBody();
        }catch (Exception ex){
            LOGGER.error("Error refreshing token using Internal Client : {}", ex.getMessage(), ex);
            throw ex;
        }
    }

    public List<UserOauthToken> findAllAuthTokens(){

        String url = trackerUrl + "/api/internal/users/google";
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setBasicAuth(username, password);
        HttpEntity<Void> request = new HttpEntity<>(httpHeaders);
        try{
            ResponseEntity<List<UserOauthToken>> response =
                    restTemplate.exchange(
                            url,
                            HttpMethod.GET,
                            request,
                            new ParameterizedTypeReference<>() {}
                    );
            return response.getBody();
        }catch (Exception ex){
            LOGGER.error("Error fetching oauth tokens from tracker : {}", ex.getMessage(), ex);
            return null;
        }
    }

    public UserOauthToken findUserAuthToken(String userId){

        String url = trackerUrl + "/api/internal/users/google?userId=" + userId;
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setBasicAuth(username, password);
        HttpEntity<Void> request = new HttpEntity<>(httpHeaders);
        try{
            ResponseEntity<UserOauthToken> response =
                    restTemplate.exchange(
                            url,
                            HttpMethod.GET,
                            request,
                            UserOauthToken.class
                    );
            return response.getBody();
        }catch (Exception ex){
            LOGGER.error("Error fetching user oauth token from tracker : {}", ex.getMessage(), ex);
            return null;
        }
    }
}
