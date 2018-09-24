package nl.omniex.omniexshopping.ui.app.categories;

import javax.inject.Inject;

import nl.omniex.omniexshopping.data.repository.ProductsRepository;
import nl.omniex.omniexshopping.ui.base.BasePresenter;

public class CategoriesPresenter extends BasePresenter<CategoriesView> {

    private ProductsRepository mProductsRepository;

    @Inject
    CategoriesPresenter(ProductsRepository productsRepository) {
        mProductsRepository = productsRepository;
    }

    void getCategories() {
        addDisposable(mProductsRepository
                .getCategories()
                .subscribe(
                        categoriesResponse -> {
                            if(categoriesResponse.isSuccessful() && categoriesResponse.code()==200){
                                ifViewAttached(view -> view.onCategoriesFetched(categoriesResponse.body().getCategoryList()));
                            }
                        }, Throwable::printStackTrace));
    }

}
