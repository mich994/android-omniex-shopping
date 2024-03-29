package nl.omniex.omniexshopping.ui.views.recycleritems;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import nl.omniex.omniexshopping.R;
import nl.omniex.omniexshopping.data.model.products.FeaturedProduct;
import nl.omniex.omniexshopping.ui.base.BaseRecyclerAdapter;
import nl.omniex.omniexshopping.utils.StringUtils;

@EViewGroup(R.layout.view_featured_product_list_item)
public class FeaturedProductListItemView extends LinearLayout {

    @ViewById(R.id.featured_product_list_item_image)
    ImageView mProductImage;

    @ViewById(R.id.featured_product_list_item_name)
    TextView mProductName;

    @ViewById(R.id.featured_product_list_item_price)
    TextView mProductPrice;

    private FeaturedProduct mFeaturedProduct;
    private BaseRecyclerAdapter.ItemClickListener<FeaturedProduct> mProductItemClickListener;

    public FeaturedProductListItemView(Context context) {
        super(context);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        setLayoutParams(layoutParams);
    }

    public FeaturedProductListItemView bind(FeaturedProduct featuredProduct) {
        mFeaturedProduct = featuredProduct;
        Glide.with(this)
                .load(StringUtils.fixUrl(featuredProduct.getThumb()))
                .into(mProductImage);
        mProductName.setText(mFeaturedProduct.getName());
        mProductPrice.setText(mFeaturedProduct.getPriceExcludingTaxFormatted());
        return this;
    }

    public void setProductItemClickListener(BaseRecyclerAdapter.ItemClickListener<FeaturedProduct> productItemClickListener) {
        mProductItemClickListener = productItemClickListener;
    }

    @Click(R.id.product_list_item_fl)
    void onItemClick(){
        mProductItemClickListener.onItemClick(mFeaturedProduct);
    }
}
