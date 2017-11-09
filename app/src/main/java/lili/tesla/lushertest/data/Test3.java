package lili.tesla.lushertest.data;

import lili.tesla.lushertest.presentation.application.App;

/**
 * Created by Лилия on 09.11.2017.
 */

public class Test3 {

    private BasePair pMain;
    private BasePair pBlue;
    private BasePair pGreen;
    private BasePair pRed;
    private BasePair pYellow;

    private BasePair pCoubNegPos;
    private BasePair pCoubPosNeg;
    private BasePair pCoubPosPos;
    private BasePair pCoubNegNeg;


    public Test3(String indexMain, String indexBlue, String indexGreen, String indexRed, String indexYellow, String indexCoub) {
        pMain = new BasePair(indexMain);
        pBlue = new BasePair(indexBlue);
        pGreen = new BasePair(indexGreen);
        pRed = new BasePair(indexRed);
        pYellow = new BasePair(indexYellow);

        pCoubNegPos = new BasePair(indexCoub);
        pCoubPosNeg = new BasePair(indexCoub);
        pCoubPosPos = new BasePair(indexCoub);
        pCoubNegNeg = new BasePair(indexCoub);
    }

    public void FillTest() {
        if (pMain.isIndexTrue()) {
            pMain.setDescription(App.dataBaseAccess.getMainColors(pMain.getIndexId()) + "<br><br>");
        }
        if (pBlue.isIndexTrue()) {
            pBlue.setDescription(App.dataBaseAccess.getBlueColors(pBlue.getIndexId()) + "<br><br>");
        }
        if (pGreen.isIndexTrue()) {
            pGreen.setDescription(App.dataBaseAccess.getGreenColors(pGreen.getIndexId()) + "<br><br>");
        }
        if (pRed.isIndexTrue()) {
            pRed.setDescription(App.dataBaseAccess.getRedColors(pRed.getIndexId()) + "<br><br>");
        }
        if (pYellow.isIndexTrue()) {
            pYellow.setDescription(App.dataBaseAccess.getYellowColors(pYellow.getIndexId()) + "<br><br>");
        }

        if (pCoubNegPos.getIndex() != "0") {
            pCoubNegPos.setDescription(App.dataBaseAccess.getNegPos(pCoubNegPos.getIndexId()) + "<br><br>");
            pCoubPosNeg.setDescription(App.dataBaseAccess.getPosNeg(pCoubPosNeg.getIndexId()) + "<br><br>");
            pCoubPosPos.setDescription(App.dataBaseAccess.getPosPos(pCoubPosPos.getIndexId()) + "<br><br>");
            pCoubNegNeg.setDescription(App.dataBaseAccess.getNegNeg(pCoubNegNeg.getIndexId()) + "<br><br>");
        }

    }

    public String getColorsResultText() {
        return pMain.getDescription() + pBlue.getDescription() + pGreen.getDescription() + pRed.getDescription() + pYellow.getDescription();
    }

    public String getCoubResultText() {
        return pCoubNegPos.getDescription() + pCoubPosNeg.getDescription() + pCoubPosPos.getDescription() + pCoubNegNeg.getDescription();
    }

}
