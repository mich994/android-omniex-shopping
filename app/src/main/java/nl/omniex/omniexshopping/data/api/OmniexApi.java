package nl.omniex.omniexshopping.data.api;

import io.reactivex.Single;
import nl.omniex.omniexshopping.data.model.auth.Login;
import nl.omniex.omniexshopping.data.model.auth.OldToken;
import nl.omniex.omniexshopping.data.model.cart.AddToCartModel;
import nl.omniex.omniexshopping.data.model.response.AccessTokenResponse;
import nl.omniex.omniexshopping.data.model.response.CartResponse;
import nl.omniex.omniexshopping.data.model.response.CategoriesResponse;
import nl.omniex.omniexshopping.data.model.response.FeaturedProductsResponse;
import nl.omniex.omniexshopping.data.model.response.LoginResponse;
import nl.omniex.omniexshopping.data.model.response.ProductResponse;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface OmniexApi {

    @POST("index.php?route=feed/rest_api/gettoken&grant_type=client_credentials")
    Single<Response<AccessTokenResponse>> getAccessToken(
            @Header("Authorization") String header
    );

    @POST("index.php?route=feed/rest_api/gettoken&grant_type=client_credentials")
    Single<Response<AccessTokenResponse>> refreshAccessToken(
            @Header("Authorization") String header,
            @Body OldToken oldToken
    );

    @POST("index.php?route=rest/login/login")
    Single<Response<LoginResponse>> login(
            @Header("Authorization") String accessToken,
            @Body Login login
    );

    @POST("index.php?route=rest/logout/logout")
    Single<Response<Void>> logout(
            @Header("Authorization") String accessToken
    );

    @GET("index.php?route=rest/account/address")
    Single<Response<Void>> getAddressList(
            @Header("Authorization") String accessToken
    );

    //region CATEGORIES

    @GET("index.php?route=feed/rest_api/categories")
    Single<Response<CategoriesResponse>> getCategories(
            @Header("Authorization") String accessToken
    );

    @GET("index.php?route=feed/rest_api/products")
    Single<Response<Void>> getProducts(
            @Header("Authorization") String accessToken
    );

    @GET("index.php?route=feed/rest_api/products")
    Single<Response<Void>> getProductsByCat(
            @Header("Authorization") String accessToken,
            @Query("category_id") Integer catId
    );

    @GET("index.php?route=feed/rest_api/featured")
    Single<Response<FeaturedProductsResponse>> getListOfFeatured(
            @Header("Authorization") String accessToken
    );

    @GET("index.php?route=feed/rest_api/products")
    Single<Response<ProductResponse>> getProductDetails(
            @Header("Authorization") String accessToken,
            @Query("id") Integer id
    );

    @POST("index.php?route=rest/cart/cart")
    Single<Response<Void>> addToCart(
            @Header("Authorization") String accessToken,
            @Body AddToCartModel addToCartModel
    );

    @GET("index.php?route=rest/cart/cart")
    Single<Response<CartResponse>> getCart(
            @Header("Authorization") String accessToken
    );
}

























