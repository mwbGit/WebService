package com.mwb.service.user;


import com.mwb.service.user.api.*;
import com.mwb.web.framework.api.http.ContentType;
import com.mwb.web.framework.api.service.rs.api.ServiceResponse;

import javax.ws.rs.*;

/**
 * Created by MengWeiBo on 2017-01-17
 */
public interface IUserService {

    @GET
    @Path("detail")
    @Produces(ContentType.APPLICATION_JSON_UTF8)
    public UserInfoResponse getUserDetail(@QueryParam("id") Integer id);

    @POST
    @Path("search")
    @Consumes(ContentType.APPLICATION_FORM_URLENCODED_UTF8)
    @Produces(ContentType.APPLICATION_JSON_UTF8)
    public SearchUserResponse searchUser(@FormParam("") SearchUserRequest request) throws Exception;

    @POST
    @Path("create")
    @Consumes(ContentType.APPLICATION_JSON_UTF8)
    @Produces(ContentType.APPLICATION_JSON_UTF8)
    public ServiceResponse createUser(CreateUserRequest request) throws Exception;

    @POST
    @Path("modify")
    @Consumes(ContentType.APPLICATION_JSON_UTF8)
    @Produces(ContentType.APPLICATION_JSON_UTF8)
    public ServiceResponse modifyUser(ModifyUserRequest request) throws Exception;
}
