
package com.mukesh.bowling.models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class GenericResponse<T> {
    private String ststus;
    private T data;

    public String getStstus() {
        return ststus;
    }

    public void setStstus(String ststus) {
        this.ststus = ststus;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
