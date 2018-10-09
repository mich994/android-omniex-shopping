package nl.omniex.omniexshopping.ui.views.recycleritems;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import nl.omniex.omniexshopping.R;
import nl.omniex.omniexshopping.data.model.order.OrderStatus;
import nl.omniex.omniexshopping.utils.StringUtils;

@EViewGroup(R.layout.view_order_status_item)
public class OrderStatusItemView extends LinearLayout {

    @ViewById(R.id.order_status_name)
    TextView mName;
    @ViewById(R.id.order_status_date)
    TextView mDate;
    @ViewById(R.id.order_status_price)
    TextView mPrice;
    @ViewById(R.id.order_status_tv)
    TextView mOrderStatusTv;

    private OrderStatus mOrderStatus;

    public OrderStatusItemView(Context context) {
        super(context);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        setLayoutParams(layoutParams);
    }

    public OrderStatusItemView bind(OrderStatus orderStatus){
        mOrderStatus = orderStatus;
        mName.setText(mOrderStatus.getName());
        mDate.setText(StringUtils.fixUrl(mOrderStatus.getDateAdded()));
        mPrice.setText(mOrderStatus.getProducts()+" item/s - "+mOrderStatus.getTotalPrice());
        mOrderStatusTv.setText(mOrderStatus.getStatus());
        return this;
    }


}
