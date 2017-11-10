package lili.tesla.lushertest.presentation.screen.description.presenter;

import lili.tesla.lushertest.presentation.application.App;
import lili.tesla.lushertest.presentation.screen.base.BasePresenter;
import lili.tesla.lushertest.presentation.screen.description.view.DescriptionView;

/**
 * Created by Лилия on 01.11.2017.
 */

public class DescriptionPresenter extends BasePresenter<DescriptionView> {

    public void startTable1Screen() {

        for (int i = 0; i < 8; i ++) {
            if (i < 5) {App.arrayTab1[i] = -1; }
            App.arrayTab2_1[i] = -1;
            App.arrayTab2_2[i] = -2;
        }

        for (int i = 0; i < 6; i++)
            for (int j = 0; j < 4; j++) {
                App.arrayTab3[i][j] = -1;
            }

        mView.startTable1Screen();
    }
}
