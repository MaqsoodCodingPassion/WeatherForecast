package com.news.weather.model;

import com.google.gson.annotations.SerializedName;

public class WeatherResponse {

	@SerializedName("current")
	private Current current;

	@SerializedName("location")
	private Location location;

	@SerializedName("forecast")
	private Forecast forecast;

	public void setCurrent(Current current){
		this.current = current;
	}

	public Current getCurrent(){
		return current;
	}

	public void setLocation(Location location){
		this.location = location;
	}

	public Location getLocation(){
		return location;
	}

	public void setForecast(Forecast forecast){
		this.forecast = forecast;
	}

	public Forecast getForecast(){
		return forecast;
	}
}