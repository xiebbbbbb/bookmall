package com.xgy.bookmall.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Order {
    private int oId;
    private int uId;
    private float oTotalPrice;
    private String oAddress;
    private String oState;

    public Order(int oId, int uId, float oTotalPrice, String oAddress, String oState) {
        this.oId = oId;
        this.uId = uId;
        this.oTotalPrice = oTotalPrice;
        this.oAddress = oAddress;
        this.oState = oState;
    }
}
