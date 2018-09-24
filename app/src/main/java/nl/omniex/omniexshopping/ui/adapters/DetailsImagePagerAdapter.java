package nl.omniex.omniexshopping.ui.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

import nl.omniex.omniexshopping.ui.views.fragments.DetailsImageFragment_;

public class DetailsImagePagerAdapter extends FragmentStatePagerAdapter {

    private List<String> mImageUrls;

    public DetailsImagePagerAdapter(FragmentManager fm, List<String> imageUrls) {
        super(fm);
        mImageUrls = imageUrls;
    }

    public void setImageUrls(List<String> imageUrls) {
        mImageUrls = imageUrls;
        notifyDataSetChanged();
    }

    @Override
    public Fragment getItem(int position) {
        return DetailsImageFragment_.builder().mImageUrl(mImageUrls.get(position)).build();
    }

    @Override
    public int getCount() {
        return mImageUrls.size();
    }
}
