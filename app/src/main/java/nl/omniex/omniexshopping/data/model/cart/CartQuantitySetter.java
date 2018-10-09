package nl.omniex.omniexshopping.data.model.cart;

import com.google.gson.annotations.SerializedName;

public class CartQuantitySetter {

    @SerializedName("key")
    private String mProductKey;
    @SerializedName("quantity")
    private Integer mQuantitity;

    public CartQuantitySetter(String productKey, Integer quantitity) {
        mProductKey = productKey;
        mQuantitity = quantitity;
    }

    public String getProductKey() {

        return mProductKey;
    }

    public void setProductKey(String productKey) {
        mProductKey = productKey;
    }

    public Integer getQuantitity() {
        return mQuantitity;
    }

    public void setQuantitity(Integer quantitity) {
        mQuantitity = quantitity;
    }
}
