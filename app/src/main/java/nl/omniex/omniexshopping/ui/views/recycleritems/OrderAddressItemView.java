package nl.omniex.omniexshopping.ui.views.recycleritems;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.view.ViewGroup;
import android.widget.TextView;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import nl.omniex.omniexshopping.R;
import nl.omniex.omniexshopping.data.model.address.Address;
import nl.omniex.omniexshopping.ui.base.BaseRecyclerAdapter;

@EViewGroup(R.layout.view_order_address_item)
public class OrderAddressItemView extends CardView {

    @ViewById(R.id.order_address_cd)
    CardView mOrderAddressCd;

    @ViewById(R.id.order_address_name)
    TextView mName;

    @ViewById(R.id.order_address_company)
    TextView mCompany;

    @ViewById(R.id.order_address_street)
    TextView mStreet;

    @ViewById(R.id.order_address_postcode_city)
    TextView mPostcodeCity;

    private BaseRecyclerAdapter.ItemClickListener<Address> mItemClickListener;
    private Address mAddress;
    private int mPosition;

    public OrderAddressItemView(@NonNull Context context) {
        super(context);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        setLayoutParams(layoutParams);
    }

    public OrderAddressItemView bind(Address address, boolean isSelected) {
        mOrderAddressCd.setRadius(16f);
        mAddress = address;
        mName.setText(mAddress.getFirstName() + " " + mAddress.getLastName());
        mCompany.setText(mAddress.getCompanyName());
        mStreet.setText(mAddress.getAddressOne() + " " + mAddress.getAddressTwo());
        mPostcodeCity.setText(mAddress.getPostcode() + ", " + mAddress.getCity());
        mOrderAddressCd.setBackgroundColor(isSelected ? getResources().getColor(R.color.colorPrimaryLight) : getResources().getColor(R.color.icons));
        return this;
    }

    public void setItemClickListener(BaseRecyclerAdapter.ItemClickListener<Address> itemClickListener) {
        mItemClickListener = itemClickListener;
    }

    @Click(R.id.order_address_cd)
    void onClick(){
        mItemClickListener.onItemClick(mAddress);
    }
}
