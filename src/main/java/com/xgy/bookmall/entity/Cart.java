package com.xgy.bookmall.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Cart {
    private int uId;
    private int bId;
    private int bNum;
    private int status;

    public Cart(int uId, int bId, int bNum, int status) {
        this.uId = uId;
        this.bId = bId;
        this.bNum = bNum;
        this.status = status;
    }

    public int getBNum() {
        return bNum;
    }

    public int getUId() {
        return uId;
    }

    public int getBId() {
        return bId;
    }

    public int getStatus() {
        return status;
    }
}
