package com.example.demo.designpattern.strategy.demo1.create;

import com.example.demo.designpattern.strategy.demo1.definition.ConcreteStrategyA;
import com.example.demo.designpattern.strategy.demo1.definition.ConcreteStrategyB;
import com.example.demo.designpattern.strategy.demo1.definition.Strategy;
import org.apache.commons.lang3.StringUtils;

/**
 * @author limh
 * @version 2020年06月19日 11:46 limh Exp $
 */
public class StrategyFactory2 {

    public static Strategy getStrategy(String type) {
        if (StringUtils.isEmpty(type)) {
            throw new IllegalArgumentException("type should not be empty");
        }
        if ("A".equals(type)) {
            return new ConcreteStrategyA();
        } else if ("B".equals(type)) {
            return new ConcreteStrategyB();
        }

        return null;
    }
}
