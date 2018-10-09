package nl.omniex.omniexshopping.data.model.shipping;

import com.google.gson.annotations.SerializedName;

public class ShippingMethod {

    @SerializedName("weight")
    private Weight mWeight;

    public Weight getWeight() {
        return mWeight;
    }
}
