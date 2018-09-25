package nl.omniex.omniexshopping.ui.adapters;

import android.support.annotation.NonNull;
import android.view.ViewGroup;

import org.androidannotations.annotations.EBean;

import nl.omniex.omniexshopping.data.model.address.Address;
import nl.omniex.omniexshopping.ui.base.BaseRecyclerAdapter;
import nl.omniex.omniexshopping.ui.views.recycleritems.AddressListItemView;
import nl.omniex.omniexshopping.ui.views.recycleritems.AddressListItemView_;

@EBean
public class AddressesAdapter extends BaseRecyclerAdapter<Address, AddressListItemView> {

    private OnAddressListItemClickListener mOnAddressListItemClickListener;

    @Override
    protected AddressListItemView onCreateItemView(ViewGroup parent, int viewType) {
        return AddressListItemView_.build(parent.getContext());
    }

    @Override
    public void onBindViewHolder(@NonNull ViewWrapper<AddressListItemView> holder, int position) {
        holder.getView().bind(getItem(position)).setOnAddressListItemClickListener(mOnAddressListItemClickListener);
    }

    public void setOnAddressListItemClickListener(OnAddressListItemClickListener onAddressListItemClickListener) {
        mOnAddressListItemClickListener = onAddressListItemClickListener;
    }

    public interface OnAddressListItemClickListener{
        void onEditClick(Address address);
        void onRemoveClick(Integer idToRemove);
    }
}
