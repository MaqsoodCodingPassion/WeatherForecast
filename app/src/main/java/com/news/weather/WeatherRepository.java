package com.news.weather;

import android.app.Application;
import androidx.lifecycle.MutableLiveData;
import com.news.weather.model.WeatherResponse;
import com.news.weather.service.Service;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

import javax.inject.Inject;

public class WeatherRepository {

    @Inject
    Retrofit retrofit;

    public MutableLiveData<WeatherResponse> getWeatherDetails(String key, String latLng, String days) {

        WeatherApplication.getNetworkComponent().inject(this);
        Service service = retrofit.create(Service.class);
        MutableLiveData<WeatherResponse> sessionData = new MutableLiveData();
        Observable observable = service.getWeatherDetails(key,latLng,days);
        observable.subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
                .subscribe((Consumer<WeatherResponse>)
                        response -> sessionData.setValue(response), new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) {
                        throwable.printStackTrace();
                    }
                });
        return sessionData;
    }
}
