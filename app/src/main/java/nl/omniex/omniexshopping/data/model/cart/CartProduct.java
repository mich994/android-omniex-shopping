package nl.omniex.omniexshopping.data.model.cart;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class CartProduct implements Serializable {

    @SerializedName("key")
    private String mKey;
    @SerializedName("thumb")
    private String mThumb;
    @SerializedName("name")
    private String mName;
    @SerializedName("product_id")
    private String mProductId;
    @SerializedName("quantity")
    private String mQuantity;
    @SerializedName("stock")
    private Boolean mIsInStock;
    @SerializedName("price")
    private String mPrice;
    @SerializedName("total")
    private String mTotalPrice;

    public String getKey() {
        return mKey;
    }

    public void setKey(String key) {
        mKey = key;
    }

    public String getThumb() {
        return mThumb;
    }

    public void setThumb(String thumb) {
        mThumb = thumb;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getProductId() {
        return mProductId;
    }

    public void setProductId(String productId) {
        mProductId = productId;
    }

    public String getQuantity() {
        return mQuantity;
    }

    public void setQuantity(String quantity) {
        mQuantity = quantity;
    }

    public Boolean getInStock() {
        return mIsInStock;
    }

    public void setInStock(Boolean inStock) {
        mIsInStock = inStock;
    }

    public String getPrice() {
        return mPrice;
    }

    public void setPrice(String price) {
        mPrice = price;
    }

    public String getTotalPrice() {
        return mTotalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        mTotalPrice = totalPrice;
    }
}
