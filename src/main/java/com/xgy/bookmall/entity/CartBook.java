package com.xgy.bookmall.entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.annotations.Param;

@Data
@NoArgsConstructor
public class CartBook{

    private int uId;
    private int bId;
    private String bName;
    private int bPrice;
    private String bUri;
    private int bNum;
    private int status;

    public CartBook(int uId, int bId, String bName, int bPrice, String bUri, int bNum, int status) {
        this.uId = uId;
        this.bId = bId;
        this.bName = bName;
        this.bPrice = bPrice;
        this.bUri = bUri;
        this.bNum = bNum;
        this.status = status;
    }

    public int getbId() {
        return bId;
    }

    public int getbNum() {
        return bNum;
    }

    public int getbPrice() {
        return bPrice;
    }

    public int getuId() {
        return uId;
    }

    public String getbName() {
        return bName;
    }

    public String getbUri() {
        return bUri;
    }

    public int getStatus() {
        return status;
    }
}
