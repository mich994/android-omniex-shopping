package nl.omniex.omniexshopping.data.model.cart;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class Cart implements Serializable {

    @SerializedName("products")
    private ArrayList<CartProduct> mCartProducts;
    @SerializedName("total")
    private String mTotal;

    public ArrayList<CartProduct> getCartProducts() {
        return mCartProducts;
    }

    public String getTotal() {
        return mTotal;
    }
}
