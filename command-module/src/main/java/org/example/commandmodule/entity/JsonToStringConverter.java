package org.example.commandmodule.entity;


import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class JsonToStringConverter implements AttributeConverter<String, String> {

    @Override
    public String convertToDatabaseColumn(String attribute) {
        return attribute; // 이미 JSON string
    }

    @Override
    public String convertToEntityAttribute(String dbData) {
        return dbData;
    }
}