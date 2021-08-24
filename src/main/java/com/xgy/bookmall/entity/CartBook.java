package com.xgy.bookmall.entity;

public class CartBook{

    public int uId;
    public int bId;
    public String bName;
    public int bPrice;
    public String bUri;
    public int bNum;

    public CartBook(int uId, int bId, String bName, int bPrice, String bUri, int bNum) {
        this.uId = uId;
        this.bId = bId;
        this.bName = bName;
        this.bPrice = bPrice;
        this.bUri = bUri;
        this.bNum = bNum;
    }
}
