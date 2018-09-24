package nl.omniex.omniexshopping.data.repository;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import nl.omniex.omniexshopping.data.api.OmniexApi;
import nl.omniex.omniexshopping.data.model.address.AddAddress;
import nl.omniex.omniexshopping.data.model.response.AddressListResponse;
import nl.omniex.omniexshopping.utils.SharedPrefUtils;
import retrofit2.Response;

public class AddressRepository {

    private OmniexApi mOmniexApi;
    private SharedPrefUtils mSharedPrefUtils;

    @Inject
    AddressRepository(OmniexApi omniexApi, SharedPrefUtils sharedPrefUtils) {
        mOmniexApi = omniexApi;
        mSharedPrefUtils = sharedPrefUtils;
    }

    public Single<Response<AddressListResponse>> getAddressList() {
        return mOmniexApi
                .getAddressList(mSharedPrefUtils.getAccessToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Single<Response<Void>> addNewAddress(AddAddress addAddress) {
        return mOmniexApi
                .addNewAddress(mSharedPrefUtils.getAccessToken(), addAddress)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Single<Response<Void>> editAddress(Integer addressId, AddAddress addAddress) {
        return mOmniexApi
                .editAddress(mSharedPrefUtils.getAccessToken(), addressId, addAddress)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Single<Response<Void>> removeAddress(Integer addressId) {
        return mOmniexApi
                .removeAddress(mSharedPrefUtils.getAccessToken(), addressId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Single<Response<Void>> getAddressDetails(Integer addressId) {
        return mOmniexApi
                .getAddressById(mSharedPrefUtils.getAccessToken(), addressId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
