package nl.omniex.omniexshopping.ui.app.product;

import java.util.Objects;

import javax.inject.Inject;

import nl.omniex.omniexshopping.data.repository.ProductsRepository;
import nl.omniex.omniexshopping.ui.base.BasePresenter;
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
                                ifViewAttached(view -> view.onDetailsFetched(Objects.requireNonNull(productResponse.body()).getProduct()));
                            }
                        },
                        error -> {
                            error.printStackTrace();
                            Timber.e(error);
                        }));
    }
}
