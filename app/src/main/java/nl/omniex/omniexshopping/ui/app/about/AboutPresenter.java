package nl.omniex.omniexshopping.ui.app.about;

import javax.inject.Inject;

import nl.omniex.omniexshopping.data.repository.AboutRepository;
import nl.omniex.omniexshopping.ui.base.BasePresenter;

public class AboutPresenter extends BasePresenter<AboutView> {

    private AboutRepository mAboutRepository;

    @Inject
    AboutPresenter(AboutRepository aboutRepository){
        mAboutRepository = aboutRepository;
    }

    void getInformation(){
        addDisposable(mAboutRepository
        .getInformation()
        .subscribe(voidResponse -> {},Throwable::printStackTrace));
    }

    void getInformationById(Integer id){
        addDisposable(mAboutRepository
                .getInformationById(id)
                .subscribe(voidResponse -> {},Throwable::printStackTrace));
    }
}
