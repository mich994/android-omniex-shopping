package nl.omniex.omniexshopping.data.model.address;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Zone {

    @SerializedName("country_id")
    private Integer mCountryId;
    @SerializedName("country_name")
    private String mCountryName;
    @SerializedName("zone")
    private ArrayList<Province> mProvinceList;

    public Integer getCountryId() {
        return mCountryId;
    }

    public String getCountryName() {
        return mCountryName;
    }

    public List<Province> getProvinceList() {
        return mProvinceList;
    }
}
