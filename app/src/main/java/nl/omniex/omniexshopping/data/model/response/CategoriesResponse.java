package nl.omniex.omniexshopping.data.model.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import nl.omniex.omniexshopping.data.model.products.Category;

public class CategoriesResponse {

    @SerializedName("data")
    private List<Category> mCategoryList;

    public List<Category> getCategoryList() {
        return mCategoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        mCategoryList = categoryList;
    }
}
