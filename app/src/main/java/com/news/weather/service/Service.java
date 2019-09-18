package com.news.weather.service;

import com.news.weather.model.WeatherResponse;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Service {

    String BASE_URL = "http://api.apixu.com";

    @GET("v1/forecast.json")
    Observable<WeatherResponse> getWeatherDetails(
            @Query("key") String key, @Query("q") String q,@Query("days") String days);
}
