package com.fiap.store_flow.dto;

import com.fiap.store_flow.entities.Product;

public class ProductMinDTO {
    private Long id;
    private String name;
    private Double price;
    private String imgURL;

    public ProductMinDTO(Long id, String name,  Double price, String imgURL) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.imgURL = imgURL;
    }

    public ProductMinDTO(Product entity){
        id = entity.getId();
        name = entity.getName();
        price = entity.getPrice();
        imgURL = entity.getImgUrl();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public String getImgURL() {
        return imgURL;
    }
}
