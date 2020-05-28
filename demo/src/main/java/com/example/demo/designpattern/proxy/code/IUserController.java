package com.example.demo.designpattern.proxy.code;

public interface IUserController {
    UserVo login(String telephone, String password);

    UserVo register(String telephone, String password);
}