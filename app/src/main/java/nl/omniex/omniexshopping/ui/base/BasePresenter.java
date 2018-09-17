package nl.omniex.omniexshopping.ui.base;

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class BasePresenter<V extends BaseView> extends MvpBasePresenter<V> {

    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    public void addDisposable(Disposable disposable) {
        mCompositeDisposable.add(disposable);
    }

    @Override
    public void detachView() {
        super.detachView();
        mCompositeDisposable.dispose();
    }
}