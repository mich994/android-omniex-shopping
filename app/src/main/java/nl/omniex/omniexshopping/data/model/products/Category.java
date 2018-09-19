package nl.omniex.omniexshopping.data.model.products;

import com.google.gson.annotations.SerializedName;

public class Category {

    @SerializedName("name")
    private String mName;
    @SerializedName("id")
    private Integer mId;
    @SerializedName("category_id")
    private Integer mCategoryId;
    @SerializedName("image")
    private String mImageUrl;

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public Integer getId() {
        return mId;
    }

    public void setId(Integer id) {
        mId = id;
    }

    public Integer getCategoryId() {
        return mCategoryId;
    }

    public void setCategoryId(Integer categoryId) {
        mCategoryId = categoryId;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        mImageUrl = imageUrl;
    }
}
