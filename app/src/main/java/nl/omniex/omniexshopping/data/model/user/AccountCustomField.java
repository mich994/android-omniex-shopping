package nl.omniex.omniexshopping.data.model.user;

import com.google.gson.annotations.SerializedName;

public class AccountCustomField {

    @SerializedName("2")
    private String mCompanyName;
    @SerializedName("1")
    private String mStreet;
    @SerializedName("4")
    private String mCity;
    @SerializedName("5")
    private String mCountry;
    @SerializedName("3")
    private String mTaxNumber;

    public String getCompanyName() {
        return mCompanyName;
    }

    public void setCompanyName(String companyName) {
        mCompanyName = companyName;
    }

    public String getStreet() {
        return mStreet;
    }

    public void setStreet(String street) {
        mStreet = street;
    }

    public String getCity() {
        return mCity;
    }

    public void setCity(String city) {
        mCity = city;
    }

    public String getCountry() {
        return mCountry;
    }

    public void setCountry(String country) {
        mCountry = country;
    }

    public String getTaxNumber() {
        return mTaxNumber;
    }

    public void setTaxNumber(String taxNumber) {
        mTaxNumber = taxNumber;
    }
}
