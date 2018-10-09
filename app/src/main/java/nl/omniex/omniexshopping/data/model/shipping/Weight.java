package nl.omniex.omniexshopping.data.model.shipping;

import com.google.gson.annotations.SerializedName;

public class Weight {

    @SerializedName("title")
    private String mTitle;

    @SerializedName("quote")
    private Quote mQuote;

    public String getTitle() {
        return mTitle;
    }

    public Quote getQuote() {
        return mQuote;
    }
}
