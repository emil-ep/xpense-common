package org.xperia.models;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SharedUserSetting {

    private String id;

    private String type;

    private String userEmail;

    private String userId;

    private JsonNode payload;


}
