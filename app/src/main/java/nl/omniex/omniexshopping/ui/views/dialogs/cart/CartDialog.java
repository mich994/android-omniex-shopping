package nl.omniex.omniexshopping.ui.views.dialogs.cart;

import android.support.v4.app.DialogFragment;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.FragmentArg;
import org.androidannotations.annotations.ViewById;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;
import nl.omniex.omniexshopping.R;
import nl.omniex.omniexshopping.data.model.cart.Cart;
import nl.omniex.omniexshopping.ui.adapters.CartAdapter;

@EFragment(R.layout.fragment_cart)
public class CartDialog extends DialogFragment implements CartAdapter.OnCartItemClickListener {

    @ViewById(R.id.cart_dialog_items_rv)
    RecyclerView mCartItemsRv;

    @ViewById(R.id.cart_dialog_total_price)
    TextView mTotalPrice;

    @Inject
    CartAdapter mCartAdapter;

    @FragmentArg
    Cart mCart;

    private OnUpdateItemQuantityListener mOnUpdateItemQuantityListener;

    @Override
    public void onResume() {
        super.onResume();
        ViewGroup.LayoutParams params = getDialog().getWindow().getAttributes();
        params.width = ViewGroup.LayoutParams.MATCH_PARENT;
        params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        getDialog().getWindow().setAttributes((android.view.WindowManager.LayoutParams) params);
    }

    @AfterViews
    void setViews() {
        setCancelable(false);
        mCartAdapter.setOnCartItemClickListener(this);
        mCartItemsRv.setAdapter(mCartAdapter);
        mTotalPrice.setText(mCart.getTotal());
        mCartAdapter.setItems(mCart.getCartProducts());
    }

    @AfterInject
    protected void afterInject(){
        try {
            AndroidSupportInjection.inject(this);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    @Click({R.id.cart_dialog_continue_btn, R.id.cart_dialog_make_order_btn})
    void onClick(View v) {
        switch (v.getId()) {
            case R.id.cart_dialog_continue_btn:
                dismiss();
                break;
            case R.id.cart_dialog_make_order_btn:
                break;
        }
    }

    public CartDialog setOnUpdateItemQuantityListener(OnUpdateItemQuantityListener onUpdateItemQuantityListener) {
        mOnUpdateItemQuantityListener = onUpdateItemQuantityListener;
        return this;
    }

    @Override
    public void onUpdateItemQuantity(int productId, int quantity) {

    }

    public interface OnUpdateItemQuantityListener {
        void onUpdateQuantity(int productId, int quantity);
    }
}
