package nl.omniex.omniexshopping.ui.views.recycleritems;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import nl.omniex.omniexshopping.R;
import nl.omniex.omniexshopping.data.model.cart.CartItemDelete;
import nl.omniex.omniexshopping.data.model.cart.CartProduct;
import nl.omniex.omniexshopping.ui.adapters.CartAdapter;
import nl.omniex.omniexshopping.utils.StringUtils;

@EViewGroup(R.layout.view_cart_item)
public class CartItemView extends LinearLayout {

    @ViewById(R.id.cart_item_image)
    ImageView mCartImage;

    @ViewById(R.id.cart_item_name)
    TextView mItemName;

    @ViewById(R.id.cart_item_price_per_one)
    TextView mPricePerOne;

    @ViewById(R.id.cart_item_quantity_count)
    TextView mQuantityCount;

    @ViewById(R.id.cart_item_total_price)
    TextView mTotalPrice;

    @ViewById(R.id.cart_item_delete)
    ImageView mDeleteItem;

    @ViewById(R.id.cart_item_quantity_add)
    ImageView mQuantityAddIv;

    @ViewById(R.id.cart_item_quantity_remove)
    ImageView mQuantityRemoveIv;

    private CartAdapter.OnCartItemClickListener mOnCartItemClickListener;
    private CartProduct mCartProduct;
    private int mQuantity;
    private boolean mIsQuantityChanging;
    private int mPosition;

    public CartItemView(Context context) {
        super(context);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        setLayoutParams(layoutParams);
    }

    public CartItemView bind(CartProduct cartProduct, int position, boolean isFromOverview) {
        mCartProduct = cartProduct;
        mPosition = position;
        mQuantity = Integer.valueOf(cartProduct.getQuantity());
        mItemName.setText(mCartProduct.getName());
        mPricePerOne.setText("Per one: " + mCartProduct.getPrice());
        mQuantityCount.setText(String.valueOf(mQuantity));
        mTotalPrice.setText("Total price: " + mCartProduct.getTotalPrice());
        Glide.with(this)
                .load(StringUtils.fixUrl(mCartProduct.getThumb()))
                .into(mCartImage);
        if(isFromOverview){
            mQuantityAddIv.setVisibility(GONE);
            mQuantityRemoveIv.setVisibility(GONE);
            mDeleteItem.setVisibility(GONE);
        }

        return this;
    }

    public void setOnCartItemClickListener(CartAdapter.OnCartItemClickListener onCartItemClickListener) {
        mOnCartItemClickListener = onCartItemClickListener;
    }

    @Click({R.id.cart_item_quantity_add, R.id.cart_item_quantity_remove,R.id.cart_item_delete})
    void onClick(View v) {
        switch (v.getId()) {
            case R.id.cart_item_quantity_add:
                handleQuantity(true);
                break;
            case R.id.cart_item_quantity_remove:
                handleQuantity(false);
                break;
            case R.id.cart_item_delete:
                mOnCartItemClickListener.onRemoveItem(new CartItemDelete(Integer.valueOf(mCartProduct.getKey())));
                break;
        }
    }

    private void handleQuantity(boolean increase) {
        if (!increase && mQuantity - 1 > 0) {
            mQuantity -= 1;
            mQuantityCount.setText(String.valueOf(mQuantity));
            mOnCartItemClickListener.onUpdateItemQuantity(mCartProduct.getKey(), mQuantity);
        } else if (increase) {
            mQuantity += 1;
            mQuantityCount.setText(String.valueOf(mQuantity));
            mOnCartItemClickListener.onUpdateItemQuantity(mCartProduct.getKey(), mQuantity);
        }
    }
}
