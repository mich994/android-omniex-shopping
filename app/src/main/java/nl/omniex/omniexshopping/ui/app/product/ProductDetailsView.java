package nl.omniex.omniexshopping.ui.app.product;

import java.util.List;

import nl.omniex.omniexshopping.ui.base.BaseView;

public interface ProductDetailsView extends BaseView {
    void onDetailsFetched(List<String> imageUrlsList);
}
