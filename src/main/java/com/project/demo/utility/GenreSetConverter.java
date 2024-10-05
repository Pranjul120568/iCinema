package com.project.demo.utility;

import com.project.demo.enums.Genre;
import jakarta.persistence.AttributeConverter;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class GenreSetConverter implements AttributeConverter<Set<Genre>,String> {
    @Override
    public String convertToDatabaseColumn(Set<Genre> attribute) {
        if(attribute == null || attribute.isEmpty()) return "";
        return attribute.stream().map(Genre::name)
                .collect(Collectors.joining());
    }

    @Override
    public Set<Genre> convertToEntityAttribute(String dbData) {
        if(dbData == null || dbData.isEmpty()) return Set.of();

        return Arrays.stream(dbData.split(","))
                .map(Genre::valueOf)
                .collect(Collectors.toSet());
    }
}
