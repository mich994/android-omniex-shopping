package nl.omniex.omniexshopping.ui.adapters;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import nl.omniex.omniexshopping.ui.app.profile.address.ProfileAddressFragment_;
import nl.omniex.omniexshopping.ui.app.profile.order.ProfileOrderFragment_;

public class ProfileViewPagerAdapter extends FragmentStatePagerAdapter {

    public ProfileViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if(position==0)
            return ProfileAddressFragment_.builder().build();
        else
            return ProfileOrderFragment_.builder().build();
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if(position==0)
            return "Addresses";
        else
            return "Orders";
    }
}
