package nl.omniex.omniexshopping.ui.app.main;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;

import java.util.ArrayList;
import java.util.List;

import nl.omniex.omniexshopping.R;
import nl.omniex.omniexshopping.data.model.MenuItem;
import nl.omniex.omniexshopping.ui.app.main.home.HomeFragment_;
import nl.omniex.omniexshopping.ui.base.menu.BaseMenuActivity;
import nl.omniex.omniexshopping.ui.base.menu.MenuAdapter;

@EActivity(R.layout.activity_main_menu)
public class MainMenuActivity extends BaseMenuActivity<MenuAdapter, MainMenuView, MainMenuPresenter> implements MainMenuView {

    @AfterViews
    void initHomeFragment(){
        goToFragment(HomeFragment_.builder().build(), false, "");
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
                    showToastMessage(menuItem.getTitle(), 0);
                    break;
                case 1:
                    showToastMessage(menuItem.getTitle(), 0);
                    break;
                case 2:
                    showToastMessage(menuItem.getTitle(), 0);
                    break;
                case 3:
                    showToastMessage(menuItem.getTitle(), 0);
                    break;
                case 4:
                    showToastMessage(menuItem.getTitle(), 0);
                    break;
            }
        }
    }

    @Override
    public MenuAdapter createAdapter() {
        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("Profile"));
        menuItems.add(new MenuItem("Categories"));
        menuItems.add(new MenuItem("History"));
        menuItems.add(new MenuItem("Newsletter"));

        return new MenuAdapter(menuItems);
    }

    private void setToolbar() {
        getCustomToolbar().setIconStarClickListener(this::toggleMenu);
    }

}
