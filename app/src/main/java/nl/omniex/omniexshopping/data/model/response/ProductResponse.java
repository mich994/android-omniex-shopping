package nl.omniex.omniexshopping.data.model.response;

import com.google.gson.annotations.SerializedName;

import nl.omniex.omniexshopping.data.model.products.Product;

public class ProductResponse {

    @SerializedName("data")
    private Product mProduct;

    public Product getProduct() {
        return mProduct;
    }

    public void setProduct(Product product) {
        mProduct = product;
    }
}
