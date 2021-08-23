package com.xgy.bookmall.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BookDetail {

    private int oId;
    private int bId;
    private int bNum;
    private String bName;
    private String bDescription;
    private String bAuthor;
    private String bTag;
    private int bPrice;
    private String bPublisher;
    private String bUri;

    public BookDetail(int oId, int bId,int bNum, String bName, String bDescription, String bAuthor, String bTag, int bPrice, String bPublisher, String bUri) {
        this.oId = oId;
        this.bId = bId;
        this.bNum = bNum;
        this.bName = bName;
        this.bDescription = bDescription;
        this.bAuthor = bAuthor;
        this.bTag = bTag;
        this.bPrice = bPrice;
        this.bPublisher = bPublisher;
        this.bUri = bUri;
    }
}
