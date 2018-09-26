package nl.omniex.omniexshopping.data.repository;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import nl.omniex.omniexshopping.data.api.OmniexApi;
import nl.omniex.omniexshopping.data.model.payment.PaymentMethodSetter;
import nl.omniex.omniexshopping.utils.SharedPrefUtils;
import retrofit2.Response;

public class PaymentRespository {

    private OmniexApi mOmniexApi;
    private SharedPrefUtils mSharedPrefUtils;

    @Inject
    PaymentRespository(OmniexApi omniexApi, SharedPrefUtils sharedPrefUtils){
        mOmniexApi = omniexApi;
        mSharedPrefUtils = sharedPrefUtils;
    }

    public Single<Response<Void>> getPaymentMethods(){
        return mOmniexApi
                .getPaymentMethods(mSharedPrefUtils.getAccessToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Single<Response<Void>> setPaymentMethod(PaymentMethodSetter paymentMethodSetter){
        return mOmniexApi
                .setPaymentMethod(mSharedPrefUtils.getAccessToken(), paymentMethodSetter)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
