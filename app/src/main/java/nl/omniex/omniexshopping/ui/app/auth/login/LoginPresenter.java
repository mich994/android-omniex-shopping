package nl.omniex.omniexshopping.ui.app.auth.login;

import javax.inject.Inject;

import nl.omniex.omniexshopping.data.model.auth.Login;
import nl.omniex.omniexshopping.data.repository.ProfileRepository;
import nl.omniex.omniexshopping.ui.base.BasePresenter;
import nl.omniex.omniexshopping.utils.SharedPrefUtils;
import timber.log.Timber;

public class LoginPresenter extends BasePresenter<LoginView> {

    private ProfileRepository mProfileRepository;

    @Inject
    LoginPresenter(ProfileRepository profileRepository) {
        mProfileRepository = profileRepository;
    }

    void login(Login login) {
        addDisposable(mProfileRepository
                .login(login)
                .subscribe(voidResponse -> {
                    if (voidResponse.code() == 200) {
                        SharedPrefUtils.setUserLogged(true);
                        ifViewAttached(LoginView::onLoginSuccess);
                    }
                }, error -> {
                    error.printStackTrace();
                    Timber.e(error);
                }));
    }
}
