package lili.tesla.lushertest.screen.table3.presenter;

import lili.tesla.lushertest.screen.table3.view.Table3View;
import lili.tesla.lushertest.screen.base.BasePresenter;

/**
 * Created by Лилия on 02.11.2017.
 */

public class Table3Presenter extends BasePresenter<Table3View> {

    public void showTable2Activity() { mView.showTable2Screen(); }

    public void setImagesColors(int testNum) {
        mView.setImagesColors(testNum);
    }

    public void setImagesVisible(int testNum) { mView.setImagesVisible(testNum);}

}