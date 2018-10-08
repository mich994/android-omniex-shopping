package nl.omniex.omniexshopping.data.model.cart;

import com.google.gson.annotations.SerializedName;

public class CartItemDelete {

    @SerializedName("key")
    private Integer mKey;

    public CartItemDelete(Integer key) {
        mKey = key;
    }

    public Integer getKey() {
        return mKey;
    }

    public void setKey(Integer key) {
        mKey = key;
    }
}
