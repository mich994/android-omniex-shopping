package nl.omniex.omniexshopping.data.repository;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import nl.omniex.omniexshopping.data.api.OmniexApi;
import retrofit2.Response;

import static nl.omniex.omniexshopping.data.Constants.BASIC_TOKEN;

public class TokenRepository {

    private OmniexApi mOmniexApi;

    @Inject
    TokenRepository(OmniexApi omniexApi){
        mOmniexApi = omniexApi;
    }

    public Single<Response<Void>> getAccessToken(){
        return mOmniexApi
                .getAccessToken(BASIC_TOKEN)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
