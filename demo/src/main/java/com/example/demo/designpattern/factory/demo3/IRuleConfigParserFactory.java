package com.example.demo.designpattern.factory.demo3;

import com.example.demo.designpattern.factory.config.IRuleConfigParser;

public interface IRuleConfigParserFactory {

    IRuleConfigParser createParser();
}