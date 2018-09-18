package nl.omniex.omniexshopping.utils;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Inject;

import nl.omniex.omniexshopping.di.base.Application;

public class SharedPrefUtils {

    private static final String ACCESS_TOKEN_KEY = "ACCESS_TOKEN";
    private static final String OLD_TOKEN_KEY = "OLD_TOKEN";

    private Context mContext;

    @Inject
    SharedPrefUtils(Context context){
        mContext = context;
    }

    private static SharedPreferences getSharedPref(){
        return Application.getInstance().getSharedPreferences("nl.omniex.omniexshopping", Context.MODE_PRIVATE);
    }

    public void saveAccessToken(String token){
        getSharedPref()
                .edit()
                .putString(ACCESS_TOKEN_KEY, token)
                .apply();
    }

    public String getAccessToken(){
        return getSharedPref()
                .getString(ACCESS_TOKEN_KEY, "");
    }

    public void saveOldToken(String oldToken){
        getSharedPref()
                .edit()
                .putString(OLD_TOKEN_KEY, oldToken)
                .apply();
    }

    public String getOldToken(){
        return getSharedPref()
                .getString(OLD_TOKEN_KEY, "");
    }
}
