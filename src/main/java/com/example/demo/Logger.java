package com.example.demo;

import java.util.Date;

public class Logger {
    public void before() {
        System.out.printf("[INFO][%s][before advice]\n", new Date());
    }

    public void after() {
        System.out.printf("[INFO][%s][after advice]\n", new Date());
    }

    public void afterReturning(Object retVal) {
        System.out.printf("[INFO][%s][afterReturning advice][%s]\n", new Date(), retVal);
    }
}
