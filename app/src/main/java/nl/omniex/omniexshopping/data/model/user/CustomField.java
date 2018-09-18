package nl.omniex.omniexshopping.data.model.user;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CustomField {

    @SerializedName("custom_field_id")
    private String mCustomFieldId;
    @SerializedName("custom_field_value")
    private List<String> mCustomFieldValue;
    @SerializedName("name")
    private String mName;
    @SerializedName("type")
    private String mType;
    @SerializedName("value")
    private String mValue;
    @SerializedName("validation")
    private String mValidation;
    @SerializedName("location")
    private String mLocation;
    @SerializedName("required")
    private Boolean mRequired;
    @SerializedName("sort_order")
    private String mSortOrder;

    public String getCustomFieldId() {
        return mCustomFieldId;
    }

    public void setCustomFieldId(String customFieldId) {
        mCustomFieldId = customFieldId;
    }

    public List<String> getCustomFieldValue() {
        return mCustomFieldValue;
    }

    public void setCustomFieldValue(List<String> customFieldValue) {
        mCustomFieldValue = customFieldValue;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

    public String getValue() {
        return mValue;
    }

    public void setValue(String value) {
        mValue = value;
    }

    public String getValidation() {
        return mValidation;
    }

    public void setValidation(String validation) {
        mValidation = validation;
    }

    public String getLocation() {
        return mLocation;
    }

    public void setLocation(String location) {
        mLocation = location;
    }

    public Boolean getRequired() {
        return mRequired;
    }

    public void setRequired(Boolean required) {
        mRequired = required;
    }

    public String getSortOrder() {
        return mSortOrder;
    }

    public void setSortOrder(String sortOrder) {
        mSortOrder = sortOrder;
    }
}
