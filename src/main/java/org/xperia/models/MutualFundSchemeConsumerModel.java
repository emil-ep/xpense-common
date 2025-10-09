package org.xperia.models;


import java.io.Serializable;

public class MutualFundSchemeConsumerModel implements Serializable {

    private String schemeCode;

    private String schemeName;

    private String isinGrowth;

    private String isinDivReinvestment;

    public MutualFundSchemeConsumerModel(){

    }

    public MutualFundSchemeConsumerModel(String schemeCode, String schemeName, String isinGrowth, String isinDivReinvestment){
        this.schemeCode = schemeCode;
        this.schemeName = schemeName;
        this.isinGrowth = isinGrowth;
        this.isinDivReinvestment = isinDivReinvestment;
    }

    public String getSchemeCode() {
        return schemeCode;
    }

    public String getSchemeName() {
        return schemeName;
    }

    public String getIsinGrowth() {
        return isinGrowth;
    }

    public String getIsinDivReinvestment() {
        return isinDivReinvestment;
    }

    @Override
    public String toString() {
        return "MutualFundScheme{" +
                "schemeCode='" + schemeCode + '\'' +
                ", schemeName='" + schemeName + '\'' +
                ", isinGrowth='" + isinGrowth + '\'' +
                ", isinDivReinvestment='" + isinDivReinvestment + '\'' +
                '}';
    }
}
