
package kr.hs.buil.neighborhoodweather.model.weather;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Common {

    @SerializedName("alertYn")
    @Expose
    public String alertYn;
    @SerializedName("stormYn")
    @Expose
    public String stormYn;

}
