package nl.omniex.omniexshopping.data.repository;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import nl.omniex.omniexshopping.data.api.OmniexApi;
import nl.omniex.omniexshopping.data.model.auth.Login;
import retrofit2.Response;

public class ProfileRepository {

    private OmniexApi mOmniexApi;

    @Inject
    ProfileRepository(OmniexApi omniexApi){
        mOmniexApi = omniexApi;
    }

    public Single<Response<Void>> login(Login login){
        return mOmniexApi
                .login(login)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
