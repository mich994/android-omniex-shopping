package nl.omniex.omniexshopping.di.modules;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import nl.omniex.omniexshopping.ui.adapters.FeatureProductsAdapter;
import nl.omniex.omniexshopping.ui.adapters.FeatureProductsAdapter_;

@Module
public class AdaptersModule {

    @Provides
    FeatureProductsAdapter provideFeaturedProductsAdapter(Context context){
        return FeatureProductsAdapter_.getInstance_(context);
    }
}
