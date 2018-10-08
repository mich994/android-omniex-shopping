package nl.omniex.omniexshopping.ui.adapters;

import android.support.annotation.NonNull;
import android.view.ViewGroup;

import org.androidannotations.annotations.EBean;

import nl.omniex.omniexshopping.data.model.order.OrderStatus;
import nl.omniex.omniexshopping.ui.base.BaseRecyclerAdapter;
import nl.omniex.omniexshopping.ui.views.recycleritems.OrderStatusItemView;
import nl.omniex.omniexshopping.ui.views.recycleritems.OrderStatusItemView_;

@EBean
public class OrderStatutesAdapter extends BaseRecyclerAdapter<OrderStatus, OrderStatusItemView> {

    @Override
    protected OrderStatusItemView onCreateItemView(ViewGroup parent, int viewType) {
        return OrderStatusItemView_.build(parent.getContext());
    }

    @Override
    public void onBindViewHolder(@NonNull ViewWrapper<OrderStatusItemView> holder, int position) {
        holder.getView().bind(getItem(position));
    }
}
