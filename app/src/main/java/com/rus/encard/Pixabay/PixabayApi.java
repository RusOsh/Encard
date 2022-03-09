package com.rus.encard.Pixabay;

import com.rus.encard.model.PixaBayResponse;
import com.rus.encard.utils.EndPoints;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PixabayApi {
    @GET(EndPoints.API)
    Call<PixaBayResponse> getImage( @Query(EndPoints.APP_KEY) String key,@Query("q") String word);
}
