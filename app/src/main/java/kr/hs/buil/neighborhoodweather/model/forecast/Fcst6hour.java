
package kr.hs.buil.neighborhoodweather.model.forecast;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Fcst6hour {

    @SerializedName("snow30hour")
    @Expose
    public String snow30hour;
    @SerializedName("snow12hour")
    @Expose
    public String snow12hour;
    @SerializedName("snow24hour")
    @Expose
    public String snow24hour;
    @SerializedName("snow18hour")
    @Expose
    public String snow18hour;
    @SerializedName("rain6hour")
    @Expose
    public String rain6hour;
    @SerializedName("rain12hour")
    @Expose
    public String rain12hour;
    @SerializedName("rain18hour")
    @Expose
    public String rain18hour;
    @SerializedName("rain24hour")
    @Expose
    public String rain24hour;
    @SerializedName("rain30hour")
    @Expose
    public String rain30hour;
    @SerializedName("rain36hour")
    @Expose
    public String rain36hour;
    @SerializedName("rain42hour")
    @Expose
    public String rain42hour;
    @SerializedName("rain48hour")
    @Expose
    public String rain48hour;
    @SerializedName("rain54hour")
    @Expose
    public String rain54hour;
    @SerializedName("snow6hour")
    @Expose
    public String snow6hour;
    @SerializedName("snow36hour")
    @Expose
    public String snow36hour;
    @SerializedName("snow42hour")
    @Expose
    public String snow42hour;
    @SerializedName("snow48hour")
    @Expose
    public String snow48hour;
    @SerializedName("snow54hour")
    @Expose
    public String snow54hour;
    @SerializedName("rain60hour")
    @Expose
    public String rain60hour;
    @SerializedName("rain66hour")
    @Expose
    public String rain66hour;
    @SerializedName("snow60hour")
    @Expose
    public String snow60hour;
    @SerializedName("snow66hour")
    @Expose
    public String snow66hour;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Fcst6hour() {
    }

    /**
     * 
     * @param snow12hour
     * @param rain6hour
     * @param snow48hour
     * @param snow18hour
     * @param rain18hour
     * @param snow60hour
     * @param rain12hour
     * @param rain30hour
     * @param rain36hour
     * @param rain42hour
     * @param snow66hour
     * @param snow54hour
     * @param snow42hour
     * @param rain48hour
     * @param snow24hour
     * @param rain54hour
     * @param snow30hour
     * @param rain66hour
     * @param snow6hour
     * @param rain60hour
     * @param snow36hour
     * @param rain24hour
     */
    public Fcst6hour(String snow30hour, String snow12hour, String snow24hour, String snow18hour, String rain6hour, String rain12hour, String rain18hour, String rain24hour, String rain30hour, String rain36hour, String rain42hour, String rain48hour, String rain54hour, String snow6hour, String snow36hour, String snow42hour, String snow48hour, String snow54hour, String rain60hour, String rain66hour, String snow60hour, String snow66hour) {
        super();
        this.snow30hour = snow30hour;
        this.snow12hour = snow12hour;
        this.snow24hour = snow24hour;
        this.snow18hour = snow18hour;
        this.rain6hour = rain6hour;
        this.rain12hour = rain12hour;
        this.rain18hour = rain18hour;
        this.rain24hour = rain24hour;
        this.rain30hour = rain30hour;
        this.rain36hour = rain36hour;
        this.rain42hour = rain42hour;
        this.rain48hour = rain48hour;
        this.rain54hour = rain54hour;
        this.snow6hour = snow6hour;
        this.snow36hour = snow36hour;
        this.snow42hour = snow42hour;
        this.snow48hour = snow48hour;
        this.snow54hour = snow54hour;
        this.rain60hour = rain60hour;
        this.rain66hour = rain66hour;
        this.snow60hour = snow60hour;
        this.snow66hour = snow66hour;
    }

}
