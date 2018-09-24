package nl.omniex.omniexshopping.ui.app.product.list;

import javax.inject.Inject;

import nl.omniex.omniexshopping.data.repository.ProductsRepository;
import nl.omniex.omniexshopping.ui.base.BasePresenter;

public class ProductsListPresenter extends BasePresenter<ProductsListView> {

    private ProductsRepository mProductsRepository;

    @Inject
    ProductsListPresenter(ProductsRepository productsRepository) {
        mProductsRepository = productsRepository;
    }

    void getProductsList(Integer catId) {
        addDisposable(mProductsRepository
                .getProductsByCat(catId)
                .subscribe(
                        productsListResponse -> {
                            if(productsListResponse.isSuccessful() && productsListResponse.code()==200){
                                ifViewAttached(view -> view.onProductsListFetched(productsListResponse.body().getProductList()));
                            }
                        }, Throwable::printStackTrace));
    }
}
