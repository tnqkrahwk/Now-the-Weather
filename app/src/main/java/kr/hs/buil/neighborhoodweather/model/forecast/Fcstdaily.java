
package kr.hs.buil.neighborhoodweather.model.forecast;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Fcstdaily {

    @SerializedName("temperature")
    @Expose
    public Temperature temperature;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Fcstdaily() {
    }

    /**
     * 
     * @param temperature
     */
    public Fcstdaily(Temperature temperature) {
        super();
        this.temperature = temperature;
    }

}
