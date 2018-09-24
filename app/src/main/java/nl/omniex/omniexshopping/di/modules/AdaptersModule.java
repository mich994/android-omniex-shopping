package nl.omniex.omniexshopping.di.modules;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import nl.omniex.omniexshopping.ui.adapters.CartAdapter;
import nl.omniex.omniexshopping.ui.adapters.CartAdapter_;
import nl.omniex.omniexshopping.ui.adapters.CategoriesAdapter;
import nl.omniex.omniexshopping.ui.adapters.CategoriesAdapter_;
import nl.omniex.omniexshopping.ui.adapters.FeatureProductsAdapter;
import nl.omniex.omniexshopping.ui.adapters.FeatureProductsAdapter_;
import nl.omniex.omniexshopping.ui.adapters.ProductDetailsImageAdapter;
import nl.omniex.omniexshopping.ui.adapters.ProductDetailsImageAdapter_;
import nl.omniex.omniexshopping.ui.adapters.ProductsListAdapter;
import nl.omniex.omniexshopping.ui.adapters.ProductsListAdapter_;

@Module
public class AdaptersModule {

    @Provides
    FeatureProductsAdapter provideFeaturedProductsAdapter(Context context){
        return FeatureProductsAdapter_.getInstance_(context);
    }

    @Provides
    ProductDetailsImageAdapter provideProductDetailsImageAdapter(Context context){
        return ProductDetailsImageAdapter_.getInstance_(context);
    }

    @Provides
    CategoriesAdapter provideCategoriesAdapter(Context context){
        return CategoriesAdapter_.getInstance_(context);
    }

    @Provides
    CartAdapter provideCartAdapter(Context context){
        return CartAdapter_.getInstance_(context);
    }

    @Provides
    ProductsListAdapter provideProductsListAdapter(Context context){
        return ProductsListAdapter_.getInstance_(context);
    }
}
