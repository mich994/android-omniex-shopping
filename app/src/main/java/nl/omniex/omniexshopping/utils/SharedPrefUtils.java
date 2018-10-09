package nl.omniex.omniexshopping.utils;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Inject;

import nl.omniex.omniexshopping.di.base.Application;

public class SharedPrefUtils {

    private static final String ACCESS_TOKEN_KEY = "ACCESS_TOKEN";
    private static final String OLD_TOKEN_KEY = "OLD_TOKEN";
    private static final String IS_USER_LOGGED_KEY = "IS_USER_LOGGED";
    private static final String IS_USER_GUEST = "IS_USER_GUEST";
    private static final String NEWSLETTER_STATUS_KEY = "IS_SUBSCRIBED";
    private static final String TAX_KEY = "TAX";

    private Context mContext;

    @Inject
    SharedPrefUtils(Context context) {
        mContext = context;
    }

    private static SharedPreferences getSharedPref() {
        return Application.getInstance().getSharedPreferences("nl.omniex.omniexshopping", Context.MODE_PRIVATE);
    }

    public void saveAccessToken(String token) {
        getSharedPref()
                .edit()
                .putString(ACCESS_TOKEN_KEY, token)
                .apply();
    }

    public String getAccessToken() {
        return getSharedPref()
                .getString(ACCESS_TOKEN_KEY, "");
    }

    public void saveOldToken(String oldToken) {
        getSharedPref()
                .edit()
                .putString(OLD_TOKEN_KEY, oldToken)
                .apply();
    }

    public String getOldToken() {
        return getSharedPref()
                .getString(OLD_TOKEN_KEY, "");
    }

    public static void setUserLogged(boolean isLogged) {
        getSharedPref()
                .edit()
                .putBoolean(IS_USER_LOGGED_KEY, isLogged)
                .apply();
    }

    public static boolean isUserLogged() {
        return getSharedPref()
                .getBoolean(IS_USER_LOGGED_KEY, false);
    }

    public static void setUserGuest(boolean isGuest) {
        getSharedPref()
                .edit()
                .putBoolean(IS_USER_GUEST, isGuest)
                .apply();
    }

    public static boolean isUserQuest() {
        return getSharedPref()
                .getBoolean(IS_USER_GUEST, false);
    }

    public static void setNewsletterStatus(boolean isSubscribed){
        getSharedPref()
                .edit()
                .putBoolean(NEWSLETTER_STATUS_KEY, isSubscribed)
                .apply();
    }

    public static boolean isNewsletterSubscribed(){
        return getSharedPref()
                .getBoolean(NEWSLETTER_STATUS_KEY, false);
    }

    public static void setTaxValue(Integer tax) {
        getSharedPref()
                .edit()
                .putInt(TAX_KEY, tax)
                .apply();
    }

    public static Integer getTaxValue() {
        return getSharedPref()
                .getInt(TAX_KEY, 1);
    }
}
