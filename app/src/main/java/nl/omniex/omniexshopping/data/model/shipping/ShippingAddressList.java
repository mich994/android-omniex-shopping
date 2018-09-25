package nl.omniex.omniexshopping.data.model.shipping;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import nl.omniex.omniexshopping.data.model.address.Address;

public class ShippingAddressList {

    @SerializedName("address_id")
    private String mCurrentAddressId;
    @SerializedName("addresses")
    private List<Address> mAddressList;

    public String getCurrentAddressId() {
        return mCurrentAddressId;
    }

    public List<Address> getAddressList() {
        return mAddressList;
    }
}
