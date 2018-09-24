package nl.omniex.omniexshopping.ui.views.recycleritems;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import nl.omniex.omniexshopping.R;
import nl.omniex.omniexshopping.data.model.products.Product;
import nl.omniex.omniexshopping.ui.base.BaseRecyclerAdapter;
import nl.omniex.omniexshopping.utils.StringUtils;

@EViewGroup(R.layout.view_product_list_item)
public class ProductsListItemView extends FrameLayout {

    @ViewById(R.id.product_list_item_image)
    ImageView mProductImage;

    @ViewById(R.id.product_list_item_name)
    TextView mProductName;

    @ViewById(R.id.product_list_item_price)
    TextView mProductPrice;

    private Product mProduct;
    private BaseRecyclerAdapter.ItemClickListener<Product> mProductItemClickListener;

    public ProductsListItemView(Context context) {
        super(context);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        setLayoutParams(layoutParams);
    }

    public ProductsListItemView bind(Product product) {
        mProduct = product;
        Glide.with(this)
                .load(StringUtils.fixUrl(mProduct.getImageUrl()))
                .into(mProductImage);
        mProductName.setText(mProduct.getName());
        mProductPrice.setText(mProduct.getPriceExcTaxFormated());
        return this;
    }

    public void setProductItemClickListener(BaseRecyclerAdapter.ItemClickListener<Product> productItemClickListener) {
        mProductItemClickListener = productItemClickListener;
    }

    @Click(R.id.product_list_item_fl)
    void onItemClick(){
        mProductItemClickListener.onItemClick(mProduct);
    }

}
