package nl.omniex.omniexshopping.data.api;

import io.reactivex.Single;
import nl.omniex.omniexshopping.data.model.auth.Login;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface OmniexApi {

    @POST("index.php?route=feed/rest_api/gettoken&grant_type=client_credentials")
    Single<Response<Void>> getAccessToken(
            @Header("Authorization") String header
    );

    @POST("index.php?route=rest/login/login")
    Single<Response<Void>> login(
            @Header("Authorization") String accessToken,
            @Body Login login
    );
}
