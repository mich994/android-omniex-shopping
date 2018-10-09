package nl.omniex.omniexshopping.data.model.auth.register;

import com.google.gson.annotations.SerializedName;

public class CustomFieldSetter {

    //street
    @SerializedName("1")
    private String mStreet;

    //company name
    @SerializedName("2")
    private String mCompanyName;

    //tax
    @SerializedName("3")
    private String mTax;

    //city
    @SerializedName("4")
    private String mCity;

    //country
    @SerializedName("5")
    private String mCountry;

    public CustomFieldSetter(String street, String companyName, String tax, String city, String country) {
        mStreet = street;
        mCompanyName = companyName;
        mTax = tax;
        mCity = city;
        mCountry = country;
    }

    public String getStreet() {
        return mStreet;
    }

    public void setStreet(String street) {
        mStreet = street;
    }

    public String getCompanyName() {
        return mCompanyName;
    }

    public void setCompanyName(String companyName) {
        mCompanyName = companyName;
    }

    public String getTax() {
        return mTax;
    }

    public void setTax(String tax) {
        mTax = tax;
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
}
