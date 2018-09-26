package nl.omniex.omniexshopping.data.model.payment;

import com.google.gson.annotations.SerializedName;

public class PaymentMethodSetter {

    @SerializedName("payment_method")
    private String mCode;
    @SerializedName("agree")
    private String mAgree;
    @SerializedName("comment")
    private String mComment;

    public PaymentMethodSetter(String code, String agree, String comment) {
        mCode = code;
        mAgree = agree;
        mComment = comment;
    }

    public String getCode() {
        return mCode;
    }

    public void setCode(String code) {
        mCode = code;
    }

    public String getAgree() {
        return mAgree;
    }

    public void setAgree(String agree) {
        mAgree = agree;
    }

    public String getComment() {
        return mComment;
    }

    public void setComment(String comment) {
        mComment = comment;
    }
}
