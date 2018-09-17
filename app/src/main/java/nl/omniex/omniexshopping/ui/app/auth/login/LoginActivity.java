package nl.omniex.omniexshopping.ui.app.auth.login;

import android.view.View;
import android.widget.EditText;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import nl.omniex.omniexshopping.R;
import nl.omniex.omniexshopping.data.model.auth.Login;
import nl.omniex.omniexshopping.ui.base.BaseActivity;

@EActivity(R.layout.activity_login)
public class LoginActivity extends BaseActivity<LoginView, LoginPresenter> implements LoginView {

    @ViewById(R.id.login_email_input)
    EditText mEmailInput;

    @ViewById(R.id.login_password_input)
    EditText mPasswordInput;

    @AfterViews
    void setTempCredentials(){
      
    }

    @Click({R.id.login_login_btn, R.id.login_exit_btn})
    void onClick(View v){
        switch (v.getId()){
            case R.id.login_login_btn:
                getPresenter().login(new Login(mEmailInput.getText().toString(), mPasswordInput.getText().toString()));
                break;
            case R.id.login_exit_btn:
                break;
        }
    }

    @Override
    public void onLoginSuccess() {

    }
}
