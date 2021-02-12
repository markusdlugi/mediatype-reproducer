package com.example.haljson.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Entity {
    @JsonProperty
    private String quarkus;

    public Entity(final String quarkus) {
        this.quarkus = quarkus;
    }
}
