package nl.omniex.omniexshopping.data.model.auth;

import com.google.gson.annotations.SerializedName;

public class OldToken {

    @SerializedName("old_token")
    private String mOldToken;

    public OldToken(String oldToken) {
        mOldToken = oldToken;
    }

    public String getOldToken() {
        return mOldToken;
    }

    public void setOldToken(String oldToken) {
        mOldToken = oldToken;
    }
}
