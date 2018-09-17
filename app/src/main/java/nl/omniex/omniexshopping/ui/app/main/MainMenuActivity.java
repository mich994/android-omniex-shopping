package nl.omniex.omniexshopping.ui.app.main;

import org.androidannotations.annotations.EActivity;

import java.util.ArrayList;
import java.util.List;

import nl.omniex.omniexshopping.R;
import nl.omniex.omniexshopping.data.model.MenuItem;
import nl.omniex.omniexshopping.ui.base.menu.BaseMenuActivity;
import nl.omniex.omniexshopping.ui.base.menu.MenuAdapter;

@EActivity
public class MainMenuActivity extends BaseMenuActivity<MenuAdapter, MainMenuView, MainMenuPresenter> implements MainMenuView {

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
        return new MenuAdapter(menuItems);
    }

    public void setToolbar() {

    }

}
