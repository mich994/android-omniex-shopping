package nl.omniex.omniexshopping.ui.adapters;

import android.support.annotation.NonNull;
import android.view.ViewGroup;

import org.androidannotations.annotations.EBean;

import nl.omniex.omniexshopping.data.model.address.Address;
import nl.omniex.omniexshopping.ui.base.BaseRecyclerAdapter;
import nl.omniex.omniexshopping.ui.views.recycleritems.OrderAddressItemView;
import nl.omniex.omniexshopping.ui.views.recycleritems.OrderAddressItemView_;

@EBean
public class OrderAddressesAdapter extends BaseRecyclerAdapter<Address, OrderAddressItemView> {

    private int mSelected = -1;

    @Override
    protected OrderAddressItemView onCreateItemView(ViewGroup parent, int viewType) {
        return OrderAddressItemView_.build(parent.getContext());
    }

    @Override
    public void onBindViewHolder(@NonNull ViewWrapper<OrderAddressItemView> holder, int position) {
        holder.getView().bind(getItem(position), position == mSelected).setItemClickListener(getItemClickListener());
    }

    public void setSelected(int selected) {
        mSelected = selected;
        notifyDataSetChanged();
    }

    public void resetSelection(){
        mSelected = -1;
    }
}
