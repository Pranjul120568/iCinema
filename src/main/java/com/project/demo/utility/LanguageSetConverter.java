package com.project.demo.utility;

import com.project.demo.enums.Language;
import jakarta.persistence.AttributeConverter;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class LanguageSetConverter implements AttributeConverter<Set<Language>,String> {
    @Override
    public String convertToDatabaseColumn(Set<Language> attribute) {
        if(attribute == null || attribute.isEmpty()) return "";
        return attribute.stream().map(Language::name)
                .collect(Collectors.joining());
    }

    @Override
    public Set<Language> convertToEntityAttribute(String dbData) {
        if(dbData == null || dbData.isEmpty()) return Set.of();

        return Arrays.stream(dbData.split(","))
                .map(Language::valueOf)
                .collect(Collectors.toSet());
    }
}
