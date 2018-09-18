package nl.omniex.omniexshopping.ui.app.auth.login;

import javax.inject.Inject;

import nl.omniex.omniexshopping.data.model.auth.Login;
import nl.omniex.omniexshopping.data.repository.ProductsRepository;
import nl.omniex.omniexshopping.data.repository.ProfileRepository;
import nl.omniex.omniexshopping.ui.base.BasePresenter;
import timber.log.Timber;

public class LoginPresenter extends BasePresenter<LoginView> {

    private ProfileRepository mProfileRepository;
    private ProductsRepository mProductsRepository;

    @Inject
    LoginPresenter(ProfileRepository profileRepository, ProductsRepository productsRepository) {
        mProfileRepository = profileRepository;
        mProductsRepository = productsRepository;
    }

    void login(Login login) {
        addDisposable(mProfileRepository
                .login(login)
                .subscribe(voidResponse -> {
                    ifViewAttached(view -> view.onLoginSuccess());
                }, error -> {
                    error.printStackTrace();
                    Timber.e(error);
                }));
    }

    void logout(){
        addDisposable(mProfileRepository
        .logout()
        .subscribe(voidResponse -> {}, Throwable::printStackTrace));
    }
    void getAddressList(){
        addDisposable(mProfileRepository
                .getAddressList()
                .subscribe(voidResponse -> {}, Throwable::printStackTrace));
    }

    void getListOfFeatured(){
        addDisposable(mProductsRepository
        .getListOfFeatured()
        .subscribe(voidResponse -> {}, Throwable::printStackTrace));
    }

    void getProducts(){
        addDisposable(mProductsRepository
                .getProducts()
                .subscribe(voidResponse -> {}, Throwable::printStackTrace));
    }

    void getProductsByCat(){
        addDisposable(mProductsRepository
                .getProductsByCat()
                .subscribe(voidResponse -> {}, Throwable::printStackTrace));
    }

    void getProductDetails(){
        addDisposable(mProductsRepository
                .getProductDetails()
                .subscribe(voidResponse -> {}, Throwable::printStackTrace));
    }


    void getCategories(){
        addDisposable(mProductsRepository
                .getCategories()
                .subscribe(voidResponse -> {}, Throwable::printStackTrace));
    }

}
