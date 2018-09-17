package nl.omniex.omniexshopping.ui.app.splash;

import javax.inject.Inject;

import nl.omniex.omniexshopping.data.repository.TokenRepository;
import nl.omniex.omniexshopping.ui.base.BasePresenter;

public class SplashPresenter extends BasePresenter<SplashView>{

    private TokenRepository mTokenRepository;

    @Inject
    SplashPresenter(TokenRepository tokenRepository){
        mTokenRepository = tokenRepository;
    }

    void getAccessToken(){
        addDisposable(mTokenRepository
                .getAccessToken()
                .subscribe(voidResponse -> ifViewAttached(SplashView::onTokenFetched), Throwable::printStackTrace)
        );
    }
}
