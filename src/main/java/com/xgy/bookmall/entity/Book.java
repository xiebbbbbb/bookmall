package com.xgy.bookmall.entity;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Book {

    private int bId;
    private String bName;
    private String bDescription;
    private String bAuthor;
    private String bTag;
    private double bPrice;
    private String bPublisher;
    private String bUri;

    public Book(int bId, String bName, String bDescription, String bAuthor, String bTag, int bPrice, String bPublisher, String bUri) {
        this.bId = bId;
        this.bName = bName;
        this.bDescription = bDescription;
        this.bAuthor = bAuthor;
        this.bTag = bTag;
        this.bPrice = bPrice;
        this.bPublisher = bPublisher;
        this.bUri = bUri;
    }

    public JSONObject toJSON(){
        JSONObject jObj = new JSONObject();
        jObj.put("bId", this.bId);
        jObj.put("bName", this.bName);
        jObj.put("bDescription", this.bDescription);
        jObj.put("bAuthor", this.bAuthor);
        jObj.put("bTag", this.bTag);
        jObj.put("bPrice", this.bPrice);
        jObj.put("bPublisher", this.bPublisher);
        jObj.put("bUri", this.bUri);
        return jObj;
    }
}
