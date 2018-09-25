package nl.omniex.omniexshopping.ui.app.order.shipping.method;

import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import nl.omniex.omniexshopping.R;
import nl.omniex.omniexshopping.ui.base.BaseFragment;

@EFragment(R.layout.fragment_order_shipping)
public class OrderShippingMethodFragment extends BaseFragment<OrderShippingMethodView, OrderShippingMethodPresenter> implements OrderShippingMethodView {

    @ViewById(R.id.order_shipping_rv)
    RecyclerView mShippingAddressRv;

    @ViewById(R.id.order_shipping_empty_tv)
    TextView mEmptyListTv;

    @ViewById(R.id.order_shipping_next_btn)
    Button mNextBtn;

    @AfterViews
    void test(){
        getPresenter().getShippingMethods();
    }
}
