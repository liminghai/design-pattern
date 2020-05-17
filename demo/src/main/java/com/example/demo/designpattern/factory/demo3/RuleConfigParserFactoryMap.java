package com.example.demo.designpattern.factory.demo3;

import java.util.HashMap;
import java.util.Map;

/**
 * 因为工厂类只包含方法，不包含成员变量，完全可以复用
 * @author limh
 * @version 2020年05月17日 19:15 limh Exp $
 */
public class RuleConfigParserFactoryMap {

    private static final Map<String, IRuleConfigParserFactory> cachedFactories = new HashMap<>();

    static {
        cachedFactories.put("json", new JsonRuleConfigParserFactory());
        cachedFactories.put("xml", new XmlRuleConfigParserFactory());
        cachedFactories.put("yaml", new YamlRuleConfigParserFactory());
        cachedFactories.put(p v)
    }
}
