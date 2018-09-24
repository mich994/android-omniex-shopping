package nl.omniex.omniexshopping.ui.views.recycleritems;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import nl.omniex.omniexshopping.R;
import nl.omniex.omniexshopping.data.model.address.Address;
import nl.omniex.omniexshopping.ui.adapters.AddressesAdapter;

@EViewGroup(R.layout.view_address_list_item)
public class AddressListItemView extends FrameLayout {

    @ViewById(R.id.address_item_name)
    TextView mAddressName;

    private AddressesAdapter.OnAddressListItemClickListener mOnAddressListItemClickListener;
    private Address mAddress;

    public AddressListItemView(Context context) {
        super(context);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        setLayoutParams(layoutParams);
    }

    public AddressListItemView bind(Address address){
        mAddress=address;
        mAddressName.setText(mAddress.getAddressThumb());
        return this;
    }

    public void setOnAddressListItemClickListener(AddressesAdapter.OnAddressListItemClickListener onAddressListItemClickListener) {
        mOnAddressListItemClickListener = onAddressListItemClickListener;
    }

    @Click({R.id.address_item_edit, R.id.address_item_remove})
    void onClick(View v){
        switch (v.getId()){
            case R.id.address_item_edit:
                mOnAddressListItemClickListener.onEditClick(mAddress);
                break;
            case R.id.address_item_remove:
                mOnAddressListItemClickListener.onRemoveClick(Integer.valueOf(mAddress.getAddressId()));
                break;
        }
    }
}
