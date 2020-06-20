package com.example.demo.designpattern.strategy.demo2.verson5;

import org.springframework.stereotype.Component;

/**
 * springbean下的查表法
 *
 * @author limh
 * @version 2020年06月20日 09:18 limh Exp $
 */
@Component
public class StrategyB implements IStrategy {

    @Override
    public String test() {
        return "i am StrategyB";
    }

    @Override
    public String supportType() {
        return "StrategyB";
    }
}
