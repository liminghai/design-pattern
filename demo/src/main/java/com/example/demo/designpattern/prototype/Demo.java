package com.example.demo.designpattern.prototype;

/**
 * @author limh
 * @version 2020年05月21日 16:11 limh Exp $
 */
public class Demo {

    public static void main(String[] args) {
        Mail mail = new Mail("content", "subject");
        mail.setTail("xxx版权所有");

        for (int i = 0; i < 3; i++) {
            Mail cloneMail = mail.clone();
            cloneMail.setAppellation(i+"先生");
        }

    }
}
