package nl.omniex.omniexshopping.ui.app.about;

import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import nl.omniex.omniexshopping.R;
import nl.omniex.omniexshopping.ui.base.BaseFragment;

@EFragment(R.layout.fragment_about)
public class AboutFragment extends BaseFragment<AboutView, AboutPresenter> implements AboutView {

    @ViewById(R.id.about_web_view)
    WebView mAboutWebView;

    @AfterViews
    void initWebView(){
        mAboutWebView.setWebViewClient(new WebViewClient());
        WebSettings webSettings = mAboutWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAllowContentAccess(true);
        mAboutWebView.loadUrl("http://omniex.nl/index.php?route=information/information&information_id=4");
    }
}
