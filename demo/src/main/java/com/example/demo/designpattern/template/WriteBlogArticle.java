package com.example.demo.designpattern.template;

public class WriteBlogArticle extends WriteArticle{

    @Override
    protected void actualContent() {
        System.out.println("=====我要开始写blog啦=====");
    }
}