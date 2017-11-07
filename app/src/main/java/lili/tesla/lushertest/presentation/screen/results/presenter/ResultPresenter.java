package lili.tesla.lushertest.presentation.screen.results.presenter;

import lili.tesla.lushertest.presentation.application.App;
import lili.tesla.lushertest.presentation.screen.base.BasePresenter;
import lili.tesla.lushertest.presentation.screen.results.view.ResultView;

/**
 * Created by Лилия on 05.11.2017.
 */

public class ResultPresenter extends BasePresenter<ResultView> {

    public void showPositiveNegativeResult(String sAchromatic, String sPositive, String sX, String sNeitral, String sNegative, String sPosNeg, int colExclamation,
            String sMainColor, String sBlueColor, String sGreenColor, String sRedColor, String sYellowColor) {

        String[] str = new String[1];

        str[0] = sAchromatic;
        String achromaticResult = "<b>Характеристика общего настроения:</b> \n" +
                App.dataBaseAccess.getAchromatic(str);

        str[0] = sPositive;
        String positiveResult = "<b>Желаемые цели и средства эмоционального поведения, устремления и защитное эмоциональное поведение:</b> \n" +
                App.dataBaseAccess.getPositive(str);

        str[0] = sX;
        String xResult = "<b>Существующее эмоциональное положение, текущее состояние, собственно настрой, уместное эмоциональное поведение:</b> \n" +
                App.dataBaseAccess.getX(str);

        str[0] = sNeitral;
        String neitralResult = "<b>Сдерживаемые качества, временно утраченные свойства, отложенные возможности, ограничиваемые, воспринимаемые как неуместные и находящиеся в резерве:</b> \n" +
                App.dataBaseAccess.getNeitral(str);

        str[0] = sNegative;
        String negativeResult = "<b>Источники неосознаваемой тревожности, потребности, затормаживаемые ввиду нецелесообразности:</b> \n" +
                App.dataBaseAccess.getNegative(str);

        str[0] = sPosNeg;
        String posNegResult = "<b>Актуальная эмоциональная проблема:</b> \n" +
                App.dataBaseAccess.getPositiveNegative(str);

        String sColExclamation = "<b>Уровень тревожности:</b> " + colExclamation + " из 12";

        str[0] = sMainColor;
        String mainColorResult = "<b>Стремления, мотивированные самопониманием:</b> \n" +
                App.dataBaseAccess.getMainColors(str);

        str[0] = sBlueColor;
        String blueColorResult =  "<b>Эмоциональное отношение к высокозначимым лицам:</b> \n" +
                App.dataBaseAccess.getBlueColors(str);

        str[0] = sGreenColor;
        String greenColorResult = "<b>Характеристика воли и самооценка:</b> \n" +
                App.dataBaseAccess.getGreenColors(str);

        str[0] = sRedColor;
        String redColorResult = "<b>Возбудимость и импульсивность:</b> \n" +
                App.dataBaseAccess.getRedColors(str);

        str[0] = sYellowColor;
        String yellowColorResult  = "<b>Ожидания и отношение к окружению:</b> \n" +
                App.dataBaseAccess.getYellowColors(str);

        mView.showResult (achromaticResult, positiveResult, xResult, neitralResult, negativeResult, posNegResult, sColExclamation,
                mainColorResult, blueColorResult, greenColorResult, redColorResult, yellowColorResult);

    }

}
