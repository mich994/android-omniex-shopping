package nl.omniex.omniexshopping.data.model.products;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FeaturedProductWrapper {

    @SerializedName("module_id")
    private Integer mModuleId;
    @SerializedName("name")
    private String mName;
    @SerializedName("code")
    private String mCode;
    @SerializedName("products")
    private List<FeaturedProduct> mFeaturedProducts;

    public Integer getModuleId() {
        return mModuleId;
    }

    public void setModuleId(Integer moduleId) {
        mModuleId = moduleId;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getCode() {
        return mCode;
    }

    public void setCode(String code) {
        mCode = code;
    }

    public List<FeaturedProduct> getFeaturedProducts() {
        return mFeaturedProducts;
    }

    public void setFeaturedProducts(List<FeaturedProduct> featuredProducts) {
        mFeaturedProducts = featuredProducts;
    }
}
