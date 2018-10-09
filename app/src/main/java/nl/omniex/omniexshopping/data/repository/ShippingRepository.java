package nl.omniex.omniexshopping.data.repository;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import nl.omniex.omniexshopping.data.api.OmniexApi;
import nl.omniex.omniexshopping.data.model.response.ShippingMethodResponse;
import nl.omniex.omniexshopping.data.model.shipping.ShippingMethodSetter;
import nl.omniex.omniexshopping.utils.SharedPrefUtils;
import retrofit2.Response;

public class ShippingRepository {

    private OmniexApi mOmniexApi;
    private SharedPrefUtils mSharedPrefUtils;

    @Inject
    ShippingRepository(OmniexApi omniexApi, SharedPrefUtils sharedPrefUtils){
        mOmniexApi = omniexApi;
        mSharedPrefUtils = sharedPrefUtils;
    }

    public Single<Response<ShippingMethodResponse>> getShippingMethods(){
        return mOmniexApi
                .getShippingMethods(mSharedPrefUtils.getAccessToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Single<Response<Void>> setShippingMethod(ShippingMethodSetter shippingMethodSetter){
        return mOmniexApi
                .setShippingMethod(mSharedPrefUtils.getAccessToken(),shippingMethodSetter)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
