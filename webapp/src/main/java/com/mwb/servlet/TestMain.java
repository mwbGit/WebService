package com.mwb.servlet;

import com.alibaba.fastjson.JSONObject;

import java.net.URLEncoder;

/**
 * Created by MengWeiBo on 2017-02-13
 */
public class TestMain {
    public static void main(String[] args) throws Exception {
        String url = JSONObject.toJSONString(new TT("1","2000001"));
        System.out.println(url);
        System.out.println(URLEncoder.encode(url, "utf-8"));

        String parm ="%7B%22courseScheduleId%22%3A%221%22%2C%22employeeId%22%3A%222000001%22%7D";

        System.out.println(JSONObject.toJSONString(new Ob("0202","10",parm)));

        String parStr ="{\"activity\":\"0202\",\"sojumpparm\":\"%7B%22courseScheduleId%22%3A%221%22%2C%22employeeId%22%3A%222000001%22%7D\",\"totalvalue\":\"10\"}";
    }
}

class Ob{
    String activity;
    String totalvalue;
    String sojumpparm;

    public Ob(String activity, String totalvalue, String sojumpparm) {
        this.activity = activity;
        this.totalvalue = totalvalue;
        this.sojumpparm = sojumpparm;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getTotalvalue() {
        return totalvalue;
    }

    public void setTotalvalue(String totalvalue) {
        this.totalvalue = totalvalue;
    }

    public String getSojumpparm() {
        return sojumpparm;
    }

    public void setSojumpparm(String sojumpparm) {
        this.sojumpparm = sojumpparm;
    }
}

class TT{
    private String courseScheduleId;
    private String employeeId;

    public TT(String courseScheduleId, String employeeId) {
        this.courseScheduleId = courseScheduleId;
        this.employeeId = employeeId;
    }

    public String getCourseScheduleId() {
        return courseScheduleId;
    }

    public void setCourseScheduleId(String courseScheduleId) {
        this.courseScheduleId = courseScheduleId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
}
