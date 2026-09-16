package org.xperia.models.google;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GoogleProfileResponse {

    private String emailAddress;

    private Long messagesTotal;

    private Long threadsTotal;

    private String historyId;
}
