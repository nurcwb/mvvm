package com.example.estudoandroid.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.estudoandroid.business.ModelProfession;
import com.example.estudoandroid.vo.DetailsVO;

public class ProfessionDetailsViewModel extends ViewModel {
    public MutableLiveData<DetailsVO> liveData = new MutableLiveData<>();
    private ModelProfession model = ModelProfession.getInstance();

    public void getDetails(int id) {
        liveData.postValue(model.getDetails(id));
    }
}
