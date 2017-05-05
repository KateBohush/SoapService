package com.epam.web.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="fault")
public class UserActionWSStatusFault extends UserActionWSStatus{
    private String message;


    public UserActionWSStatusFault() {
    }

    public UserActionWSStatusFault(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
