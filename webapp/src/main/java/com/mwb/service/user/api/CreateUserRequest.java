package com.mwb.service.user.api;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by MengWeiBo on 2017-01-24
 */
public class CreateUserRequest {

    private String name;
    private String mobile;
    private Boolean marital;
    private Integer addressId;

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


    public Boolean getMarital() {
        return marital;
    }

    public void setMarital(Boolean marital) {
        this.marital = marital;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public static void main(String[] args) {
        CreateUserRequest request = new CreateUserRequest();
        request.setMobile("13029777777");
        request.setName("张三");
        request.setMarital(false);
        request.setAddressId(1);

        System.out.println(JSONObject.toJSON(request));
    }
}
