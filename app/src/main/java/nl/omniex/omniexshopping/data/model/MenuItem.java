package nl.omniex.omniexshopping.data.model;

public class MenuItem {

    private String mTitle;
    private int mResId;

    public MenuItem(String title, int resId) {
        mTitle = title;
        mResId = resId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public int getResId() {
        return mResId;
    }

    public void setResId(int resId) {
        mResId = resId;
    }
}
