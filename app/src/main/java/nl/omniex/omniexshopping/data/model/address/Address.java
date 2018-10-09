package nl.omniex.omniexshopping.data.model.address;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Address implements Serializable {

    @SerializedName("address_id")
    private String mAddressId;
    @SerializedName("firstname")
    private String mFirstName;
    @SerializedName("lastname")
    private String mLastName;
    @SerializedName("company")
    private String mCompanyName;
    @SerializedName("address_1")
    private String mAddressOne;
    @SerializedName("address_2")
    private String mAddressTwo;
    @SerializedName("postcode")
    private String mPostcode;
    @SerializedName("city")
    private String mCity;
    @SerializedName("zone_id")
    private String mZoneId;
    @SerializedName("zone")
    private String mZoneName;
    @SerializedName("zone_code")
    private String mZoneCode;
    @SerializedName("country_id")
    private String mCountryId;
    @SerializedName("country")
    private String mCountry;
    @SerializedName("iso_code_2")
    private String mIsoCodeTwo;

    public String getAddressThumb() {
        return mAddressOne + " " + mAddressTwo + ", " + mCity + ", " + mZoneName + ", " + mCountry;
    }

    public String getCountryNameFormated() {
        return mCountry + ", " + mIsoCodeTwo;
    }

    public String getZoneNameFormated() {
        return mZoneName + ", " + mZoneCode;
    }

    public String getAddressId() {
        return mAddressId;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public String getCompanyName() {
        return mCompanyName;
    }

    public String getAddressOne() {
        return mAddressOne;
    }

    public String getAddressTwo() {
        return mAddressTwo;
    }

    public String getPostcode() {
        return mPostcode;
    }

    public String getCity() {
        return mCity;
    }

    public String getZoneId() {
        return mZoneId;
    }

    public String getZoneName() {
        return mZoneName;
    }

    public String getZoneCode() {
        return mZoneCode;
    }

    public String getCountryId() {
        return mCountryId;
    }

    public String getCountry() {
        return mCountry;
    }

    public String getIsoCodeTwo() {
        return mIsoCodeTwo;
    }

    @Override
    public int hashCode() {
        int code = 0;
        code = mCity.hashCode();
        code += mAddressOne.hashCode();
        code += mPostcode.hashCode();
        return code;
    }

    @Override
    public boolean equals(Object obj) {
        Address address = (Address) obj;
        return address.getCity().equals(mCity) && address.getAddressOne().equals(mAddressOne) && address.getPostcode().equals(mPostcode);
    }
}
