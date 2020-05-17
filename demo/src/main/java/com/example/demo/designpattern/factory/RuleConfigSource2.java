package com.example.demo.designpattern.factory;

import com.example.demo.designpattern.factory.config.IRuleConfigParser;
import com.example.demo.designpattern.factory.config.InvalidRuleConfigException;
import com.example.demo.designpattern.factory.config.JsonRuleConfigParser;
import com.example.demo.designpattern.factory.config.PropertiesRuleConfigParser;
import com.example.demo.designpattern.factory.config.RuleConfig;
import com.example.demo.designpattern.factory.config.XmlRuleConfigParser;
import com.example.demo.designpattern.factory.config.YamlRuleConfigParser;

/**
 * 2. 为了让代码逻辑更加清晰，可读性更好，我们要善于将功能独立的代码块封装成函数。
 * 按照这个思路，我们可以将代码中涉及parser创建的部分逻辑抽离出来，抽象成createParser()函数。
 */
public class RuleConfigSource2 {

    public RuleConfig load(String ruleConfigFilePath) {

        String ruleConfigFileExtension = getFileExtension(ruleConfigFilePath);

        // FIXME 抽象成createParser()函数
        IRuleConfigParser parser = createParser(ruleConfigFileExtension);

        String configText = "";
        //从ruleConfigFilePath文件中读取配置文本到configText中
        RuleConfig ruleConfig = parser.parse(configText);
        return ruleConfig;
    }

    /**
     * 将代码中涉及parser创建的部分逻辑抽离出来，抽象成createParser()函数
     * @param configFormat
     * @return
     */
    private IRuleConfigParser createParser(String configFormat) {
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

    private String getFileExtension(String filePath) {
        //...解析文件名获取扩展名，比如rule.json，返回json
        return "json";
    }
}
 