package nl.omniex.omniexshopping.data.model.response;

import com.google.gson.annotations.SerializedName;

import nl.omniex.omniexshopping.data.model.auth.AccessToken;

public class AccessTokenResponse {

    @SerializedName("data")
    private AccessToken mAccessToken;

    public AccessToken getAccessToken() {
        return mAccessToken;
    }
}
