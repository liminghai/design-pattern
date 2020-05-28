package com.example.demo.designpattern.factory.DI;

/**
 * @author limh
 * @version 2020年05月18日 15:40 limh Exp $
 */
public class BeanCreationFailureException extends RuntimeException {

    public BeanCreationFailureException(String message, Throwable cause) {
        super(message, cause);
    }
}
