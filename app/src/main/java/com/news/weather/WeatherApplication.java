package com.news.weather;

import android.app.Application;
import com.facebook.stetho.Stetho;
import com.news.weather.network.DaggerNetworkComponent;
import com.news.weather.network.Helper;
import com.news.weather.network.NetworkComponent;
import com.news.weather.network.NetworksModule;

public class WeatherApplication extends Application {

    private static NetworkComponent networkComponent;

    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);

        networkComponent = DaggerNetworkComponent.builder()
                .networksModule(new NetworksModule(Helper.URL))
                .build();
    }

    public static NetworkComponent getNetworkComponent(){
        return networkComponent;
    }
}
