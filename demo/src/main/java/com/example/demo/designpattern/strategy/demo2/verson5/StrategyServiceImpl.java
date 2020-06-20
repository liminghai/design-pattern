package com.example.demo.designpattern.strategy.demo2.verson5;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

/**
 * @author limh
 * @version 2020年06月20日 09:30 limh Exp $
 */
@Service
public class StrategyServiceImpl implements StrategyService, ApplicationContextAware {

    private ApplicationContext applicationContext;

    private static Map<String, IStrategy> strategyMap;

    @PostConstruct
    public void init() {
        strategyMap = applicationContext.getBeansOfType(IStrategy.class).values().stream()
        .collect(Collectors.toMap(IStrategy::supportType, Function.identity()));
    }

    @Override
    public IStrategy getStrategy(String type) {
        return strategyMap.get(type);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
