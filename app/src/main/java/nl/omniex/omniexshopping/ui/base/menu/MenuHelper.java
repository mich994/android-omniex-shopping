package nl.omniex.omniexshopping.ui.base.menu;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import nl.omniex.omniexshopping.R;
import nl.psdcompany.duonavigationdrawer.views.DuoDrawerLayout;
import nl.psdcompany.duonavigationdrawer.views.DuoMenuView;
import nl.psdcompany.duonavigationdrawer.widgets.DuoDrawerToggle;

public class MenuHelper<MenuAdapter extends BaseMenuAdapter> implements DuoMenuView.OnMenuClickListener {

    protected MenuViewHolder mMenuViewHolder;
    private MenuAdapter mMenuAdapter;
    private MenuBase<MenuAdapter> mMenuBase;

    public MenuHelper(MenuBase<MenuAdapter> menuBase){
        mMenuBase = menuBase;
    }

    public void onSetContent(){
        mMenuViewHolder = new MenuViewHolder(mMenuBase.getActivity());
        mMenuBase.getActivity().setSupportActionBar(mMenuViewHolder.mToolbar);
        initializeMenu();
    }

    private void initializeMenu(){
        mMenuAdapter = mMenuBase.createAdapter();
        mMenuViewHolder.mDuoMenuView.setOnMenuClickListener(this);
        mMenuViewHolder.mDuoMenuView.setAdapter(mMenuAdapter);
        initializeDrawer();

        int defaultIndex = mMenuBase.getStartIndex();
        if(defaultIndex != -1){
            onOptionClicked(mMenuBase.getStartIndex(), mMenuAdapter.getName(mMenuBase.getActivity(), mMenuAdapter.getItem(defaultIndex)));
        }
    }

    private void initializeDrawer(){
        DuoDrawerToggle duoDrawerToggle = new DuoDrawerToggle(mMenuBase.getActivity(), mMenuViewHolder.mDuoDrawerLayout, mMenuViewHolder.mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mMenuViewHolder.mDuoDrawerLayout.setDrawerListener(duoDrawerToggle);
        duoDrawerToggle.syncState();
    }

    @Override
    public void onFooterClicked() {

    }

    @Override
    public void onHeaderClicked() {

    }

    @Override
    public void onOptionClicked(int position, Object objectClicked) {
        mMenuBase.getActivity().setTitle(mMenuAdapter.getName(mMenuBase.getActivity(), mMenuAdapter.getItem(position)));
        mMenuAdapter.setSelected(position);
        mMenuBase.onOptionClicked(position, objectClicked);
        mMenuViewHolder.mDuoDrawerLayout.closeDrawer();
    }

    public class MenuViewHolder {
        DuoMenuView mDuoMenuView;
        Toolbar mToolbar;
        public DuoDrawerLayout mDuoDrawerLayout;

        MenuViewHolder(Activity activity) {
            mDuoDrawerLayout = activity.findViewById(mMenuBase.getDuoDrawerLayout());
            mDuoMenuView = (DuoMenuView) mDuoDrawerLayout.getMenuView();
            mToolbar =activity.findViewById(mMenuBase.getToolbarId());
        }
    }

    public interface MenuBase<MenuAdapter extends BaseMenuAdapter> extends DuoMenuView.OnMenuClickListener{

        void onOptionClick(int position, Object option);
        int getToolbarId();
        int getDuoDrawerLayout();
        int getStartIndex();
        void closeMenu();
        void openMenu();
        void toggleMenu();
        AppCompatActivity getActivity();
        MenuAdapter createAdapter();


        @Override
        default void onFooterClicked() {

        }

        @Override
        default void onHeaderClicked() {

        }

        @Override
        default void onOptionClicked(int position, Object objectClicked) {

        }
    }

}
