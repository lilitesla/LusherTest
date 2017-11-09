package lili.tesla.lushertest.presentation.screen.table2.presenter;

import lili.tesla.lushertest.presentation.screen.base.BasePresenter;
import lili.tesla.lushertest.presentation.screen.table2.view.Table2View;

/**
 * Created by Лилия on 01.11.2017.
 */

public class Table2Presenter extends BasePresenter<Table2View> {

    public void setImagesColors() {
        mView.setImagesColors();
    }

    public void showTable3Screen() { mView.showTable3Screen(); }

    public void showResultScreen() { mView.showResultScreen(); }

}