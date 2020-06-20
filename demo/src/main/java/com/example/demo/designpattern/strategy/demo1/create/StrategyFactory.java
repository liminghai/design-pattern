package com.example.demo.designpattern.strategy.demo1.create;

import java.util.HashMap;
import java.util.Map;

import com.example.demo.designpattern.strategy.demo1.definition.ConcreteStrategyA;
import com.example.demo.designpattern.strategy.demo1.definition.ConcreteStrategyB;
import com.example.demo.designpattern.strategy.demo1.definition.Strategy;
import org.apache.commons.lang3.StringUtils;

/**
 * 策略创建工厂
 *
 * @author limh
 * @version 2020年06月19日 11:36 limh Exp $
 */
public class StrategyFactory {

    private static final Map<String, Strategy> strategies = new HashMap<>();

    static {
        strategies.put("A", new ConcreteStrategyA());
        strategies.put("B", new ConcreteStrategyB());
    }

    public static Strategy getStrategy(String type) {
        if (StringUtils.isEmpty(type)){
            throw new IllegalArgumentException("type should not be empty");
        }
        return strategies.get(type);
    }
}
