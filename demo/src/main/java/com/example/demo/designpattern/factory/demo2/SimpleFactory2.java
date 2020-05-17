package com.example.demo.designpattern.factory.demo2;

import java.util.HashMap;
import java.util.Map;

import com.example.demo.designpattern.factory.config.IRuleConfigParser;
import com.example.demo.designpattern.factory.config.InvalidRuleConfigException;
import com.example.demo.designpattern.factory.config.JsonRuleConfigParser;
import com.example.demo.designpattern.factory.config.PropertiesRuleConfigParser;
import com.example.demo.designpattern.factory.config.XmlRuleConfigParser;
import com.example.demo.designpattern.factory.config.YamlRuleConfigParser;
import org.apache.commons.lang3.StringUtils;

/**
 * 简单工厂+单例
 *
 * 4.在简单工厂中，我们每次调用RuleConfigParserFactory的createParser()的时候，都要创建一个新的parser。
 * 实际上，如果parser可以复用，为了节省内存和对象创建的时间，我们可以将parser事先创建好缓存起来。
 * 当调用createParser()函数的时候，我们从缓存中取出parser对象直接使用。
 *
 * @author limh
 * @version 2020年05月16日 21:49 limh Exp $
 */
public class SimpleFactory2 {

    private static final Map<String, IRuleConfigParser> cachedParsers = new HashMap<>();

    static {
        cachedParsers.put("json", new JsonRuleConfigParser());
        cachedParsers.put("xml", new XmlRuleConfigParser());
        cachedParsers.put("yaml", new YamlRuleConfigParser());
        cachedParsers.put("properties", new PropertiesRuleConfigParser());
    }

    public static IRuleConfigParser createParser(String configFormat) {
        if (StringUtils.isEmpty(configFormat)){
            throw new InvalidRuleConfigException(
                "Rule config file format is not supported: " + configFormat);
        }
        IRuleConfigParser parser = cachedParsers.get(configFormat);
        return parser;
    }
}
