package nl.omniex.omniexshopping.data.model.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import nl.omniex.omniexshopping.data.model.products.FeaturedProductWrapper;

public class FeaturedProductsResponse {

    @SerializedName("success")
    private Integer mSuccess;
    @SerializedName("error")
    private List<String> mErrors;
    @SerializedName("data")
    private List<FeaturedProductWrapper> mProductWrappers;

    public Integer getSuccess() {
        return mSuccess;
    }

    public void setSuccess(Integer success) {
        mSuccess = success;
    }

    public List<String> getErrors() {
        return mErrors;
    }

    public void setErrors(List<String> errors) {
        mErrors = errors;
    }

    public List<FeaturedProductWrapper> getProductWrappers() {
        return mProductWrappers;
    }

    public void setProductWrappers(List<FeaturedProductWrapper> productWrappers) {
        mProductWrappers = productWrappers;
    }
}
