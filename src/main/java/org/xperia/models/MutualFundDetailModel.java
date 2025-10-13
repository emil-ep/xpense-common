package org.xperia.models;

import java.io.Serializable;
import java.util.List;

public class MutualFundDetailModel implements Serializable {

    private String fundHouse;

    private String schemeType;

    private String schemeCategory;

    private String schemeCode;

    private String schemeName;

    private String isinGrowth;

    private String isinDivReinvestment;

    private List<MutualFundDailyData> data;

    public MutualFundDetailModel(){

    }

    public MutualFundDetailModel(String fundHouse, String schemeType, String schemeCategory,
                                 String schemeCode, String schemeName, String isinGrowth,
                                 String isinDivReinvestment, List<MutualFundDailyData> data){
        this.fundHouse = fundHouse;
        this.schemeType = schemeType;
        this.schemeCategory = schemeCategory;
        this.schemeCode = schemeCode;
        this.schemeName = schemeName;
        this.isinGrowth = isinGrowth;
        this.isinDivReinvestment = isinDivReinvestment;
        this.data = data;
    }

    public String getFundHouse() {
        return fundHouse;
    }

    public String getSchemeType() {
        return schemeType;
    }

    public String getSchemeCategory() {
        return schemeCategory;
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

    public List<MutualFundDailyData> getData() {
        return data;
    }
}
