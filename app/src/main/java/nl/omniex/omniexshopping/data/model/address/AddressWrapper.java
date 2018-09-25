package nl.omniex.omniexshopping.data.model.address;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AddressWrapper {

    @SerializedName("addresses")
    private List<Address> mAddressList;

    public List<Address> getAddressList() {
        return mAddressList;
    }
}
