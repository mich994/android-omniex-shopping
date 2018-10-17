package nl.omniex.omniexshopping.ui.base.menu;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import org.androidannotations.annotations.EBean;

import nl.omniex.omniexshopping.ui.base.BaseActivity;
import nl.omniex.omniexshopping.ui.base.BasePresenter;
import nl.omniex.omniexshopping.ui.base.BaseView;
import nl.psdcompany.duonavigationdrawer.views.DuoDrawerLayout;

@EBean
public abstract class BaseMenuActivity<MenuAdapter extends BaseMenuAdapter, MView extends BaseView, MPresenter extends BasePresenter<MView>> extends BaseActivity<MView, MPresenter> implements MenuHelper.MenuBase<MenuAdapter> {

    protected MenuHelper<MenuAdapter> mMenuHelper;
    protected DuoDrawerLayout mDuoDrawerLayout;
    protected View mOverlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMenuHelper = new MenuHelper<>(this);
    }

    @Override
    protected void onFirstCreate() {
        super.onFirstCreate();
        mOverlay = findViewById(getOverlayRes());
        getSupportFragmentManager().addOnBackStackChangedListener(() -> {
            if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
                mDuoDrawerLayout.setDrawerLockMode(DuoDrawerLayout.LOCK_MODE_LOCKED_CLOSED);
            } else {
                mDuoDrawerLayout.setDrawerLockMode(DuoDrawerLayout.LOCK_MODE_UNLOCKED);
            }
        });
        mMenuHelper.onSetContent();
        mDuoDrawerLayout = mMenuHelper.mMenuViewHolder.mDuoDrawerLayout;
        mDuoDrawerLayout.setDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        });
    }

    @IdRes
    protected abstract int getOverlayRes();

    @Override
    public void onOptionClick(int position, Object option) {
    }

    @Override
    public void closeMenu() {
        mDuoDrawerLayout.closeDrawer();
    }

    @Override
    public void openMenu() {
        mDuoDrawerLayout.openDrawer();
    }

    public BaseMenuActivity getBaseMenuActivity() {
        return this;
    }

    @Override
    public void toggleMenu() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
            getSupportFragmentManager().popBackStack();
        } else {
            if (mDuoDrawerLayout.isDrawerOpen())
                closeMenu();
            else
                openMenu();
        }
    }

    @Override
    public AppCompatActivity getActivity() {
        return this;
    }

}
