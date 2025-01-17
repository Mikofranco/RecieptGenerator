package com.mikotech.Reciept.Generator.dto.request;

import java.math.BigDecimal;

public class AddProductRequest {
    private String imageUrl;
    private String title;
    private String description;
    private int quantity;
    private BigDecimal amount;
    private Long productOwner;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Long getProductOwner() {
        return productOwner;
    }

    public void setProductOwner(Long productOwner) {
        this.productOwner = productOwner;
    }
}
