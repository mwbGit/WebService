package com.mwb.business.common.handler.user.api;

import com.mwb.data.dao.filter.UserFilter;
import com.mwb.data.dao.module.User;
import com.mwb.web.framework.model.filter.SearchResult;

/**
 * Created by MengWeiBo on 2017-01-18
 */
public interface IUserHandler {

    public User getUserById(Integer id);

    public SearchResult<User> searchUserByFilter(UserFilter filter);

    public void createUser(User user);

    public void updateUser(User user);
}
