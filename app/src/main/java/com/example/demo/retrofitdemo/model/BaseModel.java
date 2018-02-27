package com.example.demo.retrofitdemo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * base model class for storing status & message of webservice response.
 */
public class BaseModel {

    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("messages")
    @Expose
    private String messages;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessages() {
        return messages;
    }

    public void setMessages(String messages) {
        this.messages = messages;
    }
}
