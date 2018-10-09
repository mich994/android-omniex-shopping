package nl.omniex.omniexshopping.ui.app.auth.register;

import com.google.gson.Gson;

import javax.inject.Inject;

import nl.omniex.omniexshopping.data.model.auth.register.RegisterSetter;
import nl.omniex.omniexshopping.data.model.response.RegisterResponse;
import nl.omniex.omniexshopping.data.repository.ProfileRepository;
import nl.omniex.omniexshopping.ui.base.BasePresenter;
import nl.omniex.omniexshopping.utils.StringUtils;
import timber.log.Timber;

public class RegisterPresenter extends BasePresenter<RegisterView> {

    private ProfileRepository mProfileRepository;

    @Inject
    RegisterPresenter(ProfileRepository profileRepository) {
        mProfileRepository = profileRepository;
    }

    void register(RegisterSetter registerSetter) {
        addDisposable(mProfileRepository
                .register(registerSetter)
                .subscribe(
                        voidResponse -> {
                            if (voidResponse.code()==200){
                                ifViewAttached(view -> view.onRegisterSuccess());
                            }else {
                                String error=voidResponse.errorBody().string();
                                ifViewAttached(view -> view.onRegisterFailed(StringUtils.createErrorMessageString(errorResponse(error).getErrors())));
                            }
                        }, error -> {
                            ifViewAttached(view -> view.onConnectionFailed());
                            Timber.e(error);
                            error.printStackTrace();
                        }));
    }

    private RegisterResponse errorResponse(String errorBody){
        return new Gson().fromJson(errorBody, RegisterResponse.class);
    }
}
