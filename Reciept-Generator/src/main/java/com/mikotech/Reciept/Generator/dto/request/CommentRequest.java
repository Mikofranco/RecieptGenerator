package com.mikotech.Reciept.Generator.dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CommentRequest {
    private  String message;
    private long userId;
    private long productId;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }
}
