package com.example.demo.designpattern.factory.DI;

public interface ApplicationContext {
    Object getBean(String beanId);
}