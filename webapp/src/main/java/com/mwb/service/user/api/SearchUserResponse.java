package com.mwb.service.user.api;

import com.mwb.web.framework.api.service.rs.api.PagingResponse;

import java.util.List;

/**
 * Created by MengWeiBo on 2017-01-24
 */
public class SearchUserResponse extends PagingResponse {
    private static final long serialVersionUID = 1L;

    private List<UserVO> users;

    public List<UserVO> getUsers() {
        return users;
    }

    public void setUsers(List<UserVO> users) {
        this.users = users;
    }
}
