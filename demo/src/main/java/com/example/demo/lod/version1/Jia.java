package com.example.demo.lod.version1;

//甲
public class Jia {
    private Friend friend;

    // 和朋友玩
    public void play(Friend friend) {
        friend.play();
    }

    // 和陌生人玩
    public void playStranger(Friend friend) {
        friend.playWithStranger();
    }

    public Friend getFriend() {
        return friend;
    }

    public void setFriend(Friend friend) {
        this.friend = friend;
    }
}