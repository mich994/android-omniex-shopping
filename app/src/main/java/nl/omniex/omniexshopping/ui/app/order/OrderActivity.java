package nl.omniex.omniexshopping.ui.app.order;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;

import nl.omniex.omniexshopping.R;
import nl.omniex.omniexshopping.ui.app.order.shipping.OrderShippingFragment_;
import nl.omniex.omniexshopping.ui.base.BaseActivity;

@EActivity(R.layout.activity_order)
public class OrderActivity extends BaseActivity<OrderView, OrderPresenter> implements OrderView {

    @Override
    protected void onFirstCreate() {
        super.onFirstCreate();
        getCustomToolbar()
                .setIconStart(R.drawable.twotone_arrow_back_black_36)
                .setIconStarClickListener(this::finish);
    }

    @AfterViews
    void initOrderProcess() {
        goToFragment(OrderShippingFragment_.builder().build(), true, "");
    }
}
