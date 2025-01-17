package com.mikotech.Reciept.Generator.dto.response;

import lombok.Getter;

@Getter
public class RegisterResponse {
    private final String MESSAGE ="Registration Successful";

    public String getMESSAGE() {
        return MESSAGE;
    }
}
