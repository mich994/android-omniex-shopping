package nl.omniex.omniexshopping.data.model.products;

import com.google.gson.annotations.SerializedName;

public class Category {

    @SerializedName("name")
    private String mName;
    @SerializedName("id")
    private Integer mId;

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
}
