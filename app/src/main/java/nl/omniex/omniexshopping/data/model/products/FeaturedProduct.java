package nl.omniex.omniexshopping.data.model.products;

import com.google.gson.annotations.SerializedName;

public class FeaturedProduct {

    @SerializedName("product_id")
    private Integer mProductId;
    @SerializedName("thumb")
    private String mThumb;
    @SerializedName("name")
    private String mName;
    @SerializedName("price_excluding_tax_formated")
    private String mPriceExcludingTaxFormatted;
    @SerializedName("description")
    private String mDescription;

    public Integer getProductId() {
        return mProductId;
    }

    public void setProductId(Integer productId) {
        mProductId = productId;
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

    public String getPriceExcludingTaxFormatted() {
        return mPriceExcludingTaxFormatted;
    }

    public void setPriceExcludingTaxFormatted(String priceExcludingTaxFormatted) {
        mPriceExcludingTaxFormatted = priceExcludingTaxFormatted;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }
}
