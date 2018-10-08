package nl.omniex.omniexshopping.ui.base;

import com.hannesdorfmann.mosby3.mvp.MvpView;

import nl.omniex.omniexshopping.data.model.cart.Cart;

public interface BaseView extends MvpView {
    default void onCartFetched(Cart cart){}
    default void startLoading(){}
    default void stopLoading(){}
}
