
package kr.hs.buil.neighborhoodweather.model.forecast;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Forecast3day {

    @SerializedName("grid")
    @Expose
    public Grid grid;
    @SerializedName("fcstdaily")
    @Expose
    public Fcstdaily fcstdaily;
    @SerializedName("timeRelease")
    @Expose
    public String timeRelease;
    @SerializedName("fcst3hour")
    @Expose
    public Fcst3hour fcst3hour;
    @SerializedName("fcst6hour")
    @Expose
    public Fcst6hour fcst6hour;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Forecast3day() {
    }

    /**
     * 
     * @param fcst3hour
     * @param timeRelease
     * @param grid
     * @param fcst6hour
     * @param fcstdaily
     */
    public Forecast3day(Grid grid, Fcstdaily fcstdaily, String timeRelease, Fcst3hour fcst3hour, Fcst6hour fcst6hour) {
        super();
        this.grid = grid;
        this.fcstdaily = fcstdaily;
        this.timeRelease = timeRelease;
        this.fcst3hour = fcst3hour;
        this.fcst6hour = fcst6hour;
    }

}
