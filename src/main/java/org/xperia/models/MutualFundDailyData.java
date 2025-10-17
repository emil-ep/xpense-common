package org.xperia.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class MutualFundDailyData implements Serializable {

    @JsonProperty("date")
    private String date;

    @JsonProperty("nav")
    private String nav;

    public MutualFundDailyData() {
    }

    public MutualFundDailyData(String date, String nav) {
        this.date = date;
        this.nav = nav;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNav() {
        return nav;
    }

    public void setNav(String nav) {
        this.nav = nav;
    }
}
