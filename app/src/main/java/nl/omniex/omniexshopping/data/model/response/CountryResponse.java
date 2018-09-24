package nl.omniex.omniexshopping.data.model.response;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import nl.omniex.omniexshopping.data.model.address.Country;

public class CountryResponse {

    @SerializedName("data")
    private ArrayList<Country> mCountryList;

    public List<Country> getCountryList() {
        return mCountryList;
    }
}
