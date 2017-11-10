package lili.tesla.lushertest.presentation.screen.results.presenter;

import lili.tesla.lushertest.data.Test1;
import lili.tesla.lushertest.data.Test2;
import lili.tesla.lushertest.data.Test3;
import lili.tesla.lushertest.presentation.application.App;
import lili.tesla.lushertest.presentation.screen.base.BasePresenter;
import lili.tesla.lushertest.presentation.screen.results.view.ResultView;

import static java.lang.Math.abs;

/**
 * Created by Лилия on 05.11.2017.
 */

public class ResultPresenter extends BasePresenter<ResultView> {

    private String[][] arrayTab2_results;
    private String indexCoub;
    private int colExclamation;  //количество восклицательных знаков
    private boolean isTest2Calc = false;
    private boolean isTest3Calc = false;

    public void showPositiveNegativeResult() {

        Test1 test1 = new Test1(App.arrayTab1[0] + "" + App.arrayTab1[1] + "" + App.arrayTab1[4]);

        Test2 test2 = new Test2(
                App.arrayTab2_2[0] + "" + App.arrayTab2_2[1],
                App.arrayTab2_2[2] + "" + App.arrayTab2_2[3],
                App.arrayTab2_2[4] + "" + App.arrayTab2_2[5],
                App.arrayTab2_2[6] + "" + App.arrayTab2_2[7],
                App.arrayTab2_2[0] + "" + App.arrayTab2_2[7],
                colExclamation );

        Test3 test3 = new Test3(
                App.arrayTab3[0][0] + "" + App.arrayTab3[0][1] + "" + App.arrayTab3[0][2] + "" + App.arrayTab3[0][3],
                App.arrayTab3[1][0] + "" + App.arrayTab3[1][1] + "" + App.arrayTab3[1][2] + "" + App.arrayTab3[1][3],
                App.arrayTab3[2][0] + "" + App.arrayTab3[2][1] + "" + App.arrayTab3[2][2] + "" + App.arrayTab3[2][3],
                App.arrayTab3[3][0] + "" + App.arrayTab3[3][1] + "" + App.arrayTab3[3][2] + "" + App.arrayTab3[3][3],
                App.arrayTab3[4][0] + "" + App.arrayTab3[4][1] + "" + App.arrayTab3[4][2] + "" + App.arrayTab3[4][3],
                indexCoub );

        test1.FillTest();
        test2.FillTest();
        test3.FillTest();

        mView.showResult (test1, test2, test3);

    }

    public void calcResultTab2() {

        if (! isTest2Calc) {

            arrayTab2_results = new String[4][8];

            for (int i = 0; i < 4; i++)
                for (int j = 0; j < 8; j++) {
                    arrayTab2_results[i][j] = "";
                }

            /*arrayTab2_results[0][0] = arrayTab2_results[0][1] = "+";
            arrayTab2_results[0][2] = arrayTab2_results[0][3] = "x";
            arrayTab2_results[0][4] = arrayTab2_results[0][5] = "=";
            arrayTab2_results[0][6] = arrayTab2_results[0][7] = "-";
            arrayTab2_results[3][0] = "+";
            arrayTab2_results[3][7] = "-";*/

            // если неосновные цвета расположены на первых трех позициях, обозначаем их и любой цвет перед ними C
            // неосновному цвету на 1 позиции ставим !!!, на 2 - !!, на 1 - !

            if ((App.arrayTab2_2[2] == 0) || (App.arrayTab2_2[2] > 5)) {
                /*arrayTab2_results[1][2] = "C";
                arrayTab2_results[3][2] = "+";

                arrayTab2_results[1][1] = "C";
                arrayTab2_results[3][1] = "+";*/

                arrayTab2_results[2][2] = "!";
            }

            if ((App.arrayTab2_2[1] == 0) || (App.arrayTab2_2[1] > 5)) {
               /* arrayTab2_results[1][1] = "C";
                arrayTab2_results[3][1] = "+";

                arrayTab2_results[1][0] = "C";
                arrayTab2_results[3][0] = "+";*/

                arrayTab2_results[2][1] = "!!";
            }

            if ((App.arrayTab2_2[0] == 0) || (App.arrayTab2_2[0] > 5)) {
               /* arrayTab2_results[1][0] = "C";
                arrayTab2_results[3][0] = "+";*/

                arrayTab2_results[2][0] = "!!!";
            }

            // если есть хотя бы один C - последний цвет в ряду обозначаем А
            if ((arrayTab2_results[1][0] != "") || (arrayTab2_results[1][1] != "") || (arrayTab2_results[1][2] != "")) {
                arrayTab2_results[1][7] = "A";
            }

            // если основные цвета расположены на последних 3 позициях, обозначаем их и любой цвет после них А
            // основному цвету на 8 позиции ставим !!!, на 7 - !!, на 6 - !
            if ((App.arrayTab2_2[5] > 0) && (App.arrayTab2_2[5] < 5)) {
               /* arrayTab2_results[1][5] = "A";
                arrayTab2_results[3][5] = "-";

                arrayTab2_results[1][6] = "A";
                arrayTab2_results[3][6] = "-";

                arrayTab2_results[1][7] = "A";
                arrayTab2_results[3][7] = "-";*/

                arrayTab2_results[2][5] = "!";
            }

            if ((App.arrayTab2_2[6] > 0) && (App.arrayTab2_2[6] < 5)) {
              /*  arrayTab2_results[1][6] = "A";
                arrayTab2_results[3][6] = "-";

                arrayTab2_results[1][7] = "A";
                arrayTab2_results[3][7] = "-"; */

                arrayTab2_results[2][6] = "!!";
            }

            if ((App.arrayTab2_2[7] > 0) && (App.arrayTab2_2[7] < 5)) {
               /* arrayTab2_results[1][7] = "A";
                arrayTab2_results[3][7] = "-"; */

                arrayTab2_results[2][7] = "!!!";
            }

            // если есть хотя бы один А - первый цвет в ряду обозначаем С
            /*if ((arrayTab2_results[1][7] != "") || (arrayTab2_results[1][6] != "") || (arrayTab2_results[1][5] != ""))
            {  arrayTab2_results[1][0] = "C";
            }*/

            colExclamation = 0;
            for (int i = 0; i < 8; i++) {
                colExclamation += arrayTab2_results[2][i].length();
            }

            isTest2Calc = true;
        }


    }

    public void calcResultTab3() {

        if (! isTest3Calc) {

            String[] arrayTab3_1 = new String[4];
            for (int i = 0; i < 4; i++) {
                arrayTab3_1[i] = "";
            }

            int iCol0 = 0;
            int iCol3 = 0;

            for (int i = 0; i < 4; i++) {

                App.arrayTab3[5][i] = 0;

                for (int j = 1; j < 5; j++) {
                    App.arrayTab3[5][i] += App.arrayTab3[j][i];

                    if (App.arrayTab3[j][i] == 0) {  iCol0++;  }
                    if (App.arrayTab3[j][i] == 3) {  iCol3++;  }
                }

                if (iCol0 == 3) {  App.arrayTab3[5][i] = 0;  }
                if (iCol3 == 3) {  App.arrayTab3[5][i] = 3;  }

                if ((abs((App.arrayTab3[1][i] + App.arrayTab3[2][i]) - (App.arrayTab3[3][i] + App.arrayTab3[4][i])) >= 4) ||
                        (abs((App.arrayTab3[2][i] + App.arrayTab3[3][i]) - (App.arrayTab3[1][i] + App.arrayTab3[4][i])) >= 4) ||
                        (abs((App.arrayTab3[1][i] + App.arrayTab3[3][i]) - (App.arrayTab3[2][i] + App.arrayTab3[4][i])) >= 4)) {
                    App.arrayTab3[5][i] = 6;
                    arrayTab3_1[i] = "+-";
                }
            }

            indexCoub = "";

            if (App.arrayTab3[5][0] < 3) {
                arrayTab3_1[0] = "-";
                indexCoub += 1;
            }
            if (App.arrayTab3[5][0] > 8) {
                arrayTab3_1[0] = "+";
                indexCoub += 1;
            }

            if (App.arrayTab3[5][1] < 3) {
                arrayTab3_1[1] = "-";
                indexCoub += 2;
            }
            if (App.arrayTab3[5][1] > 8) {
                arrayTab3_1[1] = "+";
                indexCoub += 2;
            }

            if (App.arrayTab3[5][2] < 5) {
                arrayTab3_1[2] = "-";
                indexCoub += 3;
            }
            if (App.arrayTab3[5][2] > 10) {
                arrayTab3_1[2] = "+";
                indexCoub += 3;
            }

            if (App.arrayTab3[5][3] < 3) {
                arrayTab3_1[3] = "-";
                indexCoub += 4;
            }
            if (App.arrayTab3[5][3] > 9) {
                arrayTab3_1[3] = "+";
                indexCoub += 4;
            }

            if (indexCoub.length() != 2) {
                indexCoub = "0";
            }

        }

    }
}
