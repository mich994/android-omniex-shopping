package nl.omniex.omniexshopping.data.model.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import nl.omniex.omniexshopping.data.model.products.Product;

public class ProductsListResponse {

    @SerializedName("data")
    private List<Product> mProductList;

    public List<Product> getProductList() {
        return mProductList;
    }
}
