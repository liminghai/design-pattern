package com.example.demo.designpattern.factory.demo1;

import com.example.demo.designpattern.factory.config.IRuleConfigParser;
import com.example.demo.designpattern.factory.config.InvalidRuleConfigException;
import com.example.demo.designpattern.factory.config.JsonRuleConfigParser;
import com.example.demo.designpattern.factory.config.PropertiesRuleConfigParser;
import com.example.demo.designpattern.factory.config.XmlRuleConfigParser;
import com.example.demo.designpattern.factory.config.YamlRuleConfigParser;

/**
 * 简单工厂
 * 3.为了让类的职责更加单一、代码更加清晰，
 * 我们还可以进一步将createParser()函数剥离到一个独立的类中，让这个类只负责对象的创建，
 * 而这个类就是我们现在要讲的简单工厂模式类。
 *
 * @author limh
 * @version 2020年05月16日 21:49 limh Exp $
 */
public class SimpleFactory {

    public static IRuleConfigParser createParser(String configFormat) {
        IRuleConfigParser parser;
        if ("json".equalsIgnoreCase(configFormat)) {
            parser = new JsonRuleConfigParser();
        } else if ("xml".equalsIgnoreCase(configFormat)) {
            parser = new XmlRuleConfigParser();
        } else if ("yaml".equalsIgnoreCase(configFormat)) {
            parser = new YamlRuleConfigParser();
        } else if ("properties".equalsIgnoreCase(configFormat)) {
            parser = new PropertiesRuleConfigParser();
        } else {
            throw new InvalidRuleConfigException(
                "Rule config file format is not supported: " + configFormat);
        }
        return parser;
    }
}
