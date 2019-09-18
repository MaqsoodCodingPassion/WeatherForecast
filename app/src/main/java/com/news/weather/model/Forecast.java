package com.news.weather.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Forecast{

	@SerializedName("forecastday")
	private List<ForecastdayItem> forecastday;

	public void setForecastday(List<ForecastdayItem> forecastday){
		this.forecastday = forecastday;
	}

	public List<ForecastdayItem> getForecastday(){
		return forecastday;
	}
}