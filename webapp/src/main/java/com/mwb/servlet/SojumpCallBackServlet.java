package com.mwb.servlet;

import com.alibaba.fastjson.JSONObject;
import com.mwb.business.common.handler.user.api.IUserHandler;
import com.mwb.web.framework.log.Log;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;

public class SojumpCallBackServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private static final Log LOG = Log.getLog(SojumpCallBackServlet.class);

    @Autowired
    private IUserHandler userHandler;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // String jsonString ="{\"activity\":\"0202\",\"totalvalue\":\"10\",\"sojumpparm\":\"%7B%22courseScheduleId%22%3A%221%22%2C%22employeeId%22%3A%222000001%22%7D\"}";

        String jsonString = IOUtils.toString(request.getInputStream());

//        LOG.info("get sojump response jsonString{}", jsonString);

        JSONObject json = JSONObject.parseObject(jsonString);

        String examPaperNumber = json.getString("activity");
        Integer score = json.getInteger("totalvalue");
        String paramJson = json.getString("sojumpparm");

        String params = URLDecoder.decode(paramJson, "utf-8");
        JSONObject object = JSONObject.parseObject(params);

        String employeeId = object.getString("employeeId");
        String courseScheduleId = object.getString("courseScheduleId");

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}