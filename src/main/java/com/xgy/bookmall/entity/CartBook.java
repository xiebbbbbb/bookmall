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

    public CartBook(int uId, int bId, String bName, int bPrice, String bUri, int bNum) {
        this.uId = uId;
        this.bId = bId;
        this.bName = bName;
        this.bPrice = bPrice;
        this.bUri = bUri;
        this.bNum = bNum;
    }

}
