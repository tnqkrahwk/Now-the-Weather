
package kr.hs.buil.neighborhoodweather.model.forecast;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("code")
    @Expose
    public Integer code;
    @SerializedName("requestUrl")
    @Expose
    public String requestUrl;
    @SerializedName("message")
    @Expose
    public String message;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Result() {
    }

    /**
     * 
     * @param message
     * @param code
     * @param requestUrl
     */
    public Result(Integer code, String requestUrl, String message) {
        super();
        this.code = code;
        this.requestUrl = requestUrl;
        this.message = message;
    }

}
