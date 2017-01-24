package com.mwb.service.user;

import com.mwb.business.common.exception.RemoteServerException;
import com.mwb.business.common.handler.user.api.IUserHandler;
import com.mwb.data.dao.filter.UserFilter;
import com.mwb.data.dao.module.Address;
import com.mwb.data.dao.module.User;
import com.mwb.data.dao.module.UserStatus;
import com.mwb.service.user.api.*;
import com.mwb.web.framework.api.model.PagingData;
import com.mwb.web.framework.api.service.rs.api.ServiceResponse;
import com.mwb.web.framework.i18n.MessageSourceManager;
import com.mwb.web.framework.model.Bool;
import com.mwb.web.framework.model.filter.SearchResult;
import com.mwb.web.framework.model.filter.TimeRange;
import com.mwb.web.framework.service.api.exception.IllegalRequestException;
import com.mwb.web.framework.util.DateTimeUtility;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * Created by MengWeiBo on 2017-01-17
 */
public class UserService implements IUserService {

    @Autowired
    private IUserHandler userHandler;

    public UserInfoResponse getUserDetail(Integer id) {
        UserInfoResponse response = new UserInfoResponse();

        if (id == null) {
            String message = MessageSourceManager.getMessage("msg.request.parms");
            throw new RemoteServerException(message);
        }

        User user = userHandler.getUserById(id);

        response.setUser(UserVO.toVO(user));

        return response;
    }

    @Override
    public SearchUserResponse searchUser(SearchUserRequest request) throws Exception {
        SearchUserResponse response = new SearchUserResponse();

        int pageNumber = request.getPageNumber();
        int pageSize = request.getPageSize();

        if (pageNumber <= 0 || pageSize < 1) {
            throw new IllegalRequestException();
        }

        UserFilter filter = new UserFilter();
        filter.setPaged(true);
        PagingData pagingData = new PagingData(pageNumber, pageSize);
        filter.setPagingData(pagingData);

        filter.setName(request.getName());
        filter.setMobile(request.getMobile());
        filter.setMarital(Bool.fromValue(request.getMarital()));
        filter.setStatus(UserStatus.fromCode(request.getStatusCode()));
        if (StringUtils.isNotBlank(request.getCreateTime())) {

            TimeRange timeRange = new TimeRange();
            timeRange.setFrom(DateTimeUtility.parseYYYYMMDD(request.getCreateTime()));
            timeRange.setTo(DateTimeUtility.addDays(timeRange.getFrom(), 1));

            filter.setTimeRange(timeRange);
        }

        SearchResult<User> result = userHandler.searchUserByFilter(filter);

        List<UserVO> userVOs = UserVO.toVOs(result.getResult());

        response.setPagingResult(result.getPagingResult());
        response.setUsers(userVOs);

        return response;
    }

    @Override
    public ServiceResponse createUser(CreateUserRequest request) throws Exception {
        if (StringUtils.isBlank(request.getName())) {
            throw new IllegalRequestException();
        }

        User user = new User();
        user.setName(request.getName());
        user.setMobile(request.getMobile());
        user.setMarital(Bool.fromValue(request.getMarital()));
        Address address = new Address();
        address.setId(request.getAddressId());
        user.setAddress(address);
        user.setStatus(UserStatus.ACTIVE);
        user.setCreateTime(new Date());

        userHandler.createUser(user);

        return new ServiceResponse();
    }

    @Override
    public ServiceResponse modifyUser(ModifyUserRequest request) throws Exception {
        if (request.getId() == null) {
            throw new IllegalRequestException();
        }

        User user = new User();
        user.setId(request.getId());
        user.setName(request.getName());
        user.setMobile(request.getMobile());

        userHandler.updateUser(user);

        return new ServiceResponse();
    }
}
