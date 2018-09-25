package nl.omniex.omniexshopping.data.model.shipping;

import com.google.gson.annotations.SerializedName;

public class ShippingMethodWrapper {

    @SerializedName("shipping_methods")
    private ShippingMethod mShippingMethod;

    public ShippingMethod getShippingMethod() {
        return mShippingMethod;
    }
}
