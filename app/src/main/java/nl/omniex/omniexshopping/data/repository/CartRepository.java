package nl.omniex.omniexshopping.data.repository;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import nl.omniex.omniexshopping.data.api.OmniexApi;
import nl.omniex.omniexshopping.data.model.cart.AddToCartModel;
import nl.omniex.omniexshopping.data.model.response.CartResponse;
import nl.omniex.omniexshopping.utils.SharedPrefUtils;
import retrofit2.Response;

public class CartRepository {

    private OmniexApi mOmniexApi;
    private SharedPrefUtils mSharedPrefUtils;

    @Inject
    CartRepository(OmniexApi omniexApi, SharedPrefUtils sharedPrefUtils){
        mOmniexApi = omniexApi;
        mSharedPrefUtils = sharedPrefUtils;
    }

    public Single<Response<CartResponse>> getCart(){
        return mOmniexApi
                .getCart(mSharedPrefUtils.getAccessToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Single<Response<Void>> addToCart(AddToCartModel addToCartModel){
        return mOmniexApi
                .addToCart(mSharedPrefUtils.getAccessToken(),addToCartModel)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Single<Response<Void>> emptyCart(){
        return mOmniexApi
                .emptyCart(mSharedPrefUtils.getAccessToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
