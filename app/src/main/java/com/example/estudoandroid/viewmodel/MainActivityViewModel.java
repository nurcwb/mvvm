package com.example.estudoandroid.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.estudoandroid.business.ModelProfession;
import com.example.estudoandroid.vo.ProfessionVo;

import java.util.List;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

public class MainActivityViewModel extends ViewModel {
    private ModelProfession model = ModelProfession.getInstance();
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public MutableLiveData<List<ProfessionVo>> listMutableLiveData = new MutableLiveData<>();
    public MutableLiveData<Boolean> error = new MutableLiveData<>();

    public void requestList() {
        compositeDisposable.add(model.requestList().subscribe(new Consumer<Boolean>() {
            @Override
            public void accept(Boolean aBoolean) throws Exception {
                error.postValue(aBoolean);
            }
        }));
    }

    public void getList() {
        listMutableLiveData.postValue(model.getList());
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.dispose();
    }
}
