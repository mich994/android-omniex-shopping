package nl.omniex.omniexshopping.data.model.order;

import com.google.gson.annotations.SerializedName;

public class OrderStatus {

    @SerializedName("name")
    private String mName;
    @SerializedName("status")
    private String mStatus;
    @SerializedName("date_added")
    private String mDateAdded;
    @SerializedName("products")
    private String mProducts;
    @SerializedName("total")
    private String mTotalPrice;

    public String getName() {
        return mName;
    }

    public String getStatus() {
        return mStatus;
    }

    public String getDateAdded() {
        return mDateAdded;
    }

    public String getProducts() {
        return mProducts;
    }

    public String getTotalPrice() {
        return mTotalPrice;
    }
}
