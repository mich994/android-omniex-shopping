package nl.omniex.omniexshopping.ui.app.auth.register;

import nl.omniex.omniexshopping.ui.base.BaseView;

public interface RegisterView extends BaseView {

    void onRegisterSuccess();
    void onRegisterFailed(String message);
    void onConnectionFailed();
}
