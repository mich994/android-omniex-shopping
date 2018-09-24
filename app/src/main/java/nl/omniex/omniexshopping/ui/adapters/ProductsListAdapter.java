package nl.omniex.omniexshopping.ui.adapters;

import android.support.annotation.NonNull;
import android.view.ViewGroup;

import org.androidannotations.annotations.EBean;

import nl.omniex.omniexshopping.data.model.products.Product;
import nl.omniex.omniexshopping.ui.base.BaseRecyclerAdapter;
import nl.omniex.omniexshopping.ui.views.recycleritems.ProductsListItemView;
import nl.omniex.omniexshopping.ui.views.recycleritems.ProductsListItemView_;

@EBean
public class ProductsListAdapter extends BaseRecyclerAdapter<Product, ProductsListItemView> {

    @Override
    protected ProductsListItemView onCreateItemView(ViewGroup parent, int viewType) {
        return ProductsListItemView_.build(parent.getContext());
    }

    @Override
    public void onBindViewHolder(@NonNull ViewWrapper<ProductsListItemView> holder, int position) {
        holder.getView().bind(getItem(position)).setProductItemClickListener(getItemClickListener());
    }
}
