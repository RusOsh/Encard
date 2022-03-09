package com.rus.encard.ui.fragment.word;


import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.rus.encard.model.PixaBayResponse;
import com.rus.encard.model.PixaBayStorage;

public class WordViewModel extends ViewModel {
    private MutableLiveData<PixaBayResponse> responseMutableLiveData;

    public WordViewModel() {
        responseMutableLiveData = new MutableLiveData<>();
    }

    public void init(String word) {
        PixaBayStorage.getImageGyId(word, new PixaBayStorage.Result() {
            @Override
            public void onSuccess(PixaBayResponse pixaBayResponse) {
                responseMutableLiveData.setValue(pixaBayResponse);
            }

            @Override
            public void onFailure(Throwable throwable) {
                responseMutableLiveData.setValue(null);
            }
        });
    }

    public MutableLiveData<PixaBayResponse> getResponseMutableLiveData() {
        return responseMutableLiveData;
    }
}
