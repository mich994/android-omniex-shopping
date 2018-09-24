package nl.omniex.omniexshopping.di.modules;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import nl.omniex.omniexshopping.ui.app.categories.CategoriesFragment_;
import nl.omniex.omniexshopping.ui.app.main.home.HomeFragment_;
import nl.omniex.omniexshopping.ui.app.product.ProductDetailsFragment_;
import nl.omniex.omniexshopping.ui.app.product.list.ProductsListFragment_;
import nl.omniex.omniexshopping.ui.app.profile.ProfileFragment_;
import nl.omniex.omniexshopping.ui.app.profile.address.ProfileAddressFragment_;
import nl.omniex.omniexshopping.ui.app.profile.order.ProfileOrderFragment_;
import nl.omniex.omniexshopping.ui.views.dialogs.address.CountryDialog_;
import nl.omniex.omniexshopping.ui.views.dialogs.address.ZoneDialog_;
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

    @ContributesAndroidInjector
    public abstract ProductsListFragment_ contributeProductsListFragment();

    @ContributesAndroidInjector
    public abstract ProfileFragment_ contributeProfileFragment();

    @ContributesAndroidInjector
    public abstract ProfileAddressFragment_ contributeProfileAddressFragment();

    @ContributesAndroidInjector
    public abstract ProfileOrderFragment_ contributeProfileOrderFragment();

    @ContributesAndroidInjector
    public abstract CountryDialog_ contributeCountryDialog();

    @ContributesAndroidInjector
    public abstract ZoneDialog_ contributeZoneDialog();
}
