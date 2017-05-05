package com.epam.web.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "success")
public class UserActionWSStatusSuccess extends UserActionWSStatus {
    private String message;

    public UserActionWSStatusSuccess() {
    }

    public UserActionWSStatusSuccess(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
