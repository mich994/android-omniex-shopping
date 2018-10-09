package nl.omniex.omniexshopping.data.model.shipping;

import com.google.gson.annotations.SerializedName;

public class WeightCode {

    @SerializedName("code")
    private String mCode;
    @SerializedName("title")
    private String mTitle;
    @SerializedName("text")
    private String mPriceText;
    @SerializedName("cost")
    private String mCost;

    public String getCode() {
        return mCode;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getPriceText() {
        return mPriceText;
    }

    public String getCost() {
        return mCost;
    }
}
