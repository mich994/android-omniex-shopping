package nl.omniex.omniexshopping.ui.views.recycleritems;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import nl.omniex.omniexshopping.R;
import nl.omniex.omniexshopping.data.model.products.Category;
import nl.omniex.omniexshopping.ui.base.BaseRecyclerAdapter;
import nl.omniex.omniexshopping.utils.StringUtils;

@EViewGroup(R.layout.view_category_item)
public class CategoryItemView extends FrameLayout {

    @ViewById(R.id.category_item_image)
    ImageView mCategoryImage;

    @ViewById(R.id.category_item_name)
    TextView mCategoryName;

    private BaseRecyclerAdapter.ItemClickListener<Category> mItemClickListener;
    private Category mCategory;

    public CategoryItemView(@NonNull Context context) {
        super(context);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        setLayoutParams(layoutParams);
    }

    public CategoryItemView bind(Category category) {
        mCategory = category;
        mCategoryName.setText(mCategory.getName());
        Glide.with(this).load(StringUtils.fixUrl(mCategory.getImageUrl())).into(mCategoryImage);
        return this;
    }

    public void setItemClickListener(BaseRecyclerAdapter.ItemClickListener<Category> itemClickListener) {
        mItemClickListener = itemClickListener;
    }

    @Click(R.id.category_item_name)
    void onClick(){
        mItemClickListener.onItemClick(mCategory);
    }
}
