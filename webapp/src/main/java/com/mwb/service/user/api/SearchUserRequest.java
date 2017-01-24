package com.mwb.service.user.api;

import com.mwb.web.framework.api.service.rs.api.PagingRequest;

/**
 * Created by MengWeiBo on 2017-01-24
 */
public class SearchUserRequest extends PagingRequest {

    private Integer id;
    private String name;
    private String mobile;
    private String createTime;
    private Boolean marital;
    private String statusCode;

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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Boolean getMarital() {
        return marital;
    }

    public void setMarital(Boolean marital) {
        this.marital = marital;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

}
