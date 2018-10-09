package nl.omniex.omniexshopping.data.repository;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import nl.omniex.omniexshopping.data.api.OmniexApi;
import nl.omniex.omniexshopping.utils.SharedPrefUtils;
import retrofit2.Response;

public class NewsletterRepository {

    private OmniexApi mOmniexApi;
    private SharedPrefUtils mSharedPrefUtils;

    @Inject
    NewsletterRepository(OmniexApi omniexApi, SharedPrefUtils sharedPrefUtils){
        mOmniexApi = omniexApi;
        mSharedPrefUtils = sharedPrefUtils;
    }

    public Single<Response<Void>> subscribeNewsletter(){
        return mOmniexApi
                .subscribeNewsletter(mSharedPrefUtils.getAccessToken(),1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Single<Response<Void>> unsubscribeNewsletter(){
        return mOmniexApi
                .subscribeNewsletter(mSharedPrefUtils.getAccessToken(),0)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
