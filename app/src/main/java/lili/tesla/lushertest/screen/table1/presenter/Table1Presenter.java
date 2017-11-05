package lili.tesla.lushertest.screen.table1.presenter;

import lili.tesla.lushertest.screen.base.BasePresenter;
import lili.tesla.lushertest.screen.table1.view.Table1View;

/**
 * Created by Лилия on 01.11.2017.
 */

public class Table1Presenter extends BasePresenter<Table1View> {

    public void setImagesColors() {
        mView.setImagesColors();
    }

    public void showTable2Screen() { mView.showTable2Screen(); }

}