package com.example.demo.designpattern.factory;

import com.example.demo.designpattern.factory.config.IRuleConfigParser;
import com.example.demo.designpattern.factory.config.InvalidRuleConfigException;
import com.example.demo.designpattern.factory.config.JsonRuleConfigParser;
import com.example.demo.designpattern.factory.config.PropertiesRuleConfigParser;
import com.example.demo.designpattern.factory.config.RuleConfig;
import com.example.demo.designpattern.factory.config.XmlRuleConfigParser;
import com.example.demo.designpattern.factory.config.YamlRuleConfigParser;
import com.example.demo.designpattern.factory.demo1.SimpleFactory;

/**
 * 3. 为了让代码逻辑更加清晰，可读性更好，我们要善于将功能独立的代码块封装成函数。
 * 按照这个思路，我们可以将代码中涉及parser创建的部分逻辑抽离出来，抽象成createParser()函数。
 */
public class RuleConfigSource3 {

    public RuleConfig load(String ruleConfigFilePath) {

        String ruleConfigFileExtension = getFileExtension(ruleConfigFilePath);

        // FIXME 进一步将createParser()函数剥离到一个独立的简单工厂中
        IRuleConfigParser parser = SimpleFactory.createParser(ruleConfigFileExtension);

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
 