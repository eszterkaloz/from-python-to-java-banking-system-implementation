package com.codecool.frompythontojava.exercise3;


import java.util.UUID;

public class User {
    private UUID id;

    public User() {
        id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                '}';
    }
}
