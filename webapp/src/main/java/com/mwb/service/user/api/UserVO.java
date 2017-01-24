package com.mwb.service.user.api;

import com.mwb.data.dao.module.User;
import com.mwb.web.framework.util.DateTimeUtility;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MengWeiBo on 2017-01-24
 */
public class UserVO {

    private Integer id;
    private String name;
    private String mobile;
    private String createTime;
    private Boolean marital;
    private String statusName;
    private String addressName;
    private List<GradeVO> grades;

    public static UserVO toVO(User user) {
        UserVO vo = new UserVO();

        if (user != null) {
            vo.setId(user.getId());
            vo.setName(user.getName());
            vo.setMobile(user.getMobile());
            vo.setMarital(user.getMarital().getValue());
            vo.setCreateTime(DateTimeUtility.formatYYYYMMDDHHMMSS(user.getCreateTime()));
            vo.setStatusName(user.getStatus().getName());
            vo.setAddressName(user.getAddress().getName());
            vo.setGrades(GradeVO.toVOS(user.getGrades()));
        }
        return vo;
    }

    public static List<UserVO> toVOs(List<User> users) {
        List<UserVO> vos = new ArrayList<UserVO>();

        for (User user : users) {
            vos.add(toVO(user));
        }
        return vos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Boolean getMarital() {
        return marital;
    }

    public void setMarital(Boolean marital) {
        this.marital = marital;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public List<GradeVO> getGrades() {
        return grades;
    }

    public void setGrades(List<GradeVO> grades) {
        this.grades = grades;
    }
}
