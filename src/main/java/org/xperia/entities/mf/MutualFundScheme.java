package org.xperia.entities.mf;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "mf_schemes")
@NoArgsConstructor
@Getter
public class MutualFundScheme {

    @Id
    private String code;

    private String name;

    private String isInGrowth;

    private String isInDivReInvestment;

    private Long lastUpdated;


    public MutualFundScheme(String code, String name, String isInGrowth, String isInDivReInvestment, Long lastUpdated){
        this.code = code;
        this.name = name;
        this.isInGrowth = isInGrowth;
        this.isInDivReInvestment = isInDivReInvestment;
        this.lastUpdated = lastUpdated;
    }
}
