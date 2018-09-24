package nl.omniex.omniexshopping.data.model.address;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Country implements Serializable{

    @SerializedName("country_id")
    private Integer mCountryId;
    @SerializedName("name")
    private String mName;
    @SerializedName("iso_code_2")
    private String mIsoCode;

    public Country(Integer countryId, String name, String isoCode) {
        mCountryId = countryId;
        mName = name;
        mIsoCode = isoCode;
    }

    public Integer getCountryId() {
        return mCountryId;
    }

    public String getName() {
        return mName;
    }

    public String getIsoCode() {
        return mIsoCode;
    }

    public String getFullName(){
        return mName+", "+mIsoCode;
    }
}
