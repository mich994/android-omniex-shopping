package nl.omniex.omniexshopping.ui.app.auth.register;

import org.androidannotations.annotations.EActivity;

import nl.omniex.omniexshopping.R;
import nl.omniex.omniexshopping.ui.base.BaseActivity;

@EActivity(R.layout.activity_register)
public class RegisterActivity extends BaseActivity<RegisterView, RegisterPresenter> implements RegisterView {

    @Override
    protected void onFirstCreate() {
        super.onFirstCreate();
        setToolbar();

    }

    private void setToolbar(){
        getCustomToolbar()
                .setIconStart(R.drawable.twotone_arrow_back_black_36)
                .setIconStarClickListener(this::finish);
    }
}
