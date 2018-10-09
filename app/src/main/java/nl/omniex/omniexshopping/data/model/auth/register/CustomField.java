package nl.omniex.omniexshopping.data.model.auth.register;

import com.google.gson.annotations.SerializedName;

public class CustomField {

    @SerializedName("account")
    private CustomFieldSetter mCustomFieldSetter;

    public CustomField(CustomFieldSetter customFieldSetter) {
        mCustomFieldSetter = customFieldSetter;
    }
}
