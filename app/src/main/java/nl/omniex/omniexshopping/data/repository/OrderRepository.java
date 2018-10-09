package nl.omniex.omniexshopping.data.repository;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import nl.omniex.omniexshopping.data.api.OmniexApi;
import nl.omniex.omniexshopping.data.model.response.OrderStatusesResponse;
import nl.omniex.omniexshopping.utils.SharedPrefUtils;
import retrofit2.Response;

public class OrderRepository {

    private OmniexApi mOmniexApi;
    private SharedPrefUtils mSharedPrefUtils;

    @Inject
    OrderRepository(OmniexApi omniexApi, SharedPrefUtils sharedPrefUtils){
        mOmniexApi = omniexApi;
        mSharedPrefUtils = sharedPrefUtils;
    }

    public Single<Response<Void>> simpleConfirm(){
        return mOmniexApi
                .simpleConfirmOverview(mSharedPrefUtils.getAccessToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Single<Response<Void>> getOrderOverview(){
        return mOmniexApi
                .getOrderOverview(mSharedPrefUtils.getAccessToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Single<Response<Void>> confirmOrder(){
        return mOmniexApi
                .confirmOrder(mSharedPrefUtils.getAccessToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Single<Response<OrderStatusesResponse>> getOrderStatuses(){
        return mOmniexApi
                .getOrderStatuses(mSharedPrefUtils.getAccessToken(),20,1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Single<Response<Void>> getOrderDetails(Integer id){
        return mOmniexApi
                .getOrderDetails(mSharedPrefUtils.getAccessToken(),id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }



}
