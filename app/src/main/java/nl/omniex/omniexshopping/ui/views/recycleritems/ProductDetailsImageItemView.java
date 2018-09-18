package nl.omniex.omniexshopping.ui.views.recycleritems;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import nl.omniex.omniexshopping.R;
import nl.omniex.omniexshopping.ui.adapters.ProductDetailsImageAdapter;

@EViewGroup(R.layout.view_details_image_item)
public class ProductDetailsImageItemView extends LinearLayout {

    @ViewById(R.id.details_item_image)
    ImageView mDetailsImage;

    private String mImageUrl;
    private ProductDetailsImageAdapter.OnDetailsImageClickListener mDetailsImageClickListener;
    private int mPosition;

    public ProductDetailsImageItemView(Context context) {
        super(context);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        setLayoutParams(layoutParams);
    }

    public ProductDetailsImageItemView bind(String imageUrl, int position){
        mImageUrl = imageUrl;
        mPosition = position;
        Glide.with(this).load(mImageUrl).into(mDetailsImage);
        return this;
    }

    public void setDetailsImageClickListener(ProductDetailsImageAdapter.OnDetailsImageClickListener detailsImageClickListener) {
        mDetailsImageClickListener = detailsImageClickListener;
    }

    @Click(R.id.details_item_image)
    void onImageClick(){
        mDetailsImageClickListener.onImageClick(mPosition);
    }
}
