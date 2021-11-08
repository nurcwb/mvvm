package com.example.estudoandroid.repository.response;

import com.example.estudoandroid.vo.SystemVO;

import java.util.ArrayList;
import java.util.List;

public class ProfessionReponse {
    private List<Profession> professions;
    private SystemVO systemVO;

    public ProfessionReponse() {
        professions = new ArrayList<>();
    }

    public List<Profession> getProfessions() {
        return professions;
    }

    public void setProfessions(List<Profession> professions) {
        this.professions = professions;
    }

    public SystemVO getSystemVO() {
        return systemVO;
    }

    public void setSystemVO(SystemVO systemVO) {
        this.systemVO = systemVO;
    }
}
