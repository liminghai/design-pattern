package com.example.demo.designPattern.singleton.cases;

/**
 * @author limh
 * @version 2020年05月14日 14:15 limh Exp $
 */
public class OrderController {

    private Logger logger = new Logger();

    public void create(String product) {
        // 省略业务逻辑
        logger.log("buy_" + product);
    }
}
