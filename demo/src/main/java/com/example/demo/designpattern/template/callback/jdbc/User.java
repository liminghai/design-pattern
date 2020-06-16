package com.example.demo.designpattern.template.callback.jdbc;

/**
 * @author limh
 * @version 2020年06月16日 11:36 limh Exp $
 */
public class User {

    private Long id;
    private String name;
    private String telephone;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
