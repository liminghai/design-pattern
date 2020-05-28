package com.example.demo.designpattern.factory;

import com.example.demo.designpattern.factory.config.IRuleConfigParser;
import com.example.demo.designpattern.factory.config.InvalidRuleConfigException;
import com.example.demo.designpattern.factory.config.JsonRuleConfigParser;
import com.example.demo.designpattern.factory.config.PropertiesRuleConfigParser;
import com.example.demo.designpattern.factory.config.RuleConfig;
import com.example.demo.designpattern.factory.config.XmlRuleConfigParser;
import com.example.demo.designpattern.factory.config.YamlRuleConfigParser;
import com.example.demo.designpattern.factory.demo1.SimpleFactory;
import com.example.demo.designpattern.factory.demo3.IRuleConfigParserFactory;
import com.example.demo.designpattern.factory.demo3.RuleConfigParserFactoryMap;

/**
 * 4. 我们可以为工厂类再创建一个简单工厂，也就是工厂的工厂，用来创建工厂类对象
 *
 */
public class RuleConfigSource4 {

    public RuleConfig load(String ruleConfigFilePath) {

        String ruleConfigFileExtension = getFileExtension(ruleConfigFilePath);

        // FIXME 进一步将createParser()函数剥离到一个独立的简单工厂中
        IRuleConfigParserFactory ruleConfigParserFactory = RuleConfigParserFactoryMap.getParserFactory(ruleConfigFileExtension);
        if (ruleConfigParserFactory == null){
            throw new InvalidRuleConfigException("Rule config file format is not supported: " + ruleConfigFilePath);
        }

        IRuleConfigParser parser = ruleConfigParserFactory.createParser();

        String configText = "";
        //从ruleConfigFilePath文件中读取配置文本到configText中
        RuleConfig ruleConfig = parser.parse(configText);
        return ruleConfig;
    }

    private String getFileExtension(String filePath) {
        //...解析文件名获取扩展名，比如rule.json，返回json
        return "json";
    }
}
 