
package kr.hs.buil.neighborhoodweather.model.forecast;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Temperature {

    @SerializedName("tmax1day")
    @Expose
    public String tmax1day;
    @SerializedName("tmax2day")
    @Expose
    public String tmax2day;
    @SerializedName("tmax3day")
    @Expose
    public String tmax3day;
    @SerializedName("tmin1day")
    @Expose
    public String tmin1day;
    @SerializedName("tmin2day")
    @Expose
    public String tmin2day;
    @SerializedName("tmin3day")
    @Expose
    public String tmin3day;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Temperature() {
    }

    /**
     * 
     * @param tmin3day
     * @param tmax1day
     * @param tmin1day
     * @param tmax2day
     * @param tmin2day
     * @param tmax3day
     */
    public Temperature(String tmax1day, String tmax2day, String tmax3day, String tmin1day, String tmin2day, String tmin3day) {
        super();
        this.tmax1day = tmax1day;
        this.tmax2day = tmax2day;
        this.tmax3day = tmax3day;
        this.tmin1day = tmin1day;
        this.tmin2day = tmin2day;
        this.tmin3day = tmin3day;
    }

}
