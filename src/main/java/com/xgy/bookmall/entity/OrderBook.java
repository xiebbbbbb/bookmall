package com.xgy.bookmall.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderBook {
    private int oId;
    private int bId;
    private int bNum;

    public OrderBook(int oId, int bId, int bNum) {
        this.oId = oId;
        this.bId = bId;
        this.bNum = bNum;
    }

}
