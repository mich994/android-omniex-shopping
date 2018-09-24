package nl.omniex.omniexshopping.data.model.response;

import com.google.gson.annotations.SerializedName;

import nl.omniex.omniexshopping.data.model.address.AddressWrapper;

public class AddressListResponse {

    @SerializedName("data")
    private AddressWrapper mAddressWrapper;

    public AddressWrapper getAddressWrapper() {
        return mAddressWrapper;
    }
}
