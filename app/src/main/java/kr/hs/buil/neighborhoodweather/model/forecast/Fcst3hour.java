
package kr.hs.buil.neighborhoodweather.model.forecast;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Fcst3hour {

    @SerializedName("wind")
    @Expose
    public Wind wind;
    @SerializedName("precipitation")
    @Expose
    public Precipitation precipitation;
    @SerializedName("sky")
    @Expose
    public Sky sky;
    @SerializedName("temperature")
    @Expose
    public Temperature_ temperature;
    @SerializedName("humidity")
    @Expose
    public Humidity humidity;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Fcst3hour() {
    }

    /**
     * 
     * @param wind
     * @param humidity
     * @param sky
     * @param precipitation
     * @param temperature
     */
    public Fcst3hour(Wind wind, Precipitation precipitation, Sky sky, Temperature_ temperature, Humidity humidity) {
        super();
        this.wind = wind;
        this.precipitation = precipitation;
        this.sky = sky;
        this.temperature = temperature;
        this.humidity = humidity;
    }

}
