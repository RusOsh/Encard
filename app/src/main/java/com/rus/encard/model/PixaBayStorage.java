package com.rus.encard.model;

import com.rus.encard.Pixabay.RetrofitClient;

import com.rus.encard.utils.EndPoints;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PixaBayStorage {
    public static void getImageGyId(String word, Result result) {
        RetrofitClient.getPixabay().getImage(EndPoints.KEY, word).enqueue(new Callback<PixaBayResponse>() {
            @Override
            public void onResponse(Call<PixaBayResponse> call, Response<PixaBayResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    result.onSuccess(response.body());
                }
            }

            @Override
            public void onFailure(Call<PixaBayResponse> call, Throwable t) {
                result.onFailure(t);
            }
        });
    }

    public interface Result {
        void onSuccess(PixaBayResponse pixaBayResponse);

        void onFailure(Throwable throwable);
    }
}
