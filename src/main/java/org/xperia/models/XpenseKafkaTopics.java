package org.xperia.models;

public enum XpenseKafkaTopics {

    SCHEME_DETAIL("scheme_detail"),
    MF_SCHEME("mf_scheme"),
    MAIL_MESSAGE_ID("mail_message_id");

    private String name;

    XpenseKafkaTopics(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
