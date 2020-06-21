package com.example.demo.designpattern.chainOfResponsibility.demo2;

/**
 * @author limh
 * @version 2020年06月20日 17:10 limh Exp $
 */
public interface SensitiveWordFilter {

    String doFilter(String word);

    String suuportType();
}
