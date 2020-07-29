package com.epam.ukolpakova.beans;

import lombok.Data;

@Data
public class Client {
    private String id;
    private String fullName;
    private String greeting;

    Client(String id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", greeting='" + greeting + '\'' +
                '}';
    }
}
