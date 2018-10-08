package com.slandshow.service;

import javax.ejb.Stateless;

@Stateless
public class HelloWorldBean {

    public String f() {
        return "Hello World bean!";
    }

    public String view() {
        return "hello.xhtml";
    }

}
