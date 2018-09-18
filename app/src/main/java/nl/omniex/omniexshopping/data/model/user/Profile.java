package nl.omniex.omniexshopping.data.model.user;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Profile {

    @SerializedName("customer_id")
    private String mCustomerId;
    @SerializedName("customer_group_id")
    private String mCustomerGroupId;
    @SerializedName("store_id")
    private String mStoreId;
    @SerializedName("language_id")
    private String mLanguageId;
    @SerializedName("firstname")
    private String mFirstName;
    @SerializedName("lastname")
    private String mLastName;
    @SerializedName("email")
    private String mEmail;
    @SerializedName("telephone")
    private String mTelephone;
    @SerializedName("fax")
    private String mFax;
    @SerializedName("newsletter")
    private String mNewsletter;
    @SerializedName("address_id")
    private String mAddressId;
    @SerializedName("ip")
    private String mIp;
    @SerializedName("status")
    private String mStatus;
    @SerializedName("safe")
    private String mSafe;
    @SerializedName("code")
    private String mCode;
    @SerializedName("date_added")
    private String mDateAdded;
    @SerializedName("custom_fields")
    private List<CustomField> mCustomFields;
    @SerializedName("account_custom_field")
    private AccountCustomField mAccountCustomField;
    @SerializedName("wishlist_total")
    private String mWishlistTotal;
    @SerializedName("cart_count_products")
    private Integer mCartCount;

    public String getCustomerId() {
        return mCustomerId;
    }

    public void setCustomerId(String customerId) {
        mCustomerId = customerId;
    }

    public String getCustomerGroupId() {
        return mCustomerGroupId;
    }

    public void setCustomerGroupId(String customerGroupId) {
        mCustomerGroupId = customerGroupId;
    }

    public String getStoreId() {
        return mStoreId;
    }

    public void setStoreId(String storeId) {
        mStoreId = storeId;
    }

    public String getLanguageId() {
        return mLanguageId;
    }

    public void setLanguageId(String languageId) {
        mLanguageId = languageId;
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

    public String getTelephone() {
        return mTelephone;
    }

    public void setTelephone(String telephone) {
        mTelephone = telephone;
    }

    public String getFax() {
        return mFax;
    }

    public void setFax(String fax) {
        mFax = fax;
    }

    public String getNewsletter() {
        return mNewsletter;
    }

    public void setNewsletter(String newsletter) {
        mNewsletter = newsletter;
    }

    public String getAddressId() {
        return mAddressId;
    }

    public void setAddressId(String addressId) {
        mAddressId = addressId;
    }

    public String getIp() {
        return mIp;
    }

    public void setIp(String ip) {
        mIp = ip;
    }

    public String getStatus() {
        return mStatus;
    }

    public void setStatus(String status) {
        mStatus = status;
    }

    public String getSafe() {
        return mSafe;
    }

    public void setSafe(String safe) {
        mSafe = safe;
    }

    public String getCode() {
        return mCode;
    }

    public void setCode(String code) {
        mCode = code;
    }

    public String getDateAdded() {
        return mDateAdded;
    }

    public void setDateAdded(String dateAdded) {
        mDateAdded = dateAdded;
    }

    public List<CustomField> getCustomFields() {
        return mCustomFields;
    }

    public void setCustomFields(List<CustomField> customFields) {
        mCustomFields = customFields;
    }

    public AccountCustomField getAccountCustomField() {
        return mAccountCustomField;
    }

    public void setAccountCustomField(AccountCustomField accountCustomField) {
        mAccountCustomField = accountCustomField;
    }

    public String getWishlistTotal() {
        return mWishlistTotal;
    }

    public void setWishlistTotal(String wishlistTotal) {
        mWishlistTotal = wishlistTotal;
    }

    public Integer getCartCount() {
        return mCartCount;
    }

    public void setCartCount(Integer cartCount) {
        mCartCount = cartCount;
    }
}
