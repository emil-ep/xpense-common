package org.xperia.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class MutualFundMetaData implements Serializable {

    @JsonProperty("fund_house")
    private String fundHouse;

    @JsonProperty("scheme_type")
    private String schemeType;

    @JsonProperty("scheme_category")
    private String schemeCategory;

    @JsonProperty("scheme_code")
    private String schemeCode;

    @JsonProperty("scheme_name")
    private String schemeName;

    @JsonProperty("isin_growth")
    private String isinGrowth;

    @JsonProperty("isin_div_reinvestment")
    private String isinDivReinvestment;

    public MutualFundMetaData(){

    }

    public MutualFundMetaData(String fundHouse, String schemeType, String schemeCategory, String schemeCode, String schemeName, String isinGrowth, String isinDivReinvestment) {
        this.fundHouse = fundHouse;
        this.schemeType = schemeType;
        this.schemeCategory = schemeCategory;
        this.schemeCode = schemeCode;
        this.schemeName = schemeName;
        this.isinGrowth = isinGrowth;
        this.isinDivReinvestment = isinDivReinvestment;
    }

    public String getFundHouse() {
        return fundHouse;
    }

    public void setFundHouse(String fundHouse) {
        this.fundHouse = fundHouse;
    }

    public String getSchemeType() {
        return schemeType;
    }

    public void setSchemeType(String schemeType) {
        this.schemeType = schemeType;
    }

    public String getSchemeCategory() {
        return schemeCategory;
    }

    public void setSchemeCategory(String schemeCategory) {
        this.schemeCategory = schemeCategory;
    }

    public String getSchemeCode() {
        return schemeCode;
    }

    public void setSchemeCode(String schemeCode) {
        this.schemeCode = schemeCode;
    }

    public String getSchemeName() {
        return schemeName;
    }

    public void setSchemeName(String schemeName) {
        this.schemeName = schemeName;
    }

    public String getIsinGrowth() {
        return isinGrowth;
    }

    public void setIsinGrowth(String isinGrowth) {
        this.isinGrowth = isinGrowth;
    }

    public String getIsinDivReinvestment() {
        return isinDivReinvestment;
    }

    public void setIsinDivReinvestment(String isinDivReinvestment) {
        this.isinDivReinvestment = isinDivReinvestment;
    }
}
