package com.assurity.assignment.framework.model.api.response.category;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Java model object for 'ListingFeeTier' json
 */
public class ListingFeeTier {
    @JsonProperty("MinimumTierPrice")
    private Integer minimumTierPrice;
    @JsonProperty("FixedFee")
    private Double fixedFee;

    @JsonProperty("MinimumTierPrice")
    public Integer getMinimumTierPrice() {
        return minimumTierPrice;
    }

    @JsonProperty("MinimumTierPrice")
    public void setMinimumTierPrice(Integer minimumTierPrice) {
        this.minimumTierPrice = minimumTierPrice;
    }

    @JsonProperty("FixedFee")
    public Double getFixedFee() {
        return fixedFee;
    }

    @JsonProperty("FixedFee")
    public void setFixedFee(Double fixedFee) {
        this.fixedFee = fixedFee;
    }
}
