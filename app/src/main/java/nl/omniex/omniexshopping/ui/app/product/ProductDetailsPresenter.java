package nl.omniex.omniexshopping.ui.app.product;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import nl.omniex.omniexshopping.data.repository.ProductsRepository;
import nl.omniex.omniexshopping.ui.base.BasePresenter;
import nl.omniex.omniexshopping.utils.StringUtils;
import timber.log.Timber;

public class ProductDetailsPresenter extends BasePresenter<ProductDetailsView> {

    private ProductsRepository mProductsRepository;

    @Inject
    ProductDetailsPresenter(ProductsRepository productsRepository) {
        mProductsRepository = productsRepository;
    }

    void getProductDetails(Integer id) {
        addDisposable(mProductsRepository
                .getProductDetails(id)
                .subscribe(
                        productResponse -> {
                            if (productResponse.isSuccessful() && productResponse.code() == 200) {
                                ifViewAttached(view -> view.onDetailsFetched(fixImageUrl(productResponse.body().getProduct().getImageUrlsList())));
                            }
                        },
                        error -> {
                            error.printStackTrace();
                            Timber.e(error);
                        }));
    }

    private List<String> fixImageUrl(List<String> imageUrls) {
        List<String> fixedImageUrls = new ArrayList<>();
        for (String url : imageUrls) {
            fixedImageUrls.add(StringUtils.cleanUrl(url));
        }
        return fixedImageUrls;
    }
}
