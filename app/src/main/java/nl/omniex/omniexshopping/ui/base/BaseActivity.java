package nl.omniex.omniexshopping.ui.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.Toast;

import com.hannesdorfmann.mosby3.mvp.MvpActivity;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;

import javax.inject.Inject;

import dagger.Lazy;
import dagger.android.AndroidInjection;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import nl.omniex.omniexshopping.R;
import nl.omniex.omniexshopping.ui.views.toolbar.CustomToolbar;

@EActivity
public abstract class BaseActivity<V extends BaseView, P extends BasePresenter<V>> extends MvpActivity<V, P> implements BaseView {

    @Bean
    protected CustomToolbar mCustomToolbar;

    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();
    private FragmentManager mFragmentManager;
    private OnBackPressListener mOnBackPressListener;

    @Inject
    Lazy<P> mPresenter;

    @AfterInject
    protected void afterInject() {
        try {
            AndroidInjection.inject(this);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFragmentManager = getSupportFragmentManager();

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        if (savedInstanceState == null)
            onFirstCreate();
    }

    protected void onFirstCreate() {
    }

    public CustomToolbar getCustomToolbar() {
        return mCustomToolbar;
    }

    public void addDisposable(Disposable disposable) {
        mCompositeDisposable.add(disposable);
    }

    public void goToFragment(Fragment fragment, boolean addToBackStack, String tag) {
        Fragment fragmentContainer = mFragmentManager.findFragmentById(R.id.fragment_container);
        if (fragmentContainer != null && fragmentContainer.getClass().getSimpleName().equals(fragment.getClass().getSimpleName()))
            return;
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        if (addToBackStack)
            transaction.addToBackStack(tag);
        transaction.commit();
    }

    public void popBackStack() {
        mFragmentManager.popBackStack();
    }

    public void setOnBackPressListener(OnBackPressListener onBackPressListener) {
        mOnBackPressListener = onBackPressListener;
    }

    @Override
    public void onBackPressed() {
        if (mFragmentManager.getBackStackEntryCount() > 1)
            popBackStack();
        else
            super.onBackPressed();

    }

    public void showToastMessage(String message, int duration) throws IllegalArgumentException {
        switch (duration) {
            case 0:
                Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
                break;
            case 1:
                Toast.makeText(this, message, Toast.LENGTH_LONG).show();
                break;
            default:
                throw new IllegalArgumentException();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mCompositeDisposable.dispose();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @NonNull
    @Override
    public P getPresenter() {
        return super.getPresenter();
    }

    @NonNull
    @Override
    public P createPresenter() {
        return mPresenter.get();
    }

    public interface OnBackPressListener {
        void onBackPressed();
    }
}
