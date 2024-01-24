package com.estoutic.pollsbackend.models.category.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum CategoryType {

    CLASSIC("classic");

    private String title;


    CategoryType(String title) {
        this.title = title;
    }

    @JsonValue
    public String getTitle() {
        return title;
    }
}
