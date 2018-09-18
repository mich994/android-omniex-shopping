package nl.omniex.omniexshopping.di.modules;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import nl.omniex.omniexshopping.data.api.OmniexApi;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static nl.omniex.omniexshopping.data.Constants.BASE_URL;

@Module
public class ApiModule {
        @Provides
        Retrofit provideRetrofit(OkHttpClient okHttpClient){
            return new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build();
        }

        @Provides
        OkHttpClient provideOkHttpClient(){
            return new OkHttpClient.Builder()
                    .connectTimeout(10, TimeUnit.SECONDS)
                    .readTimeout(10, TimeUnit.SECONDS)
                    .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                    .retryOnConnectionFailure(true)
                    .build();
        }

        @Provides
        OmniexApi provideApiCalls(Retrofit retrofit){
            return retrofit.create(OmniexApi.class);
        }

}
