package com.mwb.data.dao.filter;

import com.mwb.data.dao.module.UserStatus;
import com.mwb.web.framework.model.Bool;
import com.mwb.web.framework.model.filter.SearchFilter;
import com.mwb.web.framework.model.filter.TimeRange;
import org.apache.commons.lang.StringUtils;

import java.util.List;

/**
 * Created by MengWeiBo on 2017-01-19
 */
public class UserFilter extends SearchFilter {

    private String name;
    private String mobile;
    private Bool marital;
    private UserStatus status;
    private TimeRange timeRange;
    private List<Integer> containsScores;

    public void setName(String name) {
        if (StringUtils.isNotBlank(name)) {
            this.name = "%" + name + "%";
        }
    }

    public String getName() {
        return name;
    }

    public List<Integer> getContainsScores() {
        return containsScores;
    }

    public void setContainsScores(List<Integer> containsScores) {
        this.containsScores = containsScores;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    public TimeRange getTimeRange() {
        return timeRange;
    }

    public void setTimeRange(TimeRange timeRange) {
        this.timeRange = timeRange;
    }

    public Bool getMarital() {
        return marital;
    }

    public void setMarital(Bool marital) {
        this.marital = marital;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        if (StringUtils.isNotBlank(mobile)) {
            this.mobile = "%" + mobile + "%";
        }
    }
}

