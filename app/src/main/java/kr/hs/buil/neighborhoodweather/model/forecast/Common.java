
package kr.hs.buil.neighborhoodweather.model.forecast;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Common {

    @SerializedName("alertYn")
    @Expose
    public String alertYn;
    @SerializedName("stormYn")
    @Expose
    public String stormYn;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Common() {
    }

    /**
     * 
     * @param alertYn
     * @param stormYn
     */
    public Common(String alertYn, String stormYn) {
        super();
        this.alertYn = alertYn;
        this.stormYn = stormYn;
    }

}
