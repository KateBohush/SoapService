package com.epam.web.model;

import com.epam.model.User;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;

@XmlAccessorType(XmlAccessType.FIELD)
public class UserActionWSResponse {

    @XmlElementRef(type = User.class)
    private Object result;

    @XmlElementRef(type = User.class)
    private Object[] results;

    @XmlElementRefs({ @XmlElementRef(type = UserActionWSStatusSuccess.class),
            @XmlElementRef(type = UserActionWSStatusFault.class) })
    private UserActionWSStatus status;

    public UserActionWSResponse() {
    }

    private UserActionWSResponse(UserActionWSStatus status, Object result) {
        this.result = result;
        this.status = status;
    }

    private UserActionWSResponse(UserActionWSStatus status, Object[] results) {
        this.results = results;
        this.status = status;
    }

    public UserActionWSResponse(UserActionWSStatus status) {
        this.status = status;
    }

    public Object getResult() {
        return result;
    }
    public Object[] getResults() {
        return results;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public static UserActionWSResponse success(String status, Object result) {
        return new UserActionWSResponse(new UserActionWSStatusSuccess(status), result);
    }

    public static UserActionWSResponse success(String status, Object[] results) {
        return new UserActionWSResponse(new UserActionWSStatusSuccess(status), results);
    }

    public static UserActionWSResponse fault(String status) {
        return new UserActionWSResponse(new UserActionWSStatusFault(status));
    }

}
