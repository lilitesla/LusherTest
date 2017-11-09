package lili.tesla.lushertest.data;

import lili.tesla.lushertest.presentation.application.App;

/**
 * Created by Лилия on 09.11.2017.
 */

public class Test1 {
    private BasePair achromaticPair;

    public Test1(String indexId) {
        achromaticPair = new BasePair(indexId);
    }

    public void FillTest() {
        achromaticPair.setDescription(App.dataBaseAccess.getAchromatic(achromaticPair.getIndexId()) + "<br><br>");
    }

    public String getResultText() {
        return achromaticPair.getDescription();
    }
}
