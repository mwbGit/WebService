package com.mwb.data.dao.mapper;

import com.mwb.data.dao.filter.UserFilter;
import com.mwb.data.dao.module.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by MengWeiBo on 2017-01-18
 */
public interface UserMapper {

    public User selectUser(@Param("id") Integer id);

    public List<User> selectUserByFilter(@Param("filter") UserFilter filter);

    public int countUserByFilter(@Param("filter") UserFilter filter);

    public void insertUser(User user);

    public void updateUser(User user);

}
