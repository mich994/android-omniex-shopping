package nl.omniex.omniexshopping.ui.views.recycleritems;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import nl.omniex.omniexshopping.R;
import nl.omniex.omniexshopping.data.model.address.Province;
import nl.omniex.omniexshopping.ui.adapters.ZonesAdapter;

@EViewGroup(R.layout.view_zone_list_item)
public class ZoneListItemView extends LinearLayout {

    @ViewById(R.id.zone_item_name)
    TextView mZoneName;

    private ZonesAdapter.OnZoneSelectedClickListener mOnZoneSelectedClickListener;
    private Province mProvince;

    public ZoneListItemView(Context context) {
        super(context);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        setLayoutParams(layoutParams);
    }

    public ZoneListItemView bind(Province province) {
        mProvince = province;
        mZoneName.setText(province.getFullName());
        return this;
    }

    public void setOnZoneSelectedClickListener(ZonesAdapter.OnZoneSelectedClickListener onZoneSelectedClickListener) {
        mOnZoneSelectedClickListener = onZoneSelectedClickListener;
    }

    @Click(R.id.zone_item_layout)
    void onCountryClick() {
        mOnZoneSelectedClickListener.onZoneSelected(mProvince);
    }
}