package org.xperia.models;

public enum XpenseKafkaTopics {

    SCHEME_DETAIL("scheme_detail"),
    MF_SCHEME("mf_scheme");

    private String name;

    XpenseKafkaTopics(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
