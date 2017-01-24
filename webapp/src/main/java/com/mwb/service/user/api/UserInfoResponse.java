package com.mwb.service.user.api;

import com.mwb.web.framework.api.service.rs.api.ServiceResponse;

/**
 * Created by MengWeiBo on 2017-01-24
 */
public class UserInfoResponse extends ServiceResponse {
    private static final long serialVersionUID = 1L;

    private UserVO user;

    public UserVO getUser() {
        return user;
    }

    public void setUser(UserVO user) {
        this.user = user;
    }

}
