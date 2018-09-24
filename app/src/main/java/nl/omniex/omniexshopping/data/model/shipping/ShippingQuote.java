package nl.omniex.omniexshopping.data.model.shipping;

import com.google.gson.annotations.SerializedName;

public class ShippingQuote {

    @SerializedName("country_id")
    private String mCountryId;
    @SerializedName("zone_id")
    private String mZoneId;
    @SerializedName("postcode")
    private String mPostcode;

    public ShippingQuote(String countryId, String zoneId, String postcode) {
        mCountryId = countryId;
        mZoneId = zoneId;
        mPostcode = postcode;
    }

    public String getCountryId() {
        return mCountryId;
    }

    public String getZoneId() {
        return mZoneId;
    }

    public String getPostcode() {
        return mPostcode;
    }
}
