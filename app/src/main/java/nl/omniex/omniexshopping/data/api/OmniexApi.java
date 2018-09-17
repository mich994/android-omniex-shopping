package nl.omniex.omniexshopping.data.api;

import io.reactivex.Single;
import nl.omniex.omniexshopping.data.model.auth.Login;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface OmniexApi {

    @POST("oauth2/token/{grant_type}")
    Single<Response<Void>> getAccessToken(
            @Header("Authorization") String header,
            @Path("grant_type") String grantType
    );

    @POST("login")
    Single<Response<Void>> login(
            @Body Login login
    );
}
