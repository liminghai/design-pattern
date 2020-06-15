package com.example.demo.designpattern.template;

/**
 * @author limh
 * @version 2020年06月15日 20:55 limh Exp $
 */
public class Demo {

    public static void main(String[] args){
        // new子类
        WriteArticle writeArticle = new WriteBlogArticle();
        writeArticle.writeAnCompleteArticle();
    }
}
