package nl.omniex.omniexshopping.ui.app.auth.login;

import javax.inject.Inject;

import nl.omniex.omniexshopping.data.model.auth.Login;
import nl.omniex.omniexshopping.data.repository.ProfileRepository;
import nl.omniex.omniexshopping.ui.base.BasePresenter;
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
                    ifViewAttached(view -> view.onLoginSuccess());
                }, error -> {
                    error.printStackTrace();
                    Timber.e(error);
                }));
    }

    void logout(){
        addDisposable(mProfileRepository
        .logout()
        .subscribe(voidResponse -> {}, Throwable::printStackTrace));
    }
}
