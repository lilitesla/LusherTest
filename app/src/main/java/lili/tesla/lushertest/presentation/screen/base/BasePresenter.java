package lili.tesla.lushertest.presentation.screen.base;

/**
 * Created by Лилия on 01.11.2017.
 */

public abstract class BasePresenter<View> {

    protected View mView;

    public void setView(View view) {
        mView = view;
    }

    public void destroy() {
        mView = null;
    }
}
