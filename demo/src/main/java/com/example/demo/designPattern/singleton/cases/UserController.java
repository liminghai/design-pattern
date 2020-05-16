package com.example.demo.designPattern.singleton.cases;

/**
 * @author limh
 * @version 2020年05月14日 14:15 limh Exp $
 */
public class UserController {

    private Logger logger = new Logger();

    public void login(String userName, String password) {
        // 省略业务逻辑
        logger.log(userName + "_login");
    }
}
