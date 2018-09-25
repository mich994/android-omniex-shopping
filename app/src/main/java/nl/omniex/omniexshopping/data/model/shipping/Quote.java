package nl.omniex.omniexshopping.data.model.shipping;

import com.google.gson.annotations.SerializedName;

public class Quote {

    @SerializedName("weight_8")
    private WeightCode mWeightCode;

    public WeightCode getWeightCode() {
        return mWeightCode;
    }
}
