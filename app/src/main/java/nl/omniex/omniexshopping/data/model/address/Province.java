package nl.omniex.omniexshopping.data.model.address;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Province implements Serializable {

    @SerializedName("zone_id")
    private String mZoneId;
    @SerializedName("country_id")
    private String mCountryId;
    @SerializedName("name")
    private String mName;
    @SerializedName("code")
    private String mCode;

    public Province(String zoneId, String countryId, String name, String code) {
        mZoneId = zoneId;
        mCountryId = countryId;
        mName = name;
        mCode = code;
    }

    public String getZoneId() {
        return mZoneId;
    }

    public String getCountryId() {
        return mCountryId;
    }

    public String getName() {
        return mName;
    }

    public String getCode() {
        return mCode;
    }

    public String getFullName() {
        return mName + ", " + mCode;
    }
}
