package nl.omniex.omniexshopping.ui.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.hannesdorfmann.mosby3.mvp.MvpFragment;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.EFragment;

import javax.inject.Inject;

import dagger.Lazy;
import dagger.android.support.AndroidSupportInjection;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import nl.omniex.omniexshopping.R;
import nl.omniex.omniexshopping.ui.base.menu.BaseMenuActivity;

@EFragment
public abstract class BaseFragment<V extends BaseView, P extends BasePresenter<V>> extends MvpFragment<V, P> {

    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();
    private BaseActivity mBaseActivity;
    private BaseMenuActivity mBaseMenuActivity;

    @Inject
    Lazy<P> mPresenter;

    @AfterInject
    protected void afterInject() {
        try {
            AndroidSupportInjection.inject(this);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    @NonNull
    @Override
    public P createPresenter() {
        return mPresenter.get();
    }

    @NonNull
    @Override
    public P getPresenter() {
        return super.getPresenter();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if ((context instanceof BaseActivity))
            mBaseActivity = (BaseActivity) getActivity();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mBaseActivity != null && mBaseActivity.getCustomToolbar() != null) {
            setToolbarIconMenuActivity();
        }
    }

    protected void goToFragment(Fragment fragment, boolean addToBackStack) {
        getBaseActivity().goToFragment(fragment, addToBackStack, "");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCompositeDisposable.dispose();
    }

    protected void setToolbarIconMenuActivity() {
        try {
            mBaseMenuActivity = (BaseMenuActivity) getActivity();
            if (mBaseMenuActivity.getSupportFragmentManager().getBackStackEntryCount() > 1)
                mBaseActivity.getCustomToolbar()
                        .setIconStart(R.drawable.twotone_arrow_back_black_36)
                        .setIconStarClickListener(() -> mBaseMenuActivity.getSupportFragmentManager().popBackStack());
            else
                mBaseActivity.getCustomToolbar()
                        .setIconStart(R.drawable.twotone_menu_black_36)
                        .setIconStarClickListener(() -> mBaseMenuActivity.toggleMenu());
        }catch (ClassCastException e){

        }
        }

    protected BaseActivity getBaseActivity() {
        return mBaseActivity;
    }

    protected void addDisposable(Disposable disposable) {
        mCompositeDisposable.add(disposable);
    }

}
