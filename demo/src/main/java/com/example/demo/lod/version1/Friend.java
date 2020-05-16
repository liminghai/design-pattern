package com.example.demo.lod.version1;

//朋友
public class Friend {
    public void play(){
        System.out.println("朋友");
    }
    
    public void playWithStranger() {
        Stranger stranger = new Stranger();
        stranger.play();
    }
}