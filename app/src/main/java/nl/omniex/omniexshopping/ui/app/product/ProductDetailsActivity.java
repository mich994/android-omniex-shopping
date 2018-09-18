package nl.omniex.omniexshopping.ui.app.product;

import android.support.v7.widget.RecyclerView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;

import java.util.List;

import javax.inject.Inject;

import cz.intik.overflowindicator.OverflowPagerIndicator;
import cz.intik.overflowindicator.SimpleSnapHelper;
import nl.omniex.omniexshopping.R;
import nl.omniex.omniexshopping.ui.adapters.ProductDetailsImageAdapter;
import nl.omniex.omniexshopping.ui.base.BaseActivity;

@EActivity(R.layout.activity_product_details)
public class ProductDetailsActivity extends BaseActivity<ProductDetailsView, ProductDetailsPresenter> implements ProductDetailsView, ProductDetailsImageAdapter.OnDetailsImageClickListener {

    @ViewById(R.id.product_details_images_rv)
    RecyclerView mDetailsImagesRv;

    @ViewById(R.id.product_details_image_indicator)
    OverflowPagerIndicator mPagerIndicator;

    @Inject
    ProductDetailsImageAdapter mProductDetailsImageAdapter;

    @Extra
    Integer mProductId;

    @AfterViews
    void initImagesRecycler(){
        mProductDetailsImageAdapter.setDetailsImageClickListener(this);
        mDetailsImagesRv.setAdapter(mProductDetailsImageAdapter);

        getPresenter().getProductDetails(mProductId);
    }

    @Override
    public void onDetailsFetched(List<String> imageUrlsList) {
        mProductDetailsImageAdapter.setItems(imageUrlsList);
        SimpleSnapHelper simpleSnapHelper = new SimpleSnapHelper(mPagerIndicator);
        simpleSnapHelper.attachToRecyclerView(mDetailsImagesRv);
    }

    @Override
    public void onImageClick(int position) {

    }
}
