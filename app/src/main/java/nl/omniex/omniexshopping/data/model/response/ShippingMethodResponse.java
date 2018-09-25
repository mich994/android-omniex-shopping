package nl.omniex.omniexshopping.data.model.response;

import com.google.gson.annotations.SerializedName;

import nl.omniex.omniexshopping.data.model.shipping.ShippingMethodWrapper;

public class ShippingMethodResponse {

    @SerializedName("data")
    private ShippingMethodWrapper mShippingMethodWrapper;

    public ShippingMethodWrapper getShippingMethodWrapper() {
        return mShippingMethodWrapper;
    }
}
