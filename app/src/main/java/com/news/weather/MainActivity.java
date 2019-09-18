package com.news.weather;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.news.weather.currentLatLng.GPSTracker;
import com.news.weather.model.WeatherResponse;

import java.text.DecimalFormat;

import static android.content.pm.PackageManager.PERMISSION_GRANTED;

public class MainActivity extends AppCompatActivity {

    private GPSTracker gps;
    private static final int REQUEST_CODE_PERMISSION = 2;
    private String mPermission = Manifest.permission.ACCESS_FINE_LOCATION;
    private WeatherViewModel weatherViewModel;
    private static final String WEATHER_API_KEY = "ad714eba9cb74372b0e101947190504";
    private static final String NUMBER_OF_DAYS = "10";
    private ImageView currentWeatherImage;
    private TextView name;
    private TextView region;
    private TextView time;
    private TextView celsius;
    private TextView fahrenheit;
    private TextView condition;
    private RecyclerView weatherRecyclerView;
    private WeatherReportAdapter weatherReportAdapter;

    @Override
    protected void onResume() {
        super.onResume();
        initGPS();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((WeatherApplication)getApplication()).getNetworkComponent().inject(MainActivity.this);
        initView();
        weatherViewModel = ViewModelProviders.of(this).get(WeatherViewModel.class);
    }

    private void initView() {
        currentWeatherImage = (ImageView) findViewById(R.id.currentWeatherImage);
        name = (TextView) findViewById(R.id.name);
        region = (TextView) findViewById(R.id.region);
        time = (TextView) findViewById(R.id.time);
        celsius = (TextView) findViewById(R.id.celsius);
        fahrenheit = (TextView) findViewById(R.id.fahrenheit);
        condition = (TextView) findViewById(R.id.condition);
        weatherRecyclerView = (RecyclerView) findViewById(R.id.weatherRecyclerView);
    }

    private void initGPS() {
        enableGPSPermission();
        gps = new GPSTracker(MainActivity.this);
        if (gps.canGetLocation()) {
            if (gps.getLatitude() != 0.0 && gps.getLongitude() != 0.0) {
                DecimalFormat df2 = new DecimalFormat("#.##");
                String latitude = df2.format(gps.getLatitude());
                String longitude = df2.format(gps.getLongitude());
                String latLng = latitude + "," + longitude;
                callWeatherDetailsAPI(latLng);
            } else {
                Toast.makeText(this, "Please wait for few seconds to get GPS lat lng values", Toast.LENGTH_LONG).show();
                startActivity(new Intent(this,MainActivity.class));
            }

        } else {
            gps.showSettingsAlert();
        }
    }

    private void enableGPSPermission() {
        if (ActivityCompat.checkSelfPermission(this, mPermission)
                != PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this, new String[]{mPermission},
                    REQUEST_CODE_PERMISSION);
        }
    }

    private void callWeatherDetailsAPI(String latLng) {
        weatherViewModel.getWeatherDetails(WEATHER_API_KEY, latLng, NUMBER_OF_DAYS).observe(this, response -> {
            if (response != null) {
                String url = response.getCurrent().getCondition().getIcon().substring(2);
                loadCurrentWeatherImage(url);
                loadDataToUI(response);
            }
        });
    }

    private void loadCurrentWeatherImage(String url) {
        Glide.with(getApplicationContext())
                .load("http://"+url)
                .into(currentWeatherImage);
    }

    private void loadDataToUI(WeatherResponse response) {
        name.setText(getResources().getString(R.string.name)+response.getLocation().getName());
        region.setText(getResources().getString(R.string.region)+response.getLocation().getRegion());
        time.setText(getResources().getString(R.string.time)+response.getLocation().getLocaltime());
        celsius.setText(getResources().getString(R.string.celsius)+response.getCurrent().getTempC());
        fahrenheit.setText(getResources().getString(R.string.fahrenheit)+response.getCurrent().getTempF());
        condition.setText(getResources().getString(R.string.condition)+response.getCurrent().getCondition().getText());
        weatherReportAdapter = new WeatherReportAdapter(response.getForecast().getForecastday());
        weatherRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        weatherRecyclerView.setItemAnimator(new DefaultItemAnimator());
        weatherRecyclerView.setAdapter(weatherReportAdapter);
        weatherReportAdapter.notifyDataSetChanged();
    }
}
