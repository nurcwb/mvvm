package com.example.estudoandroid.repository;


import com.example.estudoandroid.repository.response.Profession;
import com.example.estudoandroid.repository.response.ProfessionReponse;
import com.example.estudoandroid.vo.SystemVO;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.schedulers.Schedulers;

public class RepositoryProfessions {
    public Observable<ProfessionReponse> requestProfessions() {

        return Observable.create(new ObservableOnSubscribe<ProfessionReponse>() {
            @Override
            public void subscribe(@NotNull ObservableEmitter<ProfessionReponse> emitter) throws Exception {
                ProfessionReponse professions = createResponse();
                emitter.onNext(professions);
            }
        }).delay(3, TimeUnit.SECONDS).subscribeOn(Schedulers.newThread());
    }


    @NotNull
    private ProfessionReponse createResponse() {
        ProfessionReponse professions = new ProfessionReponse();
        for (int i = 0; i < 100; i++) {
            professions.getProfessions().add(
                    (new Profession(i, "Analista 0" + i, "ASD" + i, "Especialista em Analista 0" + i, i * 79)));
        }
        professions.setSystemVO(new SystemVO("ok", 200));
        return professions;
    }
}
