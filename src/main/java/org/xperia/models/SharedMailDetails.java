package org.xperia.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SharedMailDetails {

    private String historyId;

    private Long lastSynced;

    private String userId;

    private String userEmail;

}
