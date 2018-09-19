package nl.omniex.omniexshopping.ui.app.main;

import javax.inject.Inject;

import nl.omniex.omniexshopping.data.repository.ProfileRepository;
import nl.omniex.omniexshopping.ui.base.BasePresenter;
import nl.omniex.omniexshopping.utils.SharedPrefUtils;

public class MainMenuPresenter extends BasePresenter<MainMenuView> {

    private ProfileRepository mProfileRepository;

    @Inject
    MainMenuPresenter(ProfileRepository profileRepository) {
        mProfileRepository = profileRepository;
    }

    void logout() {
        addDisposable(mProfileRepository
                .logout()
                .subscribe(
                        voidResponse -> {
                            if (voidResponse.code() == 200) {
                                SharedPrefUtils.setUserLogged(false);
                                ifViewAttached(MainMenuView::onLogoutSuccess);
                            }
                        }, Throwable::printStackTrace));
    }
}
