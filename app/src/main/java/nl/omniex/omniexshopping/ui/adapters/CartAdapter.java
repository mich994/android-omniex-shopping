package nl.omniex.omniexshopping.ui.adapters;

import android.support.annotation.NonNull;
import android.view.ViewGroup;

import org.androidannotations.annotations.EBean;

import nl.omniex.omniexshopping.data.model.cart.CartItemDelete;
import nl.omniex.omniexshopping.data.model.cart.CartProduct;
import nl.omniex.omniexshopping.ui.base.BaseRecyclerAdapter;
import nl.omniex.omniexshopping.ui.views.recycleritems.CartItemView;
import nl.omniex.omniexshopping.ui.views.recycleritems.CartItemView_;

@EBean
public class CartAdapter extends BaseRecyclerAdapter<CartProduct, CartItemView> {

    private OnCartItemClickListener mOnCartItemClickListener;
    private boolean mIsFromOverview;

    @Override
    protected CartItemView onCreateItemView(ViewGroup parent, int viewType) {
        return CartItemView_.build(parent.getContext());
    }

    @Override
    public void onBindViewHolder(@NonNull ViewWrapper<CartItemView> holder, int position) {
        holder.getView()
                .bind(getItem(position), position, mIsFromOverview)
                .setOnCartItemClickListener(mOnCartItemClickListener);
    }

    public void setFromOverview(boolean fromOverview) {
        mIsFromOverview = fromOverview;
    }

    public void setOnCartItemClickListener(OnCartItemClickListener onCartItemClickListener) {
        mOnCartItemClickListener = onCartItemClickListener;
    }

    public interface OnCartItemClickListener{
        void onUpdateItemQuantity(String productKey, int quantity);
        void onRemoveItem(CartItemDelete cartItemDelete);
    }

}
