package nl.omniex.omniexshopping.data.model.response;

import com.google.gson.annotations.SerializedName;

import nl.omniex.omniexshopping.data.model.cart.Cart;

public class CartResponse {

    @SerializedName("data")
    private Cart mCart;

    public Cart getCart() {
        return mCart;
    }
}
