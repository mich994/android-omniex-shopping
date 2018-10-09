package nl.omniex.omniexshopping.ui.views.recycleritems;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.view.ViewGroup;
import android.widget.TextView;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import nl.omniex.omniexshopping.R;
import nl.omniex.omniexshopping.data.model.shipping.ShippingMethod;
import nl.omniex.omniexshopping.ui.base.BaseRecyclerAdapter;

@EViewGroup(R.layout.view_shipping_method_item)
public class ShippingMethodItemView extends CardView {

    @ViewById(R.id.shipping_method_cd)
    CardView mShippingMethodCd;

    @ViewById(R.id.shipping_method_title)
    TextView mTitle;

    @ViewById(R.id.shipping_method_subtitle)
    TextView mSubtitle;

    @ViewById(R.id.shipping_method_price)
    TextView mPrice;

    private BaseRecyclerAdapter.ItemClickListener<ShippingMethod> mItemClickListener;
    private ShippingMethod mShippingMethod;

    public ShippingMethodItemView(@NonNull Context context) {
        super(context);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        setLayoutParams(layoutParams);
    }

    public ShippingMethodItemView bind(ShippingMethod shippingMethod) {
        mShippingMethod = shippingMethod;
        mTitle.setText(mShippingMethod.getWeight().getTitle());
        mSubtitle.setText(mShippingMethod.getWeight().getQuote().getWeightCode().getTitle());
        mPrice.setText(mShippingMethod.getWeight().getQuote().getWeightCode().getPriceText());
        mShippingMethodCd.setOnClickListener(v->mItemClickListener.onItemClick(mShippingMethod));
        return this;
    }

    public ShippingMethodItemView setItemClickListener(BaseRecyclerAdapter.ItemClickListener<ShippingMethod> itemClickListener) {
        mItemClickListener = itemClickListener;
        return this;
    }

    public void setSelected(boolean isSelected) {
        mShippingMethodCd.setCardBackgroundColor(isSelected ? getResources().getColor(R.color.colorPrimaryLight) : getResources().getColor(R.color.icons));
    }
}
