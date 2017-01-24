package com.mwb.service.user.api;

import com.mwb.data.dao.module.Grade;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MengWeiBo on 2017-01-24
 */
public class GradeVO {

    private Integer id;
    private String name;
    private Integer score;

    public static GradeVO toVO(Grade grade) {
        GradeVO vo = new GradeVO();

        if (grade != null) {
            vo.setId(grade.getId());
            vo.setName(grade.getName());
            vo.setScore(grade.getScore());
        }
        return vo;
    }

    public static List<GradeVO> toVOS(List<Grade> grades) {
        List<GradeVO> vos = new ArrayList<GradeVO>();

        for (Grade grade : grades) {
            vos.add(toVO(grade));
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

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
