package nl.omniex.omniexshopping.data.model.order;

import com.google.gson.annotations.SerializedName;

public class ExistingAddress {

    @SerializedName("address_id")
    private Integer mAddressId;

    public ExistingAddress(Integer addressId) {
        mAddressId = addressId;
    }

    public Integer getAddressId() {
        return mAddressId;
    }

    public void setAddressId(Integer addressId) {
        mAddressId = addressId;
    }
}
