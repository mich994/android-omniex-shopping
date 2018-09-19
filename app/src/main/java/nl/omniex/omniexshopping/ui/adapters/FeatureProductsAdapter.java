package nl.omniex.omniexshopping.ui.adapters;

import android.support.annotation.NonNull;
import android.view.ViewGroup;

import org.androidannotations.annotations.EBean;

import nl.omniex.omniexshopping.data.model.products.FeaturedProduct;
import nl.omniex.omniexshopping.ui.base.BaseRecyclerAdapter;
import nl.omniex.omniexshopping.ui.views.recycleritems.ProductListItemView;
import nl.omniex.omniexshopping.ui.views.recycleritems.ProductListItemView_;

@EBean
public class FeatureProductsAdapter extends BaseRecyclerAdapter<FeaturedProduct, ProductListItemView> {

    @Override
    protected ProductListItemView onCreateItemView(ViewGroup parent, int viewType) {
        return ProductListItemView_.build(parent.getContext());
    }

    @Override
    public void onBindViewHolder(@NonNull ViewWrapper<ProductListItemView> holder, int position) {
        holder.getView()
                .bind(getItem(position))
                .setProductItemClickListener(getItemClickListener());
    }
}
