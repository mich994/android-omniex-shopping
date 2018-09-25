package nl.omniex.omniexshopping.data.model.order;

import com.google.gson.annotations.SerializedName;

public class OrderAddress {

    @SerializedName("firstname")
    private String mFirstName;
    @SerializedName("lastname")
    private String mLastName;
    @SerializedName("city")
    private String mCity;
    @SerializedName("address_1")
    private String mAddressOne;
    @SerializedName("address_2")
    private String mAddressTwo;
    @SerializedName("country_id")
    private String mCountryId;
    @SerializedName("postcode")
    private String mPostcode;
    @SerializedName("zone_id")
    private String mZoneId;

    public OrderAddress(String firstName, String lastName, String city, String addressOne, String addressTwo, String countryId, String postcode, String zoneId) {
        mFirstName = firstName;
        mLastName = lastName;
        mCity = city;
        mAddressOne = addressOne;
        mAddressTwo = addressTwo;
        mCountryId = countryId;
        mPostcode = postcode;
        mZoneId = zoneId;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String firstName) {
        mFirstName = firstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public void setLastName(String lastName) {
        mLastName = lastName;
    }

    public String getCity() {
        return mCity;
    }

    public void setCity(String city) {
        mCity = city;
    }

    public String getAddressOne() {
        return mAddressOne;
    }

    public void setAddressOne(String addressOne) {
        mAddressOne = addressOne;
    }

    public String getAddressTwo() {
        return mAddressTwo;
    }

    public void setAddressTwo(String addressTwo) {
        mAddressTwo = addressTwo;
    }

    public String getCountryId() {
        return mCountryId;
    }

    public void setCountryId(String countryId) {
        mCountryId = countryId;
    }

    public String getPostcode() {
        return mPostcode;
    }

    public void setPostcode(String postcode) {
        mPostcode = postcode;
    }

    public String getZoneId() {
        return mZoneId;
    }

    public void setZoneId(String zoneId) {
        mZoneId = zoneId;
    }
}
