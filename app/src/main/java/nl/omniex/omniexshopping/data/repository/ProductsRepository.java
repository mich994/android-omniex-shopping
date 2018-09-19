package nl.omniex.omniexshopping.data.repository;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import nl.omniex.omniexshopping.data.api.OmniexApi;
import nl.omniex.omniexshopping.data.model.response.CategoriesResponse;
import nl.omniex.omniexshopping.data.model.response.FeaturedProductsResponse;
import nl.omniex.omniexshopping.data.model.response.ProductResponse;
import nl.omniex.omniexshopping.utils.SharedPrefUtils;
import retrofit2.Response;

public class ProductsRepository {

    private OmniexApi mOmniexApi;
    private SharedPrefUtils mSharedPrefUtils;

    @Inject
    ProductsRepository(OmniexApi omniexApi, SharedPrefUtils sharedPrefUtils){
        mOmniexApi = omniexApi;
        mSharedPrefUtils = sharedPrefUtils;
    }

    public Single<Response<CategoriesResponse>> getCategories(){
        return mOmniexApi
                .getCategories(mSharedPrefUtils.getAccessToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Single<Response<Void>> getProducts(){
        return mOmniexApi
                .getProducts(mSharedPrefUtils.getAccessToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Single<Response<Void>> getProductsByCat(){
        return mOmniexApi
                .getProductsByCat(mSharedPrefUtils.getAccessToken(), 33)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Single<Response<ProductResponse>> getProductDetails(Integer id){
        return mOmniexApi
                .getProductDetails(mSharedPrefUtils.getAccessToken(), id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }


    public Single<Response<FeaturedProductsResponse>> getListOfFeatured(){
        return mOmniexApi
                .getListOfFeatured(mSharedPrefUtils.getAccessToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
