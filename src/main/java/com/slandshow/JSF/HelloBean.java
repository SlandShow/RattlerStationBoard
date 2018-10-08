package com.slandshow.JSF;

import com.slandshow.Recv;

import javax.faces.bean.ManagedBean;
import javax.inject.Named;

@ManagedBean
public class HelloBean {

    private Recv listener = new Recv();
    private String value = "HELLO WORLD!!!!!!!!!!!!!!!";

    public String getValue() {
        try {
            listener.recieve();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }

    public void setValue(String value) {
        try {
            listener.recieve();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.value = value;
    }
}
