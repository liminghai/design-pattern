package com.example.demo.singleton;

import java.lang.reflect.Constructor;

import org.apache.commons.lang3.SerializationUtils;

/**
 * @author limh
 * @version 2020年05月13日 20:47 limh Exp $
 */
public class Test {

    public static void main(String[] args) throws Exception {
        EnumSingleton s = EnumSingleton.INSTANCE;

        // 拿到所有的构造函数，包括非public的
        Constructor<EnumSingleton> constructor = EnumSingleton.class.getDeclaredConstructor(String.class, int.class);// 拿到有参的构造器;
        constructor.setAccessible(true);
        // 使用空构造函数new一个实例。即使它是private的~~~
        System.out.println("拿到了构造器：" + constructor);
        // 使用空构造函数new一个实例。即使它是private的~~~
        EnumSingleton sReflection = constructor.newInstance("testInstance", 1);

        System.out.println(s); //com.example.demo.singleton.EnumSingleton@1f32e575
        System.out.println(sReflection); //com.example.demo.singleton.EnumSingleton@279f2327
        System.out.println(s == sReflection); // false
    }

}
