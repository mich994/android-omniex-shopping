package nl.omniex.omniexshopping.data.model.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RegisterResponse {

    @SerializedName("success")
    private Integer mSuccess;
    @SerializedName("error")
    private List<String> mErrors;

    public Integer getSuccess() {
        return mSuccess;
    }

    public List<String> getErrors() {
        return mErrors;
    }
}
