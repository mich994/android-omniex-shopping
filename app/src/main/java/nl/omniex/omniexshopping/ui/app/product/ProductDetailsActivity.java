package nl.omniex.omniexshopping.ui.app.product;

import android.support.v4.view.ViewPager;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;

import java.util.List;

import me.relex.circleindicator.CircleIndicator;
import nl.omniex.omniexshopping.R;
import nl.omniex.omniexshopping.data.model.products.Product;
import nl.omniex.omniexshopping.ui.adapters.DetailsImagePagerAdapter;
import nl.omniex.omniexshopping.ui.base.BaseActivity;

@EActivity(R.layout.activity_product_details)
public class ProductDetailsActivity extends BaseActivity<ProductDetailsView, ProductDetailsPresenter> implements ProductDetailsView {

    @ViewById(R.id.product_details_images_vp)
    ViewPager mDetailsImagesVp;

    @ViewById(R.id.product_details_images_indicator)
    CircleIndicator mCircleIndicator;

    @ViewById(R.id.product_details_price_tv)
    TextView mPriceTv;

    @ViewById(R.id.product_details_quantity_count)
    TextView mQuantityCountTv;

    @ViewById(R.id.product_details_description_tv)
    TextView mDescriptionTv;

    @Extra
    Integer mProductId;

    private DetailsImagePagerAdapter mDetailsImagePagerAdapter;
    private int mQuantity = 1;

    @Override
    protected void onFirstCreate() {
        super.onFirstCreate();
        getCustomToolbar()
                .setIconStart(R.drawable.twotone_arrow_back_black_36)
                .setIconEnd(R.drawable.twotone_shopping_cart_black_36)
                .setIconStarClickListener(this::finish)
                .setIconEndClickListener(()->{});
    }

    @AfterViews
    void initializeDetails() {
        getPresenter().getProductDetails(mProductId);
    }

    private void initViewPager(List<String> imagesUrl){
        mDetailsImagePagerAdapter = new DetailsImagePagerAdapter(getSupportFragmentManager(), imagesUrl);
        mDetailsImagesVp.setAdapter(mDetailsImagePagerAdapter);
        mCircleIndicator.setViewPager(mDetailsImagesVp);
    }

    @Click({R.id.product_details_add_to_cart_btn, R.id.product_details_quantity_add, R.id.product_details_quantity_remove})
    void onClick(View v) {
        switch (v.getId()) {
            case R.id.product_details_add_to_cart_btn:
                break;
            case R.id.product_details_quantity_add:
                handleQuantity(true);
                break;
            case R.id.product_details_quantity_remove:
                handleQuantity(false);
                break;
        }
    }

    private void handleQuantity(boolean increase) {
        if (!increase && mQuantity - 1 > 0) {
            mQuantity -= 1;
            mQuantityCountTv.setText(String.valueOf(mQuantity));
        } else if (increase) {
            mQuantity += 1;
            mQuantityCountTv.setText(String.valueOf(mQuantity));
        }
    }

    @Override
    public void onDetailsFetched(Product product) {
        initViewPager(product.getImageUrlsList());
        mPriceTv.setText(product.getPriceExcTaxFormated());
        mDescriptionTv.setText(Html.fromHtml(product.getDescription()));

    }
}
