package nl.omniex.omniexshopping.ui.app.main;

import javax.inject.Inject;

import nl.omniex.omniexshopping.data.repository.CartRepository;
import nl.omniex.omniexshopping.data.repository.OrderRepository;
import nl.omniex.omniexshopping.data.repository.ProfileRepository;
import nl.omniex.omniexshopping.ui.base.BasePresenter;
import nl.omniex.omniexshopping.utils.SharedPrefUtils;

public class MainMenuPresenter extends BasePresenter<MainMenuView> {

    private ProfileRepository mProfileRepository;
    private CartRepository mCartRepository;
    private OrderRepository mOrderRepository;

    @Inject
    MainMenuPresenter(ProfileRepository profileRepository, CartRepository cartRepository, OrderRepository orderRepository) {
        mProfileRepository = profileRepository;
        mCartRepository = cartRepository;
        mOrderRepository = orderRepository;
    }

    void logout() {
        addDisposable(mProfileRepository
                .logout()
                .subscribe(
                        voidResponse -> {
                            if (voidResponse.code() == 200) {
                                SharedPrefUtils.setUserLogged(false);
                                ifViewAttached(MainMenuView::onLogoutSuccess);
                            }
                        }, Throwable::printStackTrace));
    }

    void getCart() {
        addDisposable(mCartRepository
                .getCart()
                .subscribe(
                        cartResponse ->
                        {
                            ifViewAttached(view -> view.onCartFetched(cartResponse.body().getCart()));
                        },
                        error -> {
                            error.printStackTrace();
                        }));
    }

    void testOrder() {
        addDisposable(mOrderRepository
                .simpleConfirm()
                .subscribe(voidResponse -> {
                }, Throwable::printStackTrace));
    }

    void testEmptyCart(){
        addDisposable(mCartRepository
        .emptyCart()
        .subscribe(voidResponse -> {}, Throwable::printStackTrace));
    }
}
