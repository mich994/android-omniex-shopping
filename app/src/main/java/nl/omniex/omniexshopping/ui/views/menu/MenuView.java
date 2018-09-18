package nl.omniex.omniexshopping.ui.views.menu;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import nl.omniex.omniexshopping.R;
import nl.omniex.omniexshopping.data.model.MenuItem;

@EViewGroup(R.layout.view_menu_item)
public class MenuView extends LinearLayout {

    @ViewById(R.id.title_menu_item)
    TextView mTitle;

    private int mPosition;

    public MenuView(Context context) {
        super(context);
        ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        setLayoutParams(lp);
    }

    public MenuView bind(MenuItem menuItem) {
        mTitle.setText(menuItem.getTitle());
        return this;
    }

    public MenuView setSelectedBg(boolean isSelected) {
        if (isSelected)
            mTitle.setBackground(getContext().getDrawable(R.drawable.background_menu_item_light));
        else
            mTitle.setBackground(getContext().getDrawable(R.drawable.background_menu_item_dark));

        return this;
    }
}
