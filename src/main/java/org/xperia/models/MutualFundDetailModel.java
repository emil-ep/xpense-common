package org.xperia.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

public class MutualFundDetailModel implements Serializable {

    @JsonProperty("meta")
    private MutualFundMetaData meta;

    @JsonProperty("data")
    private List<MutualFundDailyData> data;

    public MutualFundDetailModel(){

    }

    public MutualFundDetailModel(MutualFundMetaData meta, List<MutualFundDailyData> data){
        this.meta = meta;
        this.data = data;
    }

    public MutualFundMetaData getMeta() {
        return meta;
    }

    public void setMeta(MutualFundMetaData meta) {
        this.meta = meta;
    }

    public List<MutualFundDailyData> getData() {
        return data;
    }

    public void setData(List<MutualFundDailyData> data) {
        this.data = data;
    }
}
