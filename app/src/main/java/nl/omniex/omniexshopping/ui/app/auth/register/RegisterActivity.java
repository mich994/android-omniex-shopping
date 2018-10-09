package nl.omniex.omniexshopping.ui.app.auth.register;

import android.app.AlertDialog;
import android.view.View;
import android.widget.EditText;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import nl.omniex.omniexshopping.R;
import nl.omniex.omniexshopping.data.model.auth.register.CustomField;
import nl.omniex.omniexshopping.data.model.auth.register.CustomFieldSetter;
import nl.omniex.omniexshopping.data.model.auth.register.RegisterSetter;
import nl.omniex.omniexshopping.ui.base.BaseActivity;

@EActivity(R.layout.activity_register)
public class RegisterActivity extends BaseActivity<RegisterView, RegisterPresenter> implements RegisterView {

    @ViewById(R.id.register_input_email)
    EditText mEmail;
    @ViewById(R.id.register_input_password)
    EditText mPassword;
    @ViewById(R.id.register_input_confirm_password)
    EditText mConfirmPassword;
    @ViewById(R.id.register_input_company_address)
    EditText mCompanyAddress;
    @ViewById(R.id.register_input_company_name)
    EditText mCompanyName;
    @ViewById(R.id.register_input_first_name)
    EditText mFirstName;
    @ViewById(R.id.register_input_last_name)
    EditText mLastName;
    @ViewById(R.id.register_input_telephone)
    EditText mTelephone;
    @ViewById(R.id.register_input_country)
    EditText mCountry;
    @ViewById(R.id.register_input_city)
    EditText mCity;
    @ViewById(R.id.register_input_post_code)
    EditText mPostCode;
    @ViewById(R.id.register_input_tax)
    EditText mTax;


    private RegisterSetter createRegisterObject() {
        RegisterSetter registerSetter = new RegisterSetter(
                mFirstName.getText().toString(),
                mLastName.getText().toString(),
                mEmail.getText().toString(),
                mPassword.getText().toString(),
                mConfirmPassword.getText().toString(),
                mTelephone.getText().toString(),
                1,
                new CustomField(new CustomFieldSetter(
                        mCompanyAddress.getText().toString(),
                        mCompanyName.getText().toString(),
                        mTax.getText().toString(),
                        mCity.getText().toString(),
                        mCountry.getText().toString())));
        return registerSetter;
    }

    @Click({R.id.register_btn_register, R.id.register_btn_cancel})
    void onClick(View v) {
        if (v.getId() == R.id.register_btn_register) {
                getPresenter().register(createRegisterObject());
        } else {
            finish();
        }
    }

    private void showWarningDialog(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message)
                .setPositiveButton("Ok", ((dialog, which) -> dialog.dismiss()))
                .show();
    }

    @Override
    public void onRegisterSuccess() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Register succeed")
                .setCancelable(false)
                .setMessage("You will receive a confirmation email. Please confirm your registration. After that you will be able to login when we will accept your account.")
                .setPositiveButton("Ok", ((dialog, which) -> {
                    finish();
                    dialog.dismiss();
                }))
                .show();
    }

    @Override
    public void onRegisterFailed(String message) {
        showWarningDialog(message);
    }

    @Override
    public void onConnectionFailed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Please check your connection. If problem still occurs, please let us know by form on omniex.nl")
                .setPositiveButton("Ok", ((dialog, which) -> dialog.dismiss()))
                .show();
    }

    @Override
    protected void onFirstCreate() {
        super.onFirstCreate();
        setToolbar();

    }

    private void setToolbar() {
        getCustomToolbar()
                .setIconStart(R.drawable.twotone_arrow_back_black_36)
                .setIconStarClickListener(this::finish);
    }
}
