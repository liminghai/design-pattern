package com.example.demo.designpattern.factory.demo3;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

/**
 * 因为工厂类只包含方法，不包含成员变量，完全可以复用
 * 当我们需要添加新的规则配置解析器的时候，我们只需要创建新的parser类和parser factory类，
 * 并且在RuleConfigParserFactoryMap类中，将新的parser factory对象添加到cachedFactories中即可。
 * @author limh
 * @version 2020年05月17日 19:15 limh Exp $
 */
public class RuleConfigParserFactoryMap {

    private static final Map<String, IRuleConfigParserFactory> cachedFactories = new HashMap<>();

    static {
        cachedFactories.put("json", new JsonRuleConfigParserFactory());
        cachedFactories.put("xml", new XmlRuleConfigParserFactory());
        cachedFactories.put("yaml", new YamlRuleConfigParserFactory());
        cachedFactories.put("properties", new PropertiesRuleConfigParserFactory());
    }

    public static IRuleConfigParserFactory getParserFactory(String type){
        if(StringUtils.isEmpty(type)){
            return null;
        }

        IRuleConfigParserFactory parserFactory = cachedFactories.get(type);
        return parserFactory;
    }
}
