package nl.omniex.omniexshopping.ui.app.main;

import nl.omniex.omniexshopping.ui.base.BaseView;

public interface MainMenuView extends BaseView {
    void onLogoutSuccess();
    void onCartItemQuantityUpdated();
}
