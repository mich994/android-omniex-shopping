package nl.omniex.omniexshopping.ui.adapters;

import android.support.annotation.NonNull;
import android.view.ViewGroup;

import org.androidannotations.annotations.EBean;

import nl.omniex.omniexshopping.ui.base.BaseRecyclerAdapter;
import nl.omniex.omniexshopping.ui.views.recycleritems.ProductDetailsImageItemView;
import nl.omniex.omniexshopping.ui.views.recycleritems.ProductDetailsImageItemView_;

@EBean
public class ProductDetailsImageAdapter extends BaseRecyclerAdapter<String, ProductDetailsImageItemView> {

    private OnDetailsImageClickListener mDetailsImageClickListener;

    @Override
    protected ProductDetailsImageItemView onCreateItemView(ViewGroup parent, int viewType) {
        return ProductDetailsImageItemView_.build(parent.getContext());
    }

    @Override
    public void onBindViewHolder(@NonNull ViewWrapper<ProductDetailsImageItemView> holder, int position) {
        holder.getView()
                .bind(getItem(position), position)
                .setDetailsImageClickListener(mDetailsImageClickListener);
    }

    public void setDetailsImageClickListener(OnDetailsImageClickListener detailsImageClickListener) {
        mDetailsImageClickListener = detailsImageClickListener;
    }

    public interface OnDetailsImageClickListener {
        void onImageClick(int position);
    }
}
