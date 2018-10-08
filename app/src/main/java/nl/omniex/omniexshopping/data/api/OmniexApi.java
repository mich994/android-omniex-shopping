package nl.omniex.omniexshopping.data.api;

import io.reactivex.Single;
import nl.omniex.omniexshopping.data.model.address.AddAddress;
import nl.omniex.omniexshopping.data.model.address.Address;
import nl.omniex.omniexshopping.data.model.auth.Login;
import nl.omniex.omniexshopping.data.model.auth.OldToken;
import nl.omniex.omniexshopping.data.model.cart.AddToCartModel;
import nl.omniex.omniexshopping.data.model.cart.CartItemDelete;
import nl.omniex.omniexshopping.data.model.cart.CartQuantitySetter;
import nl.omniex.omniexshopping.data.model.order.OrderAddress;
import nl.omniex.omniexshopping.data.model.payment.PaymentMethodSetter;
import nl.omniex.omniexshopping.data.model.response.AccessTokenResponse;
import nl.omniex.omniexshopping.data.model.response.AddressListResponse;
import nl.omniex.omniexshopping.data.model.response.CartResponse;
import nl.omniex.omniexshopping.data.model.response.CategoriesResponse;
import nl.omniex.omniexshopping.data.model.response.CountryResponse;
import nl.omniex.omniexshopping.data.model.response.FeaturedProductsResponse;
import nl.omniex.omniexshopping.data.model.response.LoginResponse;
import nl.omniex.omniexshopping.data.model.response.OrderAddressesResponse;
import nl.omniex.omniexshopping.data.model.response.OrderStatusesResponse;
import nl.omniex.omniexshopping.data.model.response.ProductResponse;
import nl.omniex.omniexshopping.data.model.response.ProductsListResponse;
import nl.omniex.omniexshopping.data.model.response.ShippingMethodResponse;
import nl.omniex.omniexshopping.data.model.response.ZoneResponse;
import nl.omniex.omniexshopping.data.model.shipping.ShippingMethodSetter;
import nl.omniex.omniexshopping.data.model.shipping.ShippingQuote;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface OmniexApi {

    //region ACCOUNT
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
    //endregion

    //region CATEGORIES
    @GET("index.php?route=feed/rest_api/categories")
    Single<Response<CategoriesResponse>> getCategories(
            @Header("Authorization") String accessToken
    );
    //endregion

    //region PRODUCTS
    @GET("index.php?route=feed/rest_api/products")
    Single<Response<Void>> getProducts(
            @Header("Authorization") String accessToken
    );

    @GET("index.php?route=feed/rest_api/products")
    Single<Response<ProductsListResponse>> getProductsByCat(
            @Header("Authorization") String accessToken,
            @Query("category") Integer catId
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

    @GET("index.php?route=feed/rest_api/bestsellers")
    Single<Response<ProductsListResponse>> getBestsellers(
            @Header("Authorization") String accessToken,
            @Query("limit") Integer limit
    );

    //endregion

    //region CART
    @POST("index.php?route=rest/cart/cart")
    Single<Response<Void>> addToCart(
            @Header("Authorization") String accessToken,
            @Body AddToCartModel addToCartModel
    );

    @GET("index.php?route=rest/cart/cart")
    Single<Response<CartResponse>> getCart(
            @Header("Authorization") String accessToken
    );

    @HTTP(method = "DELETE", path = "index.php?route=rest/cart/cart", hasBody = true)
//    @DELETE("index.php?route=rest/cart/cart")
    Single<Response<Void>> deleteCartItem(
            @Header("Authorization") String accessToken,
            @Body CartItemDelete cartItemDelete
    );

    @DELETE("index.php?route=rest/cart/emptycart")
    Single<Response<Void>> emptyCart(
            @Header("Authorization") String accessToken
    );

    @PUT("index.php?route=rest/cart/cart")
    Single<Response<Void>> updateCartItemQuantity(
            @Header("Authorization") String accessToken,
            @Body CartQuantitySetter cartQuantitySetter
    );
    //endregion

    //region SHIPPING
    @GET("index.php?route=rest/shipping_method/shippingmethods")
    Single<Response<ShippingMethodResponse>> getShippingMethods(
            @Header("Authorization") String accessToken
    );

    @POST("index.php?route=rest/shipping_method/shippingmethods")
    Single<Response<Void>> setShippingMethod(
            @Header("Authorization") String accessToken,
            @Body ShippingMethodSetter shippingMethodSetter
    );

    @POST("index.php?route=rest/cart/shippingquotes")
    Single<Response<Void>> getShippingQuotes(
            @Header("Authorization") String accessToken,
            @Body ShippingQuote shippingQuote
    );

    @PUT("index.php?route=rest/cart/shippingquotes")
    Single<Response<Void>> saveShippingQuote(
            @Header("Authorization") String accessToken,
            @Query("id") String id
    );

    @GET("index.php?route=rest/shipping_address/shippingaddress")
    Single<Response<OrderAddressesResponse>> getShippingAddresses(
            @Header("Authorization") String accessToken
    );

    @POST("index.php?route=rest/shipping_address/shippingaddress")
    Single<Response<Void>> addNewShippingAddress(
            @Header("Authorization") String accessToken,
            @Body OrderAddress orderAddress
    );

    @POST("index.php?route=rest/shipping_address/shippingaddress/existing")
    Single<Response<Void>> setExisitingShippingAddress(
            @Header("Authorization") String accessToken,
            @Body Address existingAddress
    );
    //endregion

    //region ADDRESS
    @GET("index.php?route=rest/account/address")
    Single<Response<AddressListResponse>> getAddressList(
            @Header("Authorization") String accessToken
    );

    @POST("index.php?route=rest/account/address")
    Single<Response<Void>> addNewAddress(
            @Header("Authorization") String accessToken,
            @Body AddAddress addAddress
    );

    @GET("index.php?route=rest/account/address")
    Single<Response<Void>> getAddressById(
            @Header("Authorization") String accessToken,
            @Query("id") Integer id
    );

    @PUT("index.php?route=rest/account/address")
    Single<Response<Void>> editAddress(
            @Header("Authorization") String accessToken,
            @Query("id") Integer id,
            @Body AddAddress addAddress
    );

    @DELETE("index.php?route=rest/account/address")
    Single<Response<Void>> removeAddress(
            @Header("Authorization") String accessToken,
            @Query("id") Integer id
    );
    //endregion

    //region ORDERS
    @GET("index.php?route=rest/order/orders")
    Single<Response<Void>> getCustomerOrders(
            @Header("Authorization") String accessToken,
            @Query("limit") Integer limit,
            @Query("page") Integer page
    );

    @GET("index.php?route=rest/order/orders")
    Single<Response<Void>> getOrderDetails(
            @Header("Authorization") String accessToken,
            @Query("id") Integer id
    );

    @GET("index.php?route=rest/order/orders")
    Single<Response<OrderStatusesResponse>> getOrderStatuses(
            @Header("Authorization") String accessToken,
            @Query("limit") Integer limit,
            @Query("page") Integer page
    );

    @POST("index.php?route=rest/simple_confirm/confirm")
    Single<Response<Void>> simpleConfirmOverview(
            @Header("Authorization") String accessToken
    );

    @PUT("index.php?route=rest/simple_confirm/confirm")
    Single<Response<Void>> simpleConfirmSave(
            @Header("Authorization") String accessToken
    );

    @POST("index.php?route=rest/confirm/confirm")
    Single<Response<Void>> getOrderOverview(
            @Header("Authorization") String accessToken
    );

    @PUT("index.php?route=rest/confirm/confirm")
    Single<Response<Void>> confirmOrder(
            @Header("Authorization") String accessToken
    );
    //endregion

    //region PAYMENTS

    @GET("index.php?route=rest/payment_address/paymentaddress")
    Single<Response<OrderAddressesResponse>> getPaymentAdresses(
            @Header("Authorization") String accessToken
    );

    @POST("index.php?route=rest/payment_address/paymentaddress")
    Single<Response<Void>> addNewPaymentAddress(
            @Header("Authorization") String accessToken,
            @Body OrderAddress orderAddress
    );

    @POST("index.php?route=rest/payment_address/paymentaddress/existing")
    Single<Response<Void>> setExisitingPaymentAddress(
            @Header("Authorization") String accessToken,
            @Body Address existingAddress
    );

    @GET("index.php?route=rest/payment_method/payments")
    Single<Response<Void>> getPaymentMethods(
            @Header("Authorization") String accessToken
    );

    @POST("index.php?route=rest/payment_method/payments")
    Single<Response<Void>> setPaymentMethod(
            @Header("Authorization") String accessToken,
            @Body PaymentMethodSetter paymentMethodSetter
    );

    //endregion

    //region COUNTRIES
    @GET("index.php?route=feed/rest_api/countries")
    Single<Response<CountryResponse>> getCountries(
            @Header("Authorization") String accessToken
    );

    @GET("index.php?route=feed/rest_api/countries")
    Single<Response<ZoneResponse>> getZones(
            @Header("Authorization") String accessToken,
            @Query("id") Integer id
    );
    //endregion

    //region MANUFACTURERS
    @GET("index.php?route=feed/rest_api/manufacturers")
    Single<Response<Void>> getManufacturers(
            @Header("Authorization") String accessToken
    );
    //endregion

    //region OTHERS

    @GET("index.php?route=feed/rest_api/information")
    Single<Response<Void>> getInformation(
            @Header("Authorization") String accessToken
    );

    @GET("index.php?route=feed/rest_api/information")
    Single<Response<Void>> getInformationById(
            @Header("Authorization") String accessToken,
            @Query("id") Integer id
    );

    @PUT("index.php?route=rest/account/newsletter")
    Single<Response<Void>> subscribeNewsletter(
            @Header("Authorization") String accessToken,
            @Query("subscribe") Integer subscribe
    );

    //endregion
}

























