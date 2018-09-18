package nl.omniex.omniexshopping.data.repository;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import nl.omniex.omniexshopping.data.api.OmniexApi;
import nl.omniex.omniexshopping.data.model.auth.OldToken;
import nl.omniex.omniexshopping.data.model.response.AccessTokenResponse;
import retrofit2.Response;

import static nl.omniex.omniexshopping.data.Constants.BASIC_TOKEN;

public class TokenRepository {

    private OmniexApi mOmniexApi;

    @Inject
    TokenRepository(OmniexApi omniexApi){
        mOmniexApi = omniexApi;
    }

    public Single<Response<AccessTokenResponse>> getAccessToken(){
        return mOmniexApi
                .getAccessToken(BASIC_TOKEN)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Single<Response<AccessTokenResponse>> refreshAccessToken(OldToken oldToken){
        return mOmniexApi
                .refreshAccessToken(BASIC_TOKEN,oldToken )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }


}
