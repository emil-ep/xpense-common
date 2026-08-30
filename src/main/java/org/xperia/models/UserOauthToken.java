package org.xperia.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserOauthToken {

    private String id;

    private String accessToken;

    private String refreshToken;

    private Long expireTimestamp;

    private String userId;

    private String userEmail;


}
