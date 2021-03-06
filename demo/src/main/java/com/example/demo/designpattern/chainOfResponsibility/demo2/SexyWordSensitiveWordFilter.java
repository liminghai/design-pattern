package com.example.demo.designpattern.chainOfResponsibility.demo2;

import org.springframework.stereotype.Component;

/**
 * @author limh
 * @version 2020年06月20日 17:12 limh Exp $
 */
@Component
public class SexyWordSensitiveWordFilter implements SensitiveWordFilter {

    @Override
    public String doFilter(String word) {
        return word.replace("AV", "**");
    }

    @Override
    public String suuportType() {
        return "SexyWordSensitiveWordFilter";
    }
}
