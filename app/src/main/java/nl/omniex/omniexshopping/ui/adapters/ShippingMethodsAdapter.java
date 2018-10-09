package nl.omniex.omniexshopping.ui.adapters;

import android.support.annotation.NonNull;
import android.view.ViewGroup;

import org.androidannotations.annotations.EBean;

import nl.omniex.omniexshopping.data.model.shipping.ShippingMethod;
import nl.omniex.omniexshopping.ui.base.BaseRecyclerAdapter;
import nl.omniex.omniexshopping.ui.views.recycleritems.ShippingMethodItemView;
import nl.omniex.omniexshopping.ui.views.recycleritems.ShippingMethodItemView_;

@EBean
public class ShippingMethodsAdapter extends BaseRecyclerAdapter<ShippingMethod, ShippingMethodItemView> {

    private int mSeleceted = -1;

    @Override
    protected ShippingMethodItemView onCreateItemView(ViewGroup parent, int viewType) {
        return ShippingMethodItemView_.build(parent.getContext());
    }

    @Override
    public void onBindViewHolder(@NonNull ViewWrapper<ShippingMethodItemView> holder, int position) {
        holder.getView().bind(getItem(position)).setItemClickListener(getItemClickListener()).setSelected(mSeleceted==position);
    }

    public void setSelection(int position){
        mSeleceted = position;
        notifyDataSetChanged();
    }

    public void resetSelection(){
        mSeleceted = -1;
    }
}
