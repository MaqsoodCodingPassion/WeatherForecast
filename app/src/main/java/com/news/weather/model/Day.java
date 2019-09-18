package com.news.weather.model;

import com.google.gson.annotations.SerializedName;

public class Day{

	@SerializedName("avgvis_km")
	private double avgvisKm;

	@SerializedName("uv")
	private double uv;

	@SerializedName("avgtemp_f")
	private double avgtempF;

	@SerializedName("avgtemp_c")
	private double avgtempC;

	@SerializedName("maxtemp_c")
	private double maxtempC;

	@SerializedName("maxtemp_f")
	private double maxtempF;

	@SerializedName("mintemp_c")
	private double mintempC;

	@SerializedName("avgvis_miles")
	private int avgvisMiles;

	@SerializedName("mintemp_f")
	private double mintempF;

	@SerializedName("totalprecip_in")
	private double totalprecipIn;

	@SerializedName("avghumidity")
	private int avghumidity;

	@SerializedName("condition")
	private Condition condition;

	@SerializedName("maxwind_kph")
	private double maxwindKph;

	@SerializedName("maxwind_mph")
	private double maxwindMph;

	@SerializedName("totalprecip_mm")
	private double totalprecipMm;

	public void setAvgvisKm(double avgvisKm){
		this.avgvisKm = avgvisKm;
	}

	public double getAvgvisKm(){
		return avgvisKm;
	}

	public void setUv(double uv){
		this.uv = uv;
	}

	public double getUv(){
		return uv;
	}

	public void setAvgtempF(double avgtempF){
		this.avgtempF = avgtempF;
	}

	public double getAvgtempF(){
		return avgtempF;
	}

	public void setAvgtempC(double avgtempC){
		this.avgtempC = avgtempC;
	}

	public double getAvgtempC(){
		return avgtempC;
	}

	public void setMaxtempC(double maxtempC){
		this.maxtempC = maxtempC;
	}

	public double getMaxtempC(){
		return maxtempC;
	}

	public void setMaxtempF(double maxtempF){
		this.maxtempF = maxtempF;
	}

	public double getMaxtempF(){
		return maxtempF;
	}

	public void setMintempC(double mintempC){
		this.mintempC = mintempC;
	}

	public double getMintempC(){
		return mintempC;
	}

	public void setAvgvisMiles(int avgvisMiles){
		this.avgvisMiles = avgvisMiles;
	}

	public int getAvgvisMiles(){
		return avgvisMiles;
	}

	public void setMintempF(double mintempF){
		this.mintempF = mintempF;
	}

	public double getMintempF(){
		return mintempF;
	}

	public void setTotalprecipIn(double totalprecipIn){
		this.totalprecipIn = totalprecipIn;
	}

	public double getTotalprecipIn(){
		return totalprecipIn;
	}

	public void setAvghumidity(int avghumidity){
		this.avghumidity = avghumidity;
	}

	public int getAvghumidity(){
		return avghumidity;
	}

	public void setCondition(Condition condition){
		this.condition = condition;
	}

	public Condition getCondition(){
		return condition;
	}

	public void setMaxwindKph(double maxwindKph){
		this.maxwindKph = maxwindKph;
	}

	public double getMaxwindKph(){
		return maxwindKph;
	}

	public void setMaxwindMph(double maxwindMph){
		this.maxwindMph = maxwindMph;
	}

	public double getMaxwindMph(){
		return maxwindMph;
	}

	public void setTotalprecipMm(double totalprecipMm){
		this.totalprecipMm = totalprecipMm;
	}

	public double getTotalprecipMm(){
		return totalprecipMm;
	}
}