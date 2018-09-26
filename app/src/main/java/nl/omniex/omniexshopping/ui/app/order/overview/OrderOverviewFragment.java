package nl.omniex.omniexshopping.ui.app.order.overview;

import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.HashMap;

import javax.inject.Inject;

import nl.omniex.omniexshopping.R;
import nl.omniex.omniexshopping.ui.base.BaseFragment;
import nl.omniex.omniexshopping.utils.SharedPrefUtils;

@EFragment(R.layout.fragment_order_overview)
public class OrderOverviewFragment extends BaseFragment<OrderOverviewView, OrderOverviewPresenter> {

    @ViewById(R.id.order_overview_wv)
    WebView mWebView;

    @Inject
    SharedPrefUtils mSharedPrefUtils;

    @AfterViews
    void test(){
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDisplayZoomControls(false);
        webSettings.setAppCacheEnabled(true);
        webSettings.setLoadsImagesAutomatically(true);
        webSettings.setBuiltInZoomControls(false);
        webSettings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);

        mWebView.setWebViewClient(new WebViewClient());
//        mWebView.setWebViewClient(new WebViewClient() {
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                HashMap<String, String> headerMap = new HashMap<>();
//                headerMap.put("Authorization", mSharedPrefUtils.getAccessToken());
//                view.loadUrl("http://omniex.nl/index.php?route=rest/confirm/confirm", headerMap);
//                return true;
//            }
//
//            @Override
//            public void onPageFinished(WebView view, String url) {
//            }
//
//            @Override
//            public void onReceivedHttpAuthRequest(WebView view, HttpAuthHandler handler, String host, String realm) {
//            }
//        });
        HashMap<String, String> headerMap = new HashMap<>();
        headerMap.put("Authorization", mSharedPrefUtils.getAccessToken());
        mWebView.loadUrl("http://omniex.nl/index.php?route=rest/confirm/confirm", headerMap);

    }
}
