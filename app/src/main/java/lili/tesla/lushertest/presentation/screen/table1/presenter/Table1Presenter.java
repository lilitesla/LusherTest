package lili.tesla.lushertest.presentation.screen.table1.presenter;

import lili.tesla.lushertest.presentation.application.App;
import lili.tesla.lushertest.presentation.screen.base.BasePresenter;
import lili.tesla.lushertest.presentation.screen.table1.view.Table1View;

/**
 * Created by Лилия on 01.11.2017.
 */

public class Table1Presenter extends BasePresenter<Table1View> {

    public int clickCount = 0;
    public int sumNum = 10;

    public void setImagesColors() {
        mView.setImagesColors();
    }

    public void setImageVisible(int num) {

        mView.setImageVisible(num);
        App.arrayTab1[clickCount] = num;
        sumNum -= num;

        if (clickCount == 3) {
            App.arrayTab1[4] = sumNum;
            mView.showTable2Screen();
        }

        clickCount ++;
    }

    public void setImagesVisible() {
        mView.setImagesVisible();
    }



}