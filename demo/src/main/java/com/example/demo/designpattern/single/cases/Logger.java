package com.example.demo.designpattern.single.cases;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {

    private FileWriter writer;

    public Logger() {
        try {
            File file = new File("/Users/wangzheng/log.txt");
            //true表示追加写入
            writer = new FileWriter(file, true);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void log(String message) {
        try {
            writer.write(message);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}