package com.example.demo.designpattern.chainOfResponsibility.demo2;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

/**
 * @author limh
 * @version 2020年06月20日 17:15 limh Exp $
 */
@Service
public class SensitiveWordFilterServiceImpl implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    private List<SensitiveWordFilter> sensitiveWordFilters;

    @PostConstruct
    public void init() {
        sensitiveWordFilters = applicationContext.getBeansOfType(SensitiveWordFilter.class).values().stream()
            .collect(Collectors.toList());
    }

    public String filter(String word) {
        String newWord = word;
        for (SensitiveWordFilter sensitiveWordFilter : sensitiveWordFilters) {
            newWord = sensitiveWordFilter.doFilter(newWord);
        }
        return newWord;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
