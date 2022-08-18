package com.assurity.assignment.framework.model.api.response.category;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Java model object for 'Promotion' json
 */
public class Promotion {
    @JsonProperty("Id")
    private Integer id;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("Description")
    private String description;
    @JsonProperty("Price")
    private Double price;
    @JsonProperty("MinimumPhotoCount")
    private Integer minimumPhotoCount;
    @JsonProperty("OriginalPrice")
    private Double originalPrice;
    @JsonProperty("Recommended")
    private Boolean recommended;

    @JsonProperty("Id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("Id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("Name")
    public String getName() {
        return name;
    }

    @JsonProperty("Name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("Description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("Description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("Price")
    public Double getPrice() {
        return price;
    }

    @JsonProperty("Price")
    public void setPrice(Double price) {
        this.price = price;
    }

    @JsonProperty("MinimumPhotoCount")
    public Integer getMinimumPhotoCount() {
        return minimumPhotoCount;
    }

    @JsonProperty("MinimumPhotoCount")
    public void setMinimumPhotoCount(Integer minimumPhotoCount) {
        this.minimumPhotoCount = minimumPhotoCount;
    }

    @JsonProperty("OriginalPrice")
    public Double getOriginalPrice() {
        return originalPrice;
    }

    @JsonProperty("OriginalPrice")
    public void setOriginalPrice(Double originalPrice) {
        this.originalPrice = originalPrice;
    }

    @JsonProperty("Recommended")
    public Boolean getRecommended() {
        return recommended;
    }

    @JsonProperty("Recommended")
    public void setRecommended(Boolean recommended) {
        this.recommended = recommended;
    }
}
