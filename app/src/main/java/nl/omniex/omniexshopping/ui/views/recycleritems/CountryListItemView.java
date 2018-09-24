package nl.omniex.omniexshopping.ui.views.recycleritems;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import nl.omniex.omniexshopping.R;
import nl.omniex.omniexshopping.data.model.address.Country;
import nl.omniex.omniexshopping.ui.adapters.CountriesAdapter;

@EViewGroup(R.layout.view_country_list_item)
public class CountryListItemView extends LinearLayout {

    @ViewById(R.id.country_item_name)
    TextView mCountryName;

    private CountriesAdapter.OnCountrySelectedListener mOnCountrySelectedListener;
    private Country mCountry;

    public CountryListItemView(Context context) {
        super(context);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        setLayoutParams(layoutParams);
    }

    public CountryListItemView bind(Country country){
        mCountry = country;
        mCountryName.setText(mCountry.getName()+", "+mCountry.getIsoCode());
        return this;
    }

    public void setOnCountrySelectedListener(CountriesAdapter.OnCountrySelectedListener onCountrySelectedListener) {
        mOnCountrySelectedListener = onCountrySelectedListener;
    }

    @Click(R.id.country_item_layout)
    void onCountryClick(){
        mOnCountrySelectedListener.onCountrySelected(mCountry);
    }
}
