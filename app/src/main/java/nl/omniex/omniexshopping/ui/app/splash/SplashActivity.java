package nl.omniex.omniexshopping.ui.app.splash;

import android.os.Handler;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;

import nl.omniex.omniexshopping.R;
import nl.omniex.omniexshopping.ui.app.auth.StartActivity_;
import nl.omniex.omniexshopping.ui.app.auth.login.LoginActivity_;
import nl.omniex.omniexshopping.ui.base.BaseActivity;

@EActivity(R.layout.activity_splash)
public class SplashActivity extends BaseActivity<SplashView, SplashPresenter> implements SplashView {

    @AfterViews
    void getAccessToken() {
        new Handler().postDelayed(() -> {
//            getPresenter().getAccessToken();
            finish();
            StartActivity_.intent(this).start();
        }, 1000L);

    }

    @Override
    public void onTokenFetched() {
        finish();
        LoginActivity_.intent(this).start();
    }
}
