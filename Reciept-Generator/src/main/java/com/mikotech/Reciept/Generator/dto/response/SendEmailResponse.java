package com.mikotech.Reciept.Generator.dto.response;

import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public class SendEmailResponse {
    private int statusCode;
    private String messageId;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }
}
