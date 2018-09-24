package nl.omniex.omniexshopping.ui.app.main;

import android.widget.ImageView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

import nl.omniex.omniexshopping.R;
import nl.omniex.omniexshopping.data.model.MenuItem;
import nl.omniex.omniexshopping.data.model.cart.Cart;
import nl.omniex.omniexshopping.ui.app.auth.StartActivity_;
import nl.omniex.omniexshopping.ui.app.categories.CategoriesFragment_;
import nl.omniex.omniexshopping.ui.app.main.home.HomeFragment_;
import nl.omniex.omniexshopping.ui.base.menu.BaseMenuActivity;
import nl.omniex.omniexshopping.ui.base.menu.MenuAdapter;
import nl.omniex.omniexshopping.ui.views.dialogs.cart.CartDialog;
import nl.omniex.omniexshopping.ui.views.dialogs.cart.CartDialog_;

@EActivity(R.layout.activity_main_menu)
public class MainMenuActivity extends BaseMenuActivity<MenuAdapter, MainMenuView, MainMenuPresenter> implements MainMenuView, CartDialog.OnUpdateItemQuantityListener {

    @ViewById(R.id.duo_view_menu_background)
    ImageView mDuoDrawerLayout;

    @AfterViews
    void initHomeFragment() {
        mDuoDrawerLayout.setBackgroundResource(R.color.colorPrimaryDark);
        goToFragment(HomeFragment_.builder().build(), true, "");
    }

    @Override
    protected void onFirstCreate() {
        super.onFirstCreate();
        setToolbar();
    }

    @Override
    protected int getOverlayRes() {
        return R.id.menu_overlay;
    }

    @Override
    public int getToolbarId() {
        return 0;
    }

    @Override
    public int getDuoDrawerLayout() {
        return R.id.home_drawer;
    }

    @Override
    public int getStartIndex() {
        return 0;
    }

    @Override
    public void onOptionClicked(int position, Object objectClicked) {
        if (objectClicked != null) {
            MenuItem menuItem = (MenuItem) objectClicked;
            switch (position) {
                case 0:
                    goToFragment(HomeFragment_.builder().build(), true, "");
                    break;
                case 1:
                    showToastMessage(menuItem.getTitle(), 0);
                    break;
                case 2:
                    goToFragment(CategoriesFragment_.builder().build(), true, "");
                    break;
                case 3:
                    showToastMessage(menuItem.getTitle(), 0);
                    break;
                case 4:
                    showToastMessage(menuItem.getTitle(), 0);
                    break;
                case 8:
                    getPresenter().logout();
                    break;
            }
        }
    }

    @Override
    public MenuAdapter createAdapter() {
        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("Featured Products"));
        menuItems.add(new MenuItem("Bestsellers"));
        menuItems.add(new MenuItem("Products"));
        menuItems.add(new MenuItem("Profile Details"));
        menuItems.add(new MenuItem("Order History"));
        menuItems.add(new MenuItem("Shipping Methods"));
        menuItems.add(new MenuItem("Newsletter"));
        menuItems.add(new MenuItem("About Omniex"));
        menuItems.add(new MenuItem("Logout"));

        return new MenuAdapter(menuItems);
    }

    @Override
    public void onBackPressed() {
        toggleMenu();
    }

    private void setToolbar() {
        getCustomToolbar()
                .setIconEnd(R.drawable.twotone_shopping_cart_black_36)
                .setIconEndClickListener(() -> getPresenter().getCart());
    }

    @Override
    public void onCartFetched(Cart cart) {
        CartDialog_.builder().mCart(cart).build().setOnUpdateItemQuantityListener(this).show(getSupportFragmentManager(), "dialog");
    }

    @Override
    public void onUpdateQuantity(int productId, int quantity) {

    }

    @Override
    public void onLogoutSuccess() {
        finishAffinity();
        StartActivity_.intent(this).start();
    }

}
