
package kr.hs.buil.neighborhoodweather.model.forecast;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Grid {

    @SerializedName("longitude")
    @Expose
    public String longitude;
    @SerializedName("latitude")
    @Expose
    public String latitude;
    @SerializedName("city")
    @Expose
    public String city;
    @SerializedName("county")
    @Expose
    public String county;
    @SerializedName("village")
    @Expose
    public String village;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Grid() {
    }

    /**
     * 
     * @param village
     * @param county
     * @param longitude
     * @param latitude
     * @param city
     */
    public Grid(String longitude, String latitude, String city, String county, String village) {
        super();
        this.longitude = longitude;
        this.latitude = latitude;
        this.city = city;
        this.county = county;
        this.village = village;
    }

}
