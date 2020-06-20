package com.example.demo.designpattern.strategy.demo2.verson5;

/**
 * @author limh
 * @version 2020年06月20日 09:30 limh Exp $
 */
public interface StrategyService {

    IStrategy getStrategy(String type);
}
