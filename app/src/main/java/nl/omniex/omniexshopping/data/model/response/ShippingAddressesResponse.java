package nl.omniex.omniexshopping.data.model.response;

import com.google.gson.annotations.SerializedName;

import nl.omniex.omniexshopping.data.model.shipping.ShippingAddressList;

public class ShippingAddressesResponse {

    @SerializedName("data")
    private ShippingAddressList mShippingAddressList;

    public ShippingAddressList getShippingAddressList() {
        return mShippingAddressList;
    }
}
