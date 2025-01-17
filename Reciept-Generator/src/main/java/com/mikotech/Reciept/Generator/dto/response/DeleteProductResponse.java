package com.mikotech.Reciept.Generator.dto.response;

public class DeleteProductResponse {
    private long productId;
    private final String MESSAGE ="SUCCESSFULLY";

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }
}
