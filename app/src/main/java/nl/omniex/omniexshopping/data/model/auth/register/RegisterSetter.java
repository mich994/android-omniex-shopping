package nl.omniex.omniexshopping.data.model.auth.register;

import com.google.gson.annotations.SerializedName;

public class RegisterSetter {

    @SerializedName("firstname")
    private String mFirstName;
    @SerializedName("lastname")
    private String mLastName;
    @SerializedName("email")
    private String mEmail;
    @SerializedName("password")
    private String mPassword;
    @SerializedName("confirm")
    private String mConfirm;
    @SerializedName("telephone")
    private String mTelephone;
    @SerializedName("agree")
    private Integer mAgree;
    @SerializedName("custom_field")
    private CustomField mCustomField;

    public RegisterSetter(String firstName, String lastName, String email, String password, String confirm, String telephone, Integer agree, CustomField customField) {
        mFirstName = firstName;
        mLastName = lastName;
        mEmail = email;
        mPassword = password;
        mConfirm = confirm;
        mTelephone = telephone;
        mAgree = agree;
        mCustomField = customField;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String firstName) {
        mFirstName = firstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public void setLastName(String lastName) {
        mLastName = lastName;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) {
        mPassword = password;
    }

    public String getConfirm() {
        return mConfirm;
    }

    public void setConfirm(String confirm) {
        mConfirm = confirm;
    }

    public String getTelephone() {
        return mTelephone;
    }

    public void setTelephone(String telephone) {
        mTelephone = telephone;
    }

    public Integer getAgree() {
        return mAgree;
    }

    public void setAgree(Integer agree) {
        mAgree = agree;
    }

    public CustomField getCustomField() {
        return mCustomField;
    }

    public void setCustomField(CustomField customField) {
        mCustomField = customField;
    }
}
