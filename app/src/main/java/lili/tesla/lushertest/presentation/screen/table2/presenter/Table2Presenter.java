package lili.tesla.lushertest.presentation.screen.table2.presenter;

import lili.tesla.lushertest.presentation.application.App;
import lili.tesla.lushertest.presentation.screen.base.BasePresenter;
import lili.tesla.lushertest.presentation.screen.table2.view.Table2View;

/**
 * Created by Лилия on 01.11.2017.
 */

public class Table2Presenter extends BasePresenter<Table2View> {

    public int clickCount = 0;
    public int sumNum = 28;

    public void setImagesColors() {
        mView.setImagesColors();
    }

    public void setImagesVisible() { mView.setImagesVisible(); }

    public void setImageVisible(int num, int queryNum) {

        mView.setImageVisible(num);

        if (queryNum == 0) {
            App.arrayTab2_1[clickCount] = num;
            sumNum -= num;
        } else {
            App.arrayTab2_2[clickCount] = num;
            sumNum -= num;
        }

        if (clickCount == 6) {
            if (queryNum == 0) {
                App.arrayTab2_1[7] = sumNum;
                mView.showTable3Screen();

            } else {
                App.arrayTab2_2[7] = sumNum;
                mView.showResultScreen();
            }
        }

        clickCount ++;
    }

}
