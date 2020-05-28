package com.example.demo.designpattern.prototype;

/**
 * @author limh
 * @version 2020年05月21日 16:01 limh Exp $
 */
public class Mail implements Cloneable{

    // 收件人
    private String receiver;
    //邮件名称
    private String subject;
    //称谓
    private String appellation;
    //邮件内容
    private String content;
    //邮件尾部，一般都是加上"xxx版权所有"等信息
    private String tail;

    public Mail(String content, String subject){
        this.content = content;
        this.subject = subject;

    }

    @Override
    protected Mail clone() {
        Mail mail = null;

        try {
            mail = (Mail)super.clone();
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }

        return mail;
    }

    // 省流getter setter......

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getAppellation() {
        return appellation;
    }

    public void setAppellation(String appellation) {
        this.appellation = appellation;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTail() {
        return tail;
    }

    public void setTail(String tail) {
        this.tail = tail;
    }
}
