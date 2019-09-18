package com.news.weather;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.news.weather.model.ForecastdayItem;

import java.util.List;

public class WeatherReportAdapter extends RecyclerView.Adapter<WeatherReportAdapter.WeatherViewHolder> {


    private Context context;
    private List<ForecastdayItem> forecastDaysList;

    public WeatherReportAdapter(List<ForecastdayItem> ForecastDaysList) {
        this.forecastDaysList = ForecastDaysList;
    }

    @Override
    public WeatherViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.weather_row_item,parent,false);
        this.context = view.getContext();
        return new WeatherViewHolder(view);
    }

    @Override
    public void onBindViewHolder(WeatherViewHolder holder, int position) {

        holder.date.setText(context.getResources().getString(R.string.date)+forecastDaysList.get(position).getDate());
        holder.maxCelsius.setText(context.getResources().getString(R.string.maxCelsius)+String.valueOf(forecastDaysList.get(position).getDay().getMaxtempC()));
        holder.minCelsius.setText(context.getResources().getString(R.string.minCelsius)+String.valueOf(forecastDaysList.get(position).getDay().getMintempC()));
        holder.maxFeh.setText(context.getResources().getString(R.string.maxFeh)+String.valueOf(forecastDaysList.get(position).getDay().getMaxtempF()));
        holder.minFeh.setText(context.getResources().getString(R.string.minFeh)+String.valueOf(forecastDaysList.get(position).getDay().getMintempF()));
        holder.condition.setText(context.getResources().getString(R.string.condition)+forecastDaysList.get(position).getDay().getCondition().getText());
        holder.humidity.setText(context.getResources().getString(R.string.avg_humidity)+forecastDaysList.get(position).getDay().getAvghumidity());
        Glide.with(context)

                .load("http://"+ forecastDaysList.get(position).getDay().getCondition().getIcon())
                .into(holder.weatherImage);
    }

    @Override
    public int getItemCount() {
        return forecastDaysList.size();
    }

    public class WeatherViewHolder extends RecyclerView.ViewHolder {

        private TextView date;
        private TextView maxCelsius;
        private TextView minCelsius;
        private TextView maxFeh;
        private TextView minFeh;
        private TextView condition;
        private TextView humidity;
        private ImageView weatherImage;

        public WeatherViewHolder(View itemView) {
            super(itemView);
            date = (TextView) itemView.findViewById(R.id.date);
            maxCelsius = (TextView) itemView.findViewById(R.id.maxCelsius);
            minCelsius = (TextView) itemView.findViewById(R.id.minCelsius);
            maxFeh = (TextView) itemView.findViewById(R.id.maxFeh);
            minFeh = (TextView) itemView.findViewById(R.id.minFeh);
            condition = (TextView) itemView.findViewById(R.id.condition);
            humidity = (TextView) itemView.findViewById(R.id.humidity);
            weatherImage = (ImageView) itemView.findViewById(R.id.weatherImage);
        }
    }
}
