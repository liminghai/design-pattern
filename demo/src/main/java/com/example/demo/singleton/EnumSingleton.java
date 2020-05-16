package com.example.demo.singleton;

/**
 * Java不允许你创建一个扩展enum类型的类。因此，枚举本身总是最终的，所以使用final关键字是多余的。
 *
 * 当然，从某种意义上说，enums不是最终的，因为您可以为枚举描述符内的每个字段定义一个匿名子类。
 * 但是使用final关键字来防止这些类型的描述是没有什么意义的，因为人们必须在同一个.java文件中创建这些子类，
 * 并且有权这样做的任何人都可以轻松地移除final关键字。有没有人在其他包中扩展枚举的风险。
 */
public enum EnumSingleton {
    INSTANCE;    
}