package com.news.weather.model;

import com.google.gson.annotations.SerializedName;

public class Location{

	@SerializedName("localtime")
	private String localtime;

	@SerializedName("country")
	private String country;

	@SerializedName("localtime_epoch")
	private int localtimeEpoch;

	@SerializedName("name")
	private String name;

	@SerializedName("lon")
	private double lon;

	@SerializedName("region")
	private String region;

	@SerializedName("lat")
	private double lat;

	@SerializedName("tz_id")
	private String tzId;

	public void setLocaltime(String localtime){
		this.localtime = localtime;
	}

	public String getLocaltime(){
		return localtime;
	}

	public void setCountry(String country){
		this.country = country;
	}

	public String getCountry(){
		return country;
	}

	public void setLocaltimeEpoch(int localtimeEpoch){
		this.localtimeEpoch = localtimeEpoch;
	}

	public int getLocaltimeEpoch(){
		return localtimeEpoch;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setLon(double lon){
		this.lon = lon;
	}

	public double getLon(){
		return lon;
	}

	public void setRegion(String region){
		this.region = region;
	}

	public String getRegion(){
		return region;
	}

	public void setLat(double lat){
		this.lat = lat;
	}

	public double getLat(){
		return lat;
	}

	public void setTzId(String tzId){
		this.tzId = tzId;
	}

	public String getTzId(){
		return tzId;
	}
}