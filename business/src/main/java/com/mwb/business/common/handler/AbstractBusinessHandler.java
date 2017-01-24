package com.mwb.business.common.handler;

import com.mwb.data.dao.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by MengWeiBo on 2017-01-18
 */
public class AbstractBusinessHandler{

    @Autowired
    private UserMapper userMapper;

    protected UserMapper getUserMapper() {
        return userMapper;
    }
}
