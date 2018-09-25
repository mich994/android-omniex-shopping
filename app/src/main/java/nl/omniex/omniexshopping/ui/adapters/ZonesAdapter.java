package nl.omniex.omniexshopping.ui.adapters;

import android.support.annotation.NonNull;
import android.view.ViewGroup;

import org.androidannotations.annotations.EBean;

import nl.omniex.omniexshopping.data.model.address.Province;
import nl.omniex.omniexshopping.ui.base.BaseRecyclerAdapter;
import nl.omniex.omniexshopping.ui.views.recycleritems.ZoneListItemView;
import nl.omniex.omniexshopping.ui.views.recycleritems.ZoneListItemView_;

@EBean
public class ZonesAdapter extends BaseRecyclerAdapter<Province, ZoneListItemView> {

    private OnZoneSelectedClickListener mOnZoneSelectedClickListener;

    @Override
    protected ZoneListItemView onCreateItemView(ViewGroup parent, int viewType) {
        return ZoneListItemView_.build(parent.getContext());
    }

    @Override
    public void onBindViewHolder(@NonNull ViewWrapper<ZoneListItemView> holder, int position) {
        holder.getView().bind(getItem(position)).setOnZoneSelectedClickListener(mOnZoneSelectedClickListener);
    }

    public void setOnZoneSelectedClickListener(OnZoneSelectedClickListener onZoneSelectedClickListener) {
        mOnZoneSelectedClickListener = onZoneSelectedClickListener;
    }

    public interface OnZoneSelectedClickListener{
        void onZoneSelected(Province province);
    }
}
