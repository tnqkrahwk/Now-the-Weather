
package kr.hs.buil.neighborhoodweather.model.forecast;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Weather {

    @SerializedName("forecast3days")
    @Expose
    public List<Forecast3day> forecast3days = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Weather() {
    }

    /**
     * 
     * @param forecast3days
     */
    public Weather(List<Forecast3day> forecast3days) {
        super();
        this.forecast3days = forecast3days;
    }

}
