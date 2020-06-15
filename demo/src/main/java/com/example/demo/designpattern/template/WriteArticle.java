package com.example.demo.designpattern.template;

public abstract class WriteArticle {
    
    // 前言
    protected void introduction() {
        System.out.println("只有光头才能变强");
    }

    /**
     * 实际要写的内容，每个人的“实际内容”都不一样，所以抽象(abstract)
     */
    protected abstract void actualContent();

    // 最后
    protected void theLast() {
        System.out.println("更多内容，请关注我的公众号：xxx");

    }

    // 写一篇完整的文章(为了方便调用，我们将这几个步骤分装成一个方法)
    public final void writeAnCompleteArticle() {
        // 前言
        introduction();

        // 实际内容
        actualContent();

        // 最后
        theLast();
    }
}