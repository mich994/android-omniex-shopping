package nl.omniex.omniexshopping.ui.views.recycleritems;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.view.ViewGroup;
import android.widget.TextView;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import nl.omniex.omniexshopping.R;

@EViewGroup(R.layout.view_shipping_method_item)
public class ShippingMethodItemView extends CardView {

    @ViewById(R.id.shipping_method_title)
    TextView mTitle;

    @ViewById(R.id.shipping_method_subtitle)
    TextView mSubtitle;

    @ViewById(R.id.shipping_method_price)
    TextView mPrice;

    public ShippingMethodItemView(@NonNull Context context) {
        super(context);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        setLayoutParams(layoutParams);
    }
}
