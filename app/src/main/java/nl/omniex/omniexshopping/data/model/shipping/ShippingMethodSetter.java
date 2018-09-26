package nl.omniex.omniexshopping.data.model.shipping;

import com.google.gson.annotations.SerializedName;

public class ShippingMethodSetter {

    @SerializedName("shipping_method")
    private String mShippingMethod;
    @SerializedName("comment")
    private String mComment;

    public ShippingMethodSetter(String shippingMethod, String comment) {
        mShippingMethod = shippingMethod;
        mComment = comment;
    }

    public String getShippingMethod() {
        return mShippingMethod;
    }

    public void setShippingMethod(String shippingMethod) {
        mShippingMethod = shippingMethod;
    }

    public String getComment() {
        return mComment;
    }

    public void setComment(String comment) {
        mComment = comment;
    }
}
