package nl.omniex.omniexshopping.ui.adapters;

import android.support.annotation.NonNull;
import android.view.ViewGroup;

import org.androidannotations.annotations.EBean;

import nl.omniex.omniexshopping.data.model.products.FeaturedProduct;
import nl.omniex.omniexshopping.ui.base.BaseRecyclerAdapter;
import nl.omniex.omniexshopping.ui.views.recycleritems.FeaturedProductListItemView;
import nl.omniex.omniexshopping.ui.views.recycleritems.FeaturedProductListItemView_;

@EBean
public class FeatureProductsAdapter extends BaseRecyclerAdapter<FeaturedProduct, FeaturedProductListItemView> {

    @Override
    protected FeaturedProductListItemView onCreateItemView(ViewGroup parent, int viewType) {
        return FeaturedProductListItemView_.build(parent.getContext());
    }

    @Override
    public void onBindViewHolder(@NonNull ViewWrapper<FeaturedProductListItemView> holder, int position) {
        holder.getView()
                .bind(getItem(position))
                .setProductItemClickListener(getItemClickListener());
    }
}
