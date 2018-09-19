package nl.omniex.omniexshopping.ui.app.main.home;

import javax.inject.Inject;

import nl.omniex.omniexshopping.data.repository.ProductsRepository;
import nl.omniex.omniexshopping.ui.base.BasePresenter;

public class HomePresenter extends BasePresenter<HomeView> {

    private ProductsRepository mProductsRepository;

    @Inject
    HomePresenter(ProductsRepository productsRepository) {
        mProductsRepository = productsRepository;
    }

    void getListOfFeatured() {
        addDisposable(mProductsRepository
                .getListOfFeatured()
                .subscribe(featureProductsResponse -> {
                    if (featureProductsResponse.isSuccessful() && featureProductsResponse.code() == 200) {
                        ifViewAttached(
                                view -> view
                                        .onFeaturedProductsFetched(featureProductsResponse
                                                .body()
                                                .getProductWrappers()
                                                .get(0)
                                                .getFeaturedProducts()));
                    }
                }, Throwable::printStackTrace));
    }
}
