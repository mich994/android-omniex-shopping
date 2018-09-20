package nl.omniex.omniexshopping.ui.app.product;

import android.support.v4.view.ViewPager;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.FragmentArg;
import org.androidannotations.annotations.ViewById;

import java.util.List;

import me.relex.circleindicator.CircleIndicator;
import nl.omniex.omniexshopping.R;
import nl.omniex.omniexshopping.data.model.cart.AddToCartModel;
import nl.omniex.omniexshopping.data.model.products.Product;
import nl.omniex.omniexshopping.ui.adapters.DetailsImagePagerAdapter;
import nl.omniex.omniexshopping.ui.base.BaseFragment;

@EFragment(R.layout.fragment_product_details)
public class ProductDetailsFragment extends BaseFragment<ProductDetailsView, ProductDetailsPresenter> implements ProductDetailsView {

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

    @FragmentArg
    Integer mProductId;

    private DetailsImagePagerAdapter mDetailsImagePagerAdapter;
    private int mQuantity = 1;

    @AfterViews
    void initializeDetails() {
        getPresenter().getProductDetails(mProductId);
    }

    private void initViewPager(List<String> imagesUrl){
        mDetailsImagePagerAdapter = new DetailsImagePagerAdapter(getFragmentManager(), imagesUrl);
        mDetailsImagesVp.setAdapter(mDetailsImagePagerAdapter);
        mCircleIndicator.setViewPager(mDetailsImagesVp);
    }

    @Click({R.id.product_details_add_to_cart_btn, R.id.product_details_quantity_add, R.id.product_details_quantity_remove})
    void onClick(View v) {
        switch (v.getId()) {
            case R.id.product_details_add_to_cart_btn:
                getPresenter().addToCart(new AddToCartModel(String.valueOf(mProductId), String.valueOf(mQuantity)));
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
