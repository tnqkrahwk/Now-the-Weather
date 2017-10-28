
package kr.hs.buil.neighborhoodweather.model.forecast;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Temperature_ {

    @SerializedName("temp4hour")
    @Expose
    public String temp4hour;
    @SerializedName("temp7hour")
    @Expose
    public String temp7hour;
    @SerializedName("temp10hour")
    @Expose
    public String temp10hour;
    @SerializedName("temp13hour")
    @Expose
    public String temp13hour;
    @SerializedName("temp16hour")
    @Expose
    public String temp16hour;
    @SerializedName("temp19hour")
    @Expose
    public String temp19hour;
    @SerializedName("temp22hour")
    @Expose
    public String temp22hour;
    @SerializedName("temp25hour")
    @Expose
    public String temp25hour;
    @SerializedName("temp28hour")
    @Expose
    public String temp28hour;
    @SerializedName("temp31hour")
    @Expose
    public String temp31hour;
    @SerializedName("temp34hour")
    @Expose
    public String temp34hour;
    @SerializedName("temp37hour")
    @Expose
    public String temp37hour;
    @SerializedName("temp40hour")
    @Expose
    public String temp40hour;
    @SerializedName("temp43hour")
    @Expose
    public String temp43hour;
    @SerializedName("temp46hour")
    @Expose
    public String temp46hour;
    @SerializedName("temp49hour")
    @Expose
    public String temp49hour;
    @SerializedName("temp52hour")
    @Expose
    public String temp52hour;
    @SerializedName("temp55hour")
    @Expose
    public String temp55hour;
    @SerializedName("temp58hour")
    @Expose
    public String temp58hour;
    @SerializedName("temp61hour")
    @Expose
    public String temp61hour;
    @SerializedName("temp64hour")
    @Expose
    public String temp64hour;
    @SerializedName("temp67hour")
    @Expose
    public String temp67hour;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Temperature_() {
    }

    /**
     * 
     * @param temp37hour
     * @param temp19hour
     * @param temp25hour
     * @param temp64hour
     * @param temp10hour
     * @param temp49hour
     * @param temp28hour
     * @param temp58hour
     * @param temp22hour
     * @param temp61hour
     * @param temp31hour
     * @param temp67hour
     * @param temp43hour
     * @param temp55hour
     * @param temp52hour
     * @param temp13hour
     * @param temp4hour
     * @param temp7hour
     * @param temp40hour
     * @param temp46hour
     * @param temp16hour
     * @param temp34hour
     */
    public Temperature_(String temp4hour, String temp7hour, String temp10hour, String temp13hour, String temp16hour, String temp19hour, String temp22hour, String temp25hour, String temp28hour, String temp31hour, String temp34hour, String temp37hour, String temp40hour, String temp43hour, String temp46hour, String temp49hour, String temp52hour, String temp55hour, String temp58hour, String temp61hour, String temp64hour, String temp67hour) {
        super();
        this.temp4hour = temp4hour;
        this.temp7hour = temp7hour;
        this.temp10hour = temp10hour;
        this.temp13hour = temp13hour;
        this.temp16hour = temp16hour;
        this.temp19hour = temp19hour;
        this.temp22hour = temp22hour;
        this.temp25hour = temp25hour;
        this.temp28hour = temp28hour;
        this.temp31hour = temp31hour;
        this.temp34hour = temp34hour;
        this.temp37hour = temp37hour;
        this.temp40hour = temp40hour;
        this.temp43hour = temp43hour;
        this.temp46hour = temp46hour;
        this.temp49hour = temp49hour;
        this.temp52hour = temp52hour;
        this.temp55hour = temp55hour;
        this.temp58hour = temp58hour;
        this.temp61hour = temp61hour;
        this.temp64hour = temp64hour;
        this.temp67hour = temp67hour;
    }

}
