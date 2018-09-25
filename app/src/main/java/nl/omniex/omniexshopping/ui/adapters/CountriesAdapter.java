package nl.omniex.omniexshopping.ui.adapters;

import android.support.annotation.NonNull;
import android.view.ViewGroup;

import org.androidannotations.annotations.EBean;

import nl.omniex.omniexshopping.data.model.address.Country;
import nl.omniex.omniexshopping.ui.base.BaseRecyclerAdapter;
import nl.omniex.omniexshopping.ui.views.recycleritems.CountryListItemView;
import nl.omniex.omniexshopping.ui.views.recycleritems.CountryListItemView_;

@EBean
public class CountriesAdapter extends BaseRecyclerAdapter<Country, CountryListItemView> {

    private OnCountrySelectedListener mOnCountrySelectedListener;

    @Override
    protected CountryListItemView onCreateItemView(ViewGroup parent, int viewType) {
        return CountryListItemView_.build(parent.getContext());
    }

    @Override
    public void onBindViewHolder(@NonNull ViewWrapper<CountryListItemView> holder, int position) {
        holder.getView().bind(getItem(position)).setOnCountrySelectedListener(mOnCountrySelectedListener);
    }

    public void setOnCountrySelectedListener(OnCountrySelectedListener onCountrySelectedListener) {
        mOnCountrySelectedListener = onCountrySelectedListener;
    }

    public interface OnCountrySelectedListener{
        void onCountrySelected(Country country);
    }
}
