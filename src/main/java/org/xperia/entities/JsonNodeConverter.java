package org.xperia.entities;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.postgresql.util.PGobject;

@Converter(autoApply = false)
public class JsonNodeConverter implements AttributeConverter<JsonNode, PGobject> {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public PGobject convertToDatabaseColumn(JsonNode attribute) {
        if (attribute == null) return null;

        try {
            PGobject jsonObject = new PGobject();
            jsonObject.setType("jsonb");
            jsonObject.setValue(attribute == null ? null : objectMapper.writeValueAsString(attribute));
            return jsonObject;
        } catch (Exception e) {
            throw new RuntimeException("Could not convert JsonNode to PGobject", e);
        }
    }

    @Override
    public JsonNode convertToEntityAttribute(PGobject dbData) {

        try {
            return dbData == null || dbData.getValue() == null
                    ? null
                    : objectMapper.readTree(dbData.getValue());
        } catch (Exception e) {
            throw new RuntimeException("Could not convert PGobject to JsonNode", e);
        }
    }
}
