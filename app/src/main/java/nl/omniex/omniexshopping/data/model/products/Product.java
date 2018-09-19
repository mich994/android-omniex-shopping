package nl.omniex.omniexshopping.data.model.products;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Product {

    @SerializedName("product_id")
    private Integer mProductId;
    @SerializedName("name")
    private String mName;
    @SerializedName("manufacturer")
    private String mManufacturer;
    @SerializedName("model")
    private String mModel;
    @SerializedName("image")
    private String mImageUrl;
    @SerializedName("images")
    private List<String> mImageUrlsList;
    @SerializedName("original_image")
    private String mOriginalImageUrl;
    @SerializedName("original_images")
    private List<String> mOriginalImageUrlsList;
    @SerializedName("price_excluding_tax")
    private Double mPriceExcTax;
    @SerializedName("price_excluding_tax_formated")
    private String mPriceExcTaxFormated;
    @SerializedName("rating")
    private Double mRating;
    @SerializedName("description")
    private String mDescription;
    @SerializedName("minimum")
    private String mMinimum;
    @SerializedName("meta_title")
    private String mMetaTitle;
    @SerializedName("meta_description")
    private String mMetaDescription;
    @SerializedName("tag")
    private String mTag;
    @SerializedName("stock_status")
    private String mStockStatus;
    @SerializedName("stock_status_id")
    private Integer mStockStatusId;
    @SerializedName("manufacturer_id")
    private Integer mManufacturerId;
    @SerializedName("tax_class_id")
    private Integer mTaxClassId;
    @SerializedName("date_available")
    private String mDateAvailable;
    @SerializedName("weight")
    private String mWeight;
    @SerializedName("weight_class_id")
    private Integer mWeightClassId;
    @SerializedName("status")
    private String mStatus;
    @SerializedName("date_modified")
    private String mDateModified;
    @SerializedName("viewed")
    private String mViewed;
    @SerializedName("weight_class")
    private String mWeightClass;
    @SerializedName("length_class")
    private String mLenghtClass;
    @SerializedName("reward")
    private String mReward;
    @SerializedName("category")
    private List<Category> mCategories;
    @SerializedName("quantity")
    private Integer mQuantity;

    public Integer getProductId() {
        return mProductId;
    }

    public void setProductId(Integer productId) {
        mProductId = productId;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getManufacturer() {
        return mManufacturer;
    }

    public void setManufacturer(String manufacturer) {
        mManufacturer = manufacturer;
    }

    public String getModel() {
        return mModel;
    }

    public void setModel(String model) {
        mModel = model;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        mImageUrl = imageUrl;
    }

    public List<String> getImageUrlsList() {
        return mImageUrlsList;
    }

    public void setImageUrlsList(List<String> imageUrlsList) {
        mImageUrlsList = imageUrlsList;
    }

    public String getOriginalImageUrl() {
        return mOriginalImageUrl;
    }

    public void setOriginalImageUrl(String originalImageUrl) {
        mOriginalImageUrl = originalImageUrl;
    }

    public List<String> getOriginalImageUrlsList() {
        return mOriginalImageUrlsList;
    }

    public void setOriginalImageUrlsList(List<String> originalImageUrlsList) {
        mOriginalImageUrlsList = originalImageUrlsList;
    }

    public Double getPriceExcTax() {
        return mPriceExcTax;
    }

    public void setPriceExcTax(Double priceExcTax) {
        mPriceExcTax = priceExcTax;
    }

    public String getPriceExcTaxFormated() {
        return mPriceExcTaxFormated;
    }

    public void setPriceExcTaxFormated(String priceExcTaxFormated) {
        mPriceExcTaxFormated = priceExcTaxFormated;
    }

    public Double getRating() {
        return mRating;
    }

    public void setRating(Double rating) {
        mRating = rating;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public String getMinimum() {
        return mMinimum;
    }

    public void setMinimum(String minimum) {
        mMinimum = minimum;
    }

    public String getMetaTitle() {
        return mMetaTitle;
    }

    public void setMetaTitle(String metaTitle) {
        mMetaTitle = metaTitle;
    }

    public String getMetaDescription() {
        return mMetaDescription;
    }

    public void setMetaDescription(String metaDescription) {
        mMetaDescription = metaDescription;
    }

    public String getTag() {
        return mTag;
    }

    public void setTag(String tag) {
        mTag = tag;
    }

    public String getStockStatus() {
        return mStockStatus;
    }

    public void setStockStatus(String stockStatus) {
        mStockStatus = stockStatus;
    }

    public Integer getStockStatusId() {
        return mStockStatusId;
    }

    public void setStockStatusId(Integer stockStatusId) {
        mStockStatusId = stockStatusId;
    }

    public Integer getManufacturerId() {
        return mManufacturerId;
    }

    public void setManufacturerId(Integer manufacturerId) {
        mManufacturerId = manufacturerId;
    }

    public Integer getTaxClassId() {
        return mTaxClassId;
    }

    public void setTaxClassId(Integer taxClassId) {
        mTaxClassId = taxClassId;
    }

    public String getDateAvailable() {
        return mDateAvailable;
    }

    public void setDateAvailable(String dateAvailable) {
        mDateAvailable = dateAvailable;
    }

    public String getWeight() {
        return mWeight;
    }

    public void setWeight(String weight) {
        mWeight = weight;
    }

    public Integer getWeightClassId() {
        return mWeightClassId;
    }

    public void setWeightClassId(Integer weightClassId) {
        mWeightClassId = weightClassId;
    }

    public String getStatus() {
        return mStatus;
    }

    public void setStatus(String status) {
        mStatus = status;
    }

    public String getDateModified() {
        return mDateModified;
    }

    public void setDateModified(String dateModified) {
        mDateModified = dateModified;
    }

    public String getViewed() {
        return mViewed;
    }

    public void setViewed(String viewed) {
        mViewed = viewed;
    }

    public String getWeightClass() {
        return mWeightClass;
    }

    public void setWeightClass(String weightClass) {
        mWeightClass = weightClass;
    }

    public String getLenghtClass() {
        return mLenghtClass;
    }

    public void setLenghtClass(String lenghtClass) {
        mLenghtClass = lenghtClass;
    }

    public String getReward() {
        return mReward;
    }

    public void setReward(String reward) {
        mReward = reward;
    }

    public List<Category> getCategories() {
        return mCategories;
    }

    public void setCategories(List<Category> categories) {
        mCategories = categories;
    }

    public Integer getQuantity() {
        return mQuantity;
    }

    public void setQuantity(Integer quantity) {
        mQuantity = quantity;
    }
}
