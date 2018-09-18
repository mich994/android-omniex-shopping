package nl.omniex.omniexshopping.data.model.auth;

import com.google.gson.annotations.SerializedName;

public class AccessToken {

    @SerializedName("access_token")
    private String mToken;
    @SerializedName("expires_in")
    private Long mExpiresIn;
    @SerializedName("token_type")
    private String mType;

    public String getAccessToken(){
        return getType()+" "+getToken();
    }

    public String getToken() {
        return mToken;
    }

    public void setToken(String token) {
        mToken = token;
    }

    public Long getExpiresIn() {
        return mExpiresIn;
    }

    public void setExpiresIn(Long expiresIn) {
        mExpiresIn = expiresIn;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }
}
