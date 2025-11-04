package org.xperia.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class MFSchemeDetailSearchUIResponseModel {

    private String code;

    private String type;

    private String category;

    private String fundHouse;

    private String name;

    private Double growth;

    private Double growthPercent;


}
