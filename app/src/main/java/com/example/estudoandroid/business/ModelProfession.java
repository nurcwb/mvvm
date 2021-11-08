package com.example.estudoandroid.business;

import com.example.estudoandroid.repository.RepositoryProfessions;
import com.example.estudoandroid.repository.response.Profession;
import com.example.estudoandroid.repository.response.ProfessionReponse;
import com.example.estudoandroid.vo.DetailsVO;
import com.example.estudoandroid.vo.ProfessionVo;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

public class ModelProfession {
    private static ModelProfession instance;
    private RepositoryProfessions repository = new RepositoryProfessions();
    private List<Profession> professions;
    private int STATUS_OK = 200;

    public static ModelProfession getInstance() {
        if (instance == null) {
            instance = new ModelProfession();
        }
        return instance;
    }

    public Observable<Boolean> requestList() {
        return repository.requestProfessions().map(new Function<ProfessionReponse, Boolean>() {
            @Override
            public Boolean apply(@NotNull ProfessionReponse professionReponse) throws Exception {
                if (professionReponse.getSystemVO().getErrorCode() == 200) {
                    professions = professionReponse.getProfessions();
                }
                return (professionReponse.getSystemVO().getErrorCode() == STATUS_OK);
            }
        });
    }

    public List<ProfessionVo> getList() {
        List<ProfessionVo> voList = new ArrayList<>();
        for (Profession profession : professions) {
            voList.add(new ProfessionVo(profession.getId(), profession.getTitle()));
        }
        return voList;
    }


    public DetailsVO getDetails(int id) {
        Profession profession = professions.get(id);

        return new DetailsVO(profession.getTitle(),
                profession.getGeneralRegister(),
                profession.getDescription(),
                profession.getNumberOfSubscribers(),
                profession.getCriationDate());
    }
}
