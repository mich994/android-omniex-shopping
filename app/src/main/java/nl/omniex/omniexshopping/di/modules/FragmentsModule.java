package nl.omniex.omniexshopping.di.modules;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import nl.omniex.omniexshopping.ui.app.categories.CategoriesFragment_;
import nl.omniex.omniexshopping.ui.app.main.home.HomeFragment_;

@Module
public abstract class FragmentsModule {

    @ContributesAndroidInjector
    public abstract HomeFragment_ contributeHomeFragment();

    @ContributesAndroidInjector
    public abstract CategoriesFragment_ contributeCategoriesFragment();
}
