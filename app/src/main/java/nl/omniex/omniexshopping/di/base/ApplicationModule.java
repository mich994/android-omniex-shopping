package nl.omniex.omniexshopping.di.base;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import nl.omniex.omniexshopping.di.modules.ActivitiesModule;
import nl.omniex.omniexshopping.di.modules.AdaptersModule;
import nl.omniex.omniexshopping.di.modules.ApiModule;
import nl.omniex.omniexshopping.di.modules.FragmentsModule;

@Module(includes = {ActivitiesModule.class,
        FragmentsModule.class,
        ApiModule.class,
        AdaptersModule.class})
public class ApplicationModule {

    private Context mContext;

    ApplicationModule(Context context) {
        mContext = context;
    }

    @Provides
    Context provideContext() {
        return mContext;
    }

}
