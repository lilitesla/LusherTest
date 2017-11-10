package lili.tesla.lushertest.data;

import lili.tesla.lushertest.presentation.application.App;

/**
 * Created by Лилия on 09.11.2017.
 */

public class Test2 {

    private BasePair pPositive;
    private BasePair pX;
    private BasePair pNeitral;
    private BasePair pNegativ;
    private BasePair pPosNeg;

    private int colExlamation;
    private String sExlamation;

    public Test2(String indexPositive, String indexX, String indexNeitral, String indexNegativ, String indexPosNeg, int iColExlamation) {

        pPositive = new BasePair(indexPositive);
        pX = new BasePair(indexX);
        pNeitral = new BasePair(indexNeitral);
        pNegativ = new BasePair(indexNegativ);
        pPosNeg = new BasePair(indexPosNeg);

        colExlamation = iColExlamation;
    }
    
    public void FillTest() {

        pPositive.setDescription(App.dataBaseAccess.getPositive(pPositive.getIndexId()) + "<br><br>");
        pX.setDescription(App.dataBaseAccess.getX(pX.getIndexId()) + "<br><br>");
        pNeitral.setDescription(App.dataBaseAccess.getNeitral(pNeitral.getIndexId()) + "<br><br>");
        pNegativ.setDescription(App.dataBaseAccess.getNegative(pNegativ.getIndexId()) + "<br><br>");
        pPosNeg.setDescription(App.dataBaseAccess.getPositiveNegative(pPosNeg.getIndexId()) + "<br><br>");

        sExlamation = "<b><FONT COLOR=#00BCD4>Показатель тревожности: </font></b>" + colExlamation + " из 12<br><br>";
    }

    public String getResultText() {
        return  pPositive.getDescription() + pX.getDescription() + pNeitral.getDescription() + pNegativ.getDescription() + pPosNeg.getDescription();
    }

    public String getExlamation() {
        return sExlamation;
    }

}
