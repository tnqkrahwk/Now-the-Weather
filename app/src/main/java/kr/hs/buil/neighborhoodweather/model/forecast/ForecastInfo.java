
package kr.hs.buil.neighborhoodweather.model.forecast;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ForecastInfo {

    @SerializedName("weather")
    @Expose
    public Weather weather;
    @SerializedName("common")
    @Expose
    public Common common;
    @SerializedName("result")
    @Expose
    public Result result;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ForecastInfo() {
    }

    /**
     * 
     * @param result
     * @param common
     * @param weather
     */
    public ForecastInfo(Weather weather, Common common, Result result) {
        super();
        this.weather = weather;
        this.common = common;
        this.result = result;
    }

}
