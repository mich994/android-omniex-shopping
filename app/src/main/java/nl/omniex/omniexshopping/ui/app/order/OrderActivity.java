package nl.omniex.omniexshopping.ui.app.order;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;

import nl.omniex.omniexshopping.R;
import nl.omniex.omniexshopping.data.model.address.Address;
import nl.omniex.omniexshopping.data.model.cart.Cart;
import nl.omniex.omniexshopping.data.model.order.OrderOverview;
import nl.omniex.omniexshopping.data.model.shipping.ShippingMethod;
import nl.omniex.omniexshopping.ui.app.order.shipping.OrderShippingFragment_;
import nl.omniex.omniexshopping.ui.base.BaseActivity;

@EActivity(R.layout.activity_order)
public class OrderActivity extends BaseActivity<OrderView, OrderPresenter> implements OrderView {

    private OrderOverview mOrderOverview = new OrderOverview();

    @Extra
    Cart mCart;

    @Override
    protected void onFirstCreate() {
        super.onFirstCreate();
        getCustomToolbar()
                .setIconStart(R.drawable.twotone_arrow_back_black_36)
                .setIconStarClickListener(this::finish);
        mOrderOverview.setCart(mCart);
    }

    @AfterViews
    void initOrderProcess() {
        goToFragment(OrderShippingFragment_.builder().build(), true, "");
    }

    public void setShippingAddress(Address shippingAddress){
        mOrderOverview.setShippingAddress(shippingAddress);
    }

    public void setPaymentAddress(Address paymentAddress){
        mOrderOverview.setPaymentAddress(paymentAddress);
    }

    public void setShippingMethod(ShippingMethod shippingMethod){
        mOrderOverview.setShippingMethod(shippingMethod);
    }

    public void setPaymentMethod(String paymentMethod){
        mOrderOverview.setPaymentMethod(paymentMethod);
    }

    public OrderOverview getOrderOverview() {
        return mOrderOverview;
    }
}
