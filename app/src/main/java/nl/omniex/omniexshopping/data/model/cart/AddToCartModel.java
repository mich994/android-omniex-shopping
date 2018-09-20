package nl.omniex.omniexshopping.data.model.cart;

import com.google.gson.annotations.SerializedName;

public class AddToCartModel {

    @SerializedName("product_id")
    private String mProductId;
    @SerializedName("quantity")
    private String mQuantity;

    public AddToCartModel(String productId, String quantity) {
        mProductId = productId;
        mQuantity = quantity;
    }
}
