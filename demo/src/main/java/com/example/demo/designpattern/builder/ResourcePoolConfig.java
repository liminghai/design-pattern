package com.example.demo.designpattern.builder;

import org.apache.commons.lang3.StringUtils;

/**
 * @author limh
 * @version 2020年05月19日 20:56 limh Exp $
 */
public class ResourcePoolConfig {

    private String name;
    private int maxTotal;
    private int maxIdle;
    private int minIdle;

    /**
     * 提供Builder参数的构造函数
     * @param builder
     */
    private ResourcePoolConfig(Builder builder){
        this.name = builder.name;
        this.maxTotal = builder.maxTotal;
        this.maxIdle = builder.maxIdle;
        this.minIdle = builder.minIdle;
    }

    // 我们将Builder类设计成了ResourcePoolConfig的内部类
    // 我们也可以将Builder类设计成独立的非内部类ResourcePoolConfigBuilder
    public static class Builder {
        private static final int DEFAULT_MAX_TOTAL = 8;
        private static final int DEFAULT_MAX_IDLE = 8;
        private static final int DEFAULT_MIN_IDLE = 0;

        private String name;
        private int maxTotal = DEFAULT_MAX_TOTAL;
        private int maxIdle = DEFAULT_MAX_IDLE;
        private int minIdle = DEFAULT_MIN_IDLE;

        public ResourcePoolConfig build() {
            // 校验逻辑放到这里来做，包括必填项校验、依赖关系校验、约束条件校验等
            if (StringUtils.isEmpty(name)) {
                throw new IllegalArgumentException("...");
            }
            if (maxTotal < maxIdle) {
                throw new IllegalArgumentException("...");
            }
            if (maxIdle < minIdle || maxTotal < minIdle) {
                throw new IllegalArgumentException("...");
            }

            return new ResourcePoolConfig(this);
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setMaxTotal(int maxTotal) {
            this.maxTotal = maxTotal;
            return this;
        }

        public Builder setMaxIdle(int maxIdle) {
            this.maxIdle = maxIdle;
            return this;
        }

        public Builder setMinIdle(int minIdle) {
            this.minIdle = minIdle;
            return this;
        }
    }
}
