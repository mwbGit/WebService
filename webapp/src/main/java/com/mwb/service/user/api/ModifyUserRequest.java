package com.mwb.service.user.api;

/**
 * Created by MengWeiBo on 2017-01-24
 */
public class ModifyUserRequest {

    private Integer id;
    private String name;
    private String mobile;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
