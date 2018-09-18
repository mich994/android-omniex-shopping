package nl.omniex.omniexshopping.data.model.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import nl.omniex.omniexshopping.data.model.user.Profile;

public class LoginResponse {

    @SerializedName("success")
    private Integer mSuccess;
    @SerializedName("error")
    private List<String> mError;
    @SerializedName("data")
    private Profile mProfile;

    public Integer getSuccess() {
        return mSuccess;
    }

    public void setSuccess(Integer success) {
        mSuccess = success;
    }

    public List<String> getError() {
        return mError;
    }

    public void setError(List<String> error) {
        mError = error;
    }

    public Profile getProfile() {
        return mProfile;
    }

    public void setProfile(Profile profile) {
        mProfile = profile;
    }
}
