package lili.tesla.lushertest.presentation.screen.table3.presenter;

import lili.tesla.lushertest.presentation.application.App;
import lili.tesla.lushertest.presentation.screen.table3.view.Table3View;
import lili.tesla.lushertest.presentation.screen.base.BasePresenter;

/**
 * Created by Лилия on 02.11.2017.
 */

public class Table3Presenter extends BasePresenter<Table3View> {

    public int testNum = 0;
    public int clickCount = 0;
    public boolean isSecondTry = false;
    public boolean isWasSecondTry = false;

    public void setImagesColors(int testNum) {
        mView.setImagesColors(testNum);
    }

    public void setImagesVisible(int testNum) { mView.setImagesVisible(testNum);}

    public void onImageClick(int num) {
        App.arrayTab3[testNum][num] ++;

        clickCount ++;

        if (clickCount <  6 ) {
            mView.setImagesVisible(clickCount);

        } else {
            if (!isSecondTry) {
                if (testNum < 4) {
                    startNewTest();
                } else {
                    isSecondTry = true;
                    testNum = 0;
                }
            }

            if (isSecondTry) {
                while ((testNum < 5)&&(isRightTest()||isWasSecondTry)) {
                    isWasSecondTry = false;
                    testNum ++;
                }
                if (testNum < 5) {
                    testNum --;
                    isWasSecondTry = true;
                    startNewTest();

                } else {
                    mView.showTable2Screen();

                }
            }
        }
    }

    public void startNewTest() {
        testNum ++;
        if (clickCount == 6) {
            clickCount = 0;
        }
        for (int i = 0; i < 4; i ++) {
            App.arrayTab3[testNum][i] = 0;
        }
        setImagesColors(testNum);
        setImagesVisible(clickCount);
    }

    private boolean isRightTest(){

        int[] counts = new int[4];

        for (int i = 0; i < 4; i ++) {
            counts[i] = 0;
        }

        for (int i = 0; i < 4; i ++) {
            counts[App.arrayTab3[testNum][i]] ++;
        }

        if ((counts[0] > 1)||(counts[1] > 1) ||(counts[2] > 1) ||(counts[3] > 1)) {
            return false;
        } else {
            return true;
        }
    }

}