package nl.omniex.omniexshopping.ui.app.auth;

import android.support.v7.app.AppCompatActivity;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;

import nl.omniex.omniexshopping.R;
import nl.omniex.omniexshopping.ui.app.auth.login.LoginActivity_;
import nl.omniex.omniexshopping.ui.app.auth.register.RegisterActivity_;

@EActivity(R.layout.activity_start)
public class StartActivity extends AppCompatActivity {

    @Click(R.id.start_login_btn)
    void onLoginClick(){
        LoginActivity_.intent(this).start();
    }

    @Click(R.id.start_register_btn)
    void onRegisterClick(){
        RegisterActivity_.intent(this).start();
    }
}
