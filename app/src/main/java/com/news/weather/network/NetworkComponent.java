package com.news.weather.network;

import com.news.weather.MainActivity;
import com.news.weather.WeatherRepository;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = {NetworksModule.class})
public interface NetworkComponent {
    void inject(MainActivity activity);
    void inject(WeatherRepository repository);
}
