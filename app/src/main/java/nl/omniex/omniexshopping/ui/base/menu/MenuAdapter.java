package nl.omniex.omniexshopping.ui.base.menu;

import android.content.Context;

import java.util.List;

import nl.omniex.omniexshopping.data.model.MenuItem;
import nl.omniex.omniexshopping.ui.views.menu.MenuView;
import nl.omniex.omniexshopping.ui.views.menu.MenuView_;

public class MenuAdapter extends BaseMenuAdapter<MenuItem, MenuView> {

    public MenuAdapter(List<MenuItem> menuItems){
        super(menuItems);
    }

    @Override
    protected MenuView createRowView(MenuItem menuItem, Context context, int position) {
        return MenuView_.build(context).bind(menuItem);
    }

    @Override
    public String getName(Context context, MenuItem menuItem) {
        return null;
    }
}
