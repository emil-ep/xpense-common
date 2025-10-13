package org.xperia.models;

public class MutualFundDailyData {

    private String date;

    private String nav;

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
