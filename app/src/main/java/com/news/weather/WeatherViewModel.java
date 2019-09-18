package com.news.weather;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import com.news.weather.model.WeatherResponse;

public class WeatherViewModel extends AndroidViewModel {

    private WeatherRepository weatherRepository;

    public WeatherViewModel(Application application) {
        super(application);
        weatherRepository =new WeatherRepository();
    }

    public MutableLiveData<WeatherResponse> getWeatherDetails(String key, String latLng, String days) {
        return weatherRepository.getWeatherDetails(key,latLng,days);
    }
}