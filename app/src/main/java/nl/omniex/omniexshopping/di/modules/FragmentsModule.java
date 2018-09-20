package nl.omniex.omniexshopping.di.modules;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import nl.omniex.omniexshopping.ui.app.categories.CategoriesFragment_;
import nl.omniex.omniexshopping.ui.app.main.home.HomeFragment_;
import nl.omniex.omniexshopping.ui.app.product.ProductDetailsFragment_;
import nl.omniex.omniexshopping.ui.views.dialogs.cart.CartDialog_;

@Module
public abstract class FragmentsModule {

    @ContributesAndroidInjector
    public abstract HomeFragment_ contributeHomeFragment();

    @ContributesAndroidInjector
    public abstract CategoriesFragment_ contributeCategoriesFragment();

    @ContributesAndroidInjector
    public abstract ProductDetailsFragment_ contributeProductDetailsFragment();

    @ContributesAndroidInjector
    public abstract CartDialog_ contributeCartDialog();
}
