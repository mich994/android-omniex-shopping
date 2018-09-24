package nl.omniex.omniexshopping.ui.adapters;

import android.support.annotation.NonNull;
import android.view.ViewGroup;

import org.androidannotations.annotations.EBean;

import nl.omniex.omniexshopping.data.model.products.Category;
import nl.omniex.omniexshopping.ui.base.BaseRecyclerAdapter;
import nl.omniex.omniexshopping.ui.views.recycleritems.CategoryItemView;
import nl.omniex.omniexshopping.ui.views.recycleritems.CategoryItemView_;

@EBean
public class CategoriesAdapter extends BaseRecyclerAdapter<Category, CategoryItemView> {

    @Override
    protected CategoryItemView onCreateItemView(ViewGroup parent, int viewType) {
        return CategoryItemView_.build(parent.getContext());
    }

    @Override
    public void onBindViewHolder(@NonNull ViewWrapper<CategoryItemView> holder, int position) {
        holder.getView()
                .bind(getItem(position))
                .setItemClickListener(getItemClickListener());
    }
}
