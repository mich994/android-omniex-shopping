package nl.omniex.omniexshopping.data.model.user;

import com.google.gson.annotations.SerializedName;

public class Address {

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
    @SerializedName("company")
    private String mCompany;
    @SerializedName("default")
    private Integer mDefault;

    public Address(String firstName, String lastName, String city, String addressOne, String addressTwo, String postcode, String company) {
        mFirstName = firstName;
        mLastName = lastName;
        mCity = city;
        mAddressOne = addressOne;
        mAddressTwo = addressTwo;
        mPostcode = postcode;
        mCompany = company;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public String getCity() {
        return mCity;
    }

    public String getAddressOne() {
        return mAddressOne;
    }

    public String getAddressTwo() {
        return mAddressTwo;
    }

    public String getCountryId() {
        return mCountryId;
    }

    public String getPostcode() {
        return mPostcode;
    }

    public String getZoneId() {
        return mZoneId;
    }

    public String getCompany() {
        return mCompany;
    }

    public Integer getDefault() {
        return mDefault;
    }
}
