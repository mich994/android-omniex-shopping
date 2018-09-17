package nl.omniex.omniexshopping.ui.base.menu;

import android.content.Context;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseMenuAdapter<Model, Row extends View> extends BaseAdapter {

    private List<Model> mMenuOptions = new ArrayList<>();

    private SparseBooleanArray mBooleanArray;

    protected BaseMenuAdapter(List<Model> menuOptions) {
        resetMenuOptions(menuOptions);
    }

    public void setItems(List<Model> menuOptions) {
        resetMenuOptions(menuOptions);
        notifyDataSetChanged();
    }

    public void setSelected(int position) {
        for (int i = 0; i < mBooleanArray.size(); i++) {
            int key = mBooleanArray.keyAt(i);
            mBooleanArray.put(key, key == position);
        }
        notifyDataSetChanged();
    }

    private void resetMenuOptions(List<Model> menuOptions) {
        mMenuOptions = menuOptions;
        mBooleanArray = new SparseBooleanArray();
        for (int i = 0; i < getCount(); i++)
            mBooleanArray.put(i, false);
    }

    @Override
    public int getCount() {
        return mMenuOptions.size();
    }

    @Override
    public Model getItem(int position) {
        return mMenuOptions.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Model menuOption = mMenuOptions.get(position);
        Row menuOptionView;
        if (convertView == null) {
            menuOptionView = createRowView(menuOption, parent.getContext(), position);
        } else {
            menuOptionView = (Row)convertView;
        }
        return menuOptionView;
    }

    protected abstract Row createRowView(Model model, Context context, int position);

    public abstract String getName(Context context, Model model);

}
