package com.news.weather.model;

import com.google.gson.annotations.SerializedName;

public class Astro{

	@SerializedName("moonset")
	private String moonset;

	@SerializedName("sunrise")
	private String sunrise;

	@SerializedName("sunset")
	private String sunset;

	@SerializedName("moonrise")
	private String moonrise;

	public void setMoonset(String moonset){
		this.moonset = moonset;
	}

	public String getMoonset(){
		return moonset;
	}

	public void setSunrise(String sunrise){
		this.sunrise = sunrise;
	}

	public String getSunrise(){
		return sunrise;
	}

	public void setSunset(String sunset){
		this.sunset = sunset;
	}

	public String getSunset(){
		return sunset;
	}

	public void setMoonrise(String moonrise){
		this.moonrise = moonrise;
	}

	public String getMoonrise(){
		return moonrise;
	}
}