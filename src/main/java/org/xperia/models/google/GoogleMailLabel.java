package org.xperia.models.google;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record GoogleMailLabel(String id, String name, String type) {

}
