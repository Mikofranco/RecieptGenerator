package com.mikotech.Reciept.Generator.dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public class Sender {
    private String name;
    private  String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
