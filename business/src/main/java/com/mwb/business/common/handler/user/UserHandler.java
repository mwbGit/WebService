package com.mwb.business.common.handler.user;

import com.mwb.business.common.handler.AbstractBusinessHandler;
import com.mwb.business.common.handler.user.api.IUserHandler;
import com.mwb.data.dao.filter.UserFilter;
import com.mwb.data.dao.module.User;
import com.mwb.web.framework.api.model.PagingData;
import com.mwb.web.framework.api.model.PagingResult;
import com.mwb.web.framework.model.filter.SearchResult;

import java.util.List;

/**
 * Created by MengWeiBo on 2017-01-18
 */
public class UserHandler extends AbstractBusinessHandler implements IUserHandler{

    public User getUserById(Integer id){
        return getUserMapper().selectUser(id);
    }

    @Override
    public SearchResult<User> searchUserByFilter(UserFilter filter) {
        List<User> users = getUserMapper().selectUserByFilter(filter);

        SearchResult<User> result = new SearchResult<>();
        result.setResult(users);

        PagingData pagingData = filter.getPagingData();
        if (filter.isPaged() && pagingData != null) {
            int recordNumber = getUserMapper().countUserByFilter(filter);

            PagingResult pagingResult = new PagingResult(recordNumber, pagingData);
            result.setPaged(true);
            result.setPagingResult(pagingResult);
        }

        return result;
    }

    @Override
    public void createUser(User user) {
        getUserMapper().insertUser(user);
    }

    @Override
    public void updateUser(User user) {
        getUserMapper().updateUser(user);
    }

}
