package com.example.demo;

public class Client {
    Service service;

    Client(Service service) {
        this.service = service;
    }

//    для сеттера можно использовать другой код смотри props.xml
//    public void setService(Service service) {
//        this.service = service;
//    }


    public void showMsg() {
        System.out.println(this.service.getMsg());
    }
}
