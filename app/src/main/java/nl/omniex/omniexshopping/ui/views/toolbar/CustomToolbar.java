package nl.omniex.omniexshopping.ui.views.toolbar;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.ViewById;

import nl.omniex.omniexshopping.R;

@EBean
public class CustomToolbar {

    @ViewById(R.id.toolbar)
    Toolbar mToolbar;

    @ViewById(R.id.toolbar_icon_start)
    ImageView mIconStart;

    @ViewById(R.id.toolbar_icon_center)
    ImageView mIconCenter;

    @ViewById(R.id.toolbar_icon_end)
    ImageView mIconEnd;

    @ViewById(R.id.toolbar_text_center)
    TextView mTextCenter;

    private IconStartClickListener mIconStartClickListener;
    private IconEndClickListner mIconEndClickListner;

    public CustomToolbar setBackground(int color){
        mToolbar.setBackgroundColor(color);
        return this;
    }

    public CustomToolbar setIconStart(int resId){
        mIconStart.setVisibility(View.VISIBLE);
        mIconStart.setImageResource(resId);
        return this;
    }

    public CustomToolbar setIconEnd(int resId){
        mIconEnd.setVisibility(View.VISIBLE);
        mIconEnd.setImageResource(resId);
        return this;
    }

    public CustomToolbar setTextCenter(String text){
        mTextCenter.setText(text);
        return this;
    }

    public CustomToolbar setIconStarClickListener (IconStartClickListener iconStarClickListener){
        mIconStartClickListener = iconStarClickListener;
        return this;
    }

    public CustomToolbar setIconEndClickListener (IconEndClickListner iconEndClickListener){
        mIconEndClickListner = iconEndClickListener;
        return this;
    }

    @Click({R.id.toolbar_icon_start, R.id.toolbar_icon_end})
    void onClick(View v){
        switch (v.getId()){
            case R.id.toolbar_icon_start:
                mIconStartClickListener.onIconStartClick();
                break;
            case R.id.toolbar_icon_end:
                mIconEndClickListner.onIconEndClick();
                break;
        }
    }

    public interface IconStartClickListener {
        void onIconStartClick();
    }

    public interface IconEndClickListner{
        void onIconEndClick();
    }
}
