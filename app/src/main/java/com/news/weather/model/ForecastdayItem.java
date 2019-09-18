package com.news.weather.model;

import com.google.gson.annotations.SerializedName;

public class ForecastdayItem{

	@SerializedName("date")
	private String date;

	@SerializedName("astro")
	private Astro astro;

	@SerializedName("date_epoch")
	private int dateEpoch;

	@SerializedName("day")
	private Day day;

	public void setDate(String date){
		this.date = date;
	}

	public String getDate(){
		return date;
	}

	public void setAstro(Astro astro){
		this.astro = astro;
	}

	public Astro getAstro(){
		return astro;
	}

	public void setDateEpoch(int dateEpoch){
		this.dateEpoch = dateEpoch;
	}

	public int getDateEpoch(){
		return dateEpoch;
	}

	public void setDay(Day day){
		this.day = day;
	}

	public Day getDay(){
		return day;
	}
}