package nl.omniex.omniexshopping.data.repository;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import nl.omniex.omniexshopping.data.api.OmniexApi;
import nl.omniex.omniexshopping.data.model.auth.Login;
import nl.omniex.omniexshopping.data.model.auth.register.RegisterSetter;
import nl.omniex.omniexshopping.data.model.response.LoginResponse;
import nl.omniex.omniexshopping.data.model.response.RegisterResponse;
import nl.omniex.omniexshopping.utils.SharedPrefUtils;
import retrofit2.Response;

public class ProfileRepository {

    private OmniexApi mOmniexApi;
    private SharedPrefUtils mSharedPrefUtils;

    @Inject
    ProfileRepository(OmniexApi omniexApi, SharedPrefUtils sharedPrefUtils) {
        mOmniexApi = omniexApi;
        mSharedPrefUtils = sharedPrefUtils;
    }

    public Single<Response<LoginResponse>> login(Login login) {
        return mOmniexApi
                .login(mSharedPrefUtils.getAccessToken(), login)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Single<Response<Void>> logout() {
        return mOmniexApi
                .logout(mSharedPrefUtils.getAccessToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Single<Response<RegisterResponse>> register(RegisterSetter registerSetter) {
        return mOmniexApi
                .register(mSharedPrefUtils.getAccessToken(), registerSetter)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
