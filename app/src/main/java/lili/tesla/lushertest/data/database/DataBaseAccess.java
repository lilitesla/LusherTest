package lili.tesla.lushertest.data.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import lili.tesla.lushertest.R;

/**
 * Created by Лилия on 06.11.2017.
 */

public class DataBaseAccess {

    private static DataBaseAccess instance;
    private final String sTextColor = "#00BCD4";

    public static DataBaseAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DataBaseAccess(context);
        }
        return instance;
    }

    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;

    public DataBaseAccess(Context context) {
        this.openHelper = new DataBaseOpenHelper(context);
    }

    private void open() {
        this.database = openHelper.getWritableDatabase();
    }

    private void close() {
        if (database != null) {
            this.database.close();
        }
    }

    //Test 1

    public String getAchromatic(String[] achromaticIndex) {
        open();
        Cursor cursor = database.rawQuery("SELECT caption, description, stars FROM Lusher_Test_Table1_achromatic WHERE index_id=?", achromaticIndex);
        cursor.moveToFirst();
        String result = "<b><FONT COLOR=" + sTextColor + ">Характеристика общего настроения</font></b><br><i>"
                + cursor.getString(0) + "</i><br>" + cursor.getString(1);
        int colStar = cursor.getInt(2);
        if (colStar > 0) {
            result += " <b><FONT COLOR=RED>";
            for (int i = 0; i < colStar; i ++) {
                result += "<b>*</b>";
            }
            result += "</font></b>";
        }
        cursor.close();
        close();
        return result;
    }

    //Test 2

    public String getPositive(String[] positiveIndex) {
        open();
        Cursor cursor = database.rawQuery("SELECT positive_pair, pos_star FROM Lusher_Test_Table2_pairs WHERE index_id=?", positiveIndex);
        cursor.moveToFirst();
        String result = "<b><FONT COLOR=" + sTextColor + ">Желаемые цели и средства эмоционального поведения; устремления и защитное эмоциональное поведение</font></b><br>"
                + cursor.getString(0);
        int colStar = cursor.getInt(1);
        if (colStar > 0) {
            result += " <b><FONT COLOR=RED>";
            for (int i = 0; i < colStar; i ++) {
                result += "<b>*</b>";
            }
            result += "</font></b>";
        }

        cursor.close();
        close();
        return result;
    }

    public String getX(String[] xIndex) {
        open();
        Cursor cursor = database.rawQuery("SELECT x_pair, x_star FROM Lusher_Test_Table2_pairs WHERE index_id=?", xIndex);
        cursor.moveToFirst();
        String result = "<b><FONT COLOR=" + sTextColor + ">Существующее эмоциональное положение, текущее состояние, собственно настрой, уместное эмоциональное поведение</font></b><br>"
                + cursor.getString(0);
        int colStar = cursor.getInt(1);
        if (colStar > 0) {
            result += " <b><FONT COLOR=RED>";
            for (int i = 0; i < colStar; i ++) {
                result += "<b>*</b>";
            }
            result += "</font></b>";
        }
        cursor.close();
        close();
        return result;
    }

    public String getNeitral(String[] neitralIndex) {
        open();
        Cursor cursor = database.rawQuery("SELECT neitral_pair, neitr_star FROM Lusher_Test_Table2_pairs WHERE index_id=?", neitralIndex);
        cursor.moveToFirst();
        String result = "<b><FONT COLOR=" + sTextColor + ">Сдерживаемые качества, временно утраченные свойства, отложенные возможности, ограничиваемые, воспринимаемые как неуместные и находящиеся в резерве</font></b><br>"
                + cursor.getString(0);
        int colStar = cursor.getInt(1);
        if (colStar > 0) {
            result += " <b><FONT COLOR=RED>";
            for (int i = 0; i < colStar; i ++) {
                result += "<b>*</b>";
            }
            result += "</font></b>";
        }
        cursor.close();
        close();
        return result;
    }

    public String getNegative(String[] negativeIndex) {
        open();
        Cursor cursor = database.rawQuery("SELECT negative_pair, neg_star FROM Lusher_Test_Table2_pairs WHERE index_id=?", negativeIndex);
        cursor.moveToFirst();
        String result = "<b><FONT COLOR=" + sTextColor + ">Источники неосознаваемой тревожности; потребности, затормаживаемые ввиду нецелесообразности</font></b><br><br>"
                + cursor.getString(0);
        int colStar = cursor.getInt(1);
        if (colStar > 0) {
            result += " <b><FONT COLOR=RED>";
            for (int i = 0; i < colStar; i ++) {
                result += "<b>*</b>";
            }
            result += "</font></b>";
        }
        cursor.close();
        close();
        return result;
    }

    public String getPositiveNegative(String[] posNegIndex) {
        open();
        Cursor cursor = database.rawQuery("SELECT pos_neg_pair, pos_neg_star FROM Lusher_Test_Table2_pairs WHERE index_id=?", posNegIndex);
        cursor.moveToFirst();
        String result = "<b><FONT COLOR=" + sTextColor + ">Актуальная эмоциональная проблема</font></b><br>"
                + cursor.getString(0);
        int colStar = cursor.getInt(1);
        if (colStar > 0) {
            result += " <b><FONT COLOR=RED>";
            for (int i = 0; i < colStar; i ++) {
                result += "<b>*</b>";
            }
            result += "</font></b>";
        }
        cursor.close();
        close();
        return result;
    }

    // Test 3

    public String getMainColors(String[] mainIndex) {
        open();
        Cursor cursor = database.rawQuery("SELECT main_colors FROM Lusher_Test_Table3_fourth WHERE index_id=?", mainIndex);
        cursor.moveToFirst();
        String result = "<b><FONT COLOR=" + sTextColor + ">Стремления, мотивированные самопониманием</font></b><br>"
                + cursor.getString(0);
        cursor.close();
        close();
        return result;
    }

    public String getBlueColors(String[] blueIndex) {
        open();
        Cursor cursor = database.rawQuery("SELECT blue_colors FROM Lusher_Test_Table3_fourth WHERE index_id=?", blueIndex);
        cursor.moveToFirst();
        String result = "<b><FONT COLOR=" + sTextColor + ">Эмоциональное отношение к высокозначимым лицам</font></b><br>"
                + cursor.getString(0);
        cursor.close();
        close();
        return result;
    }

    public String getGreenColors(String[] greenIndex) {
        open();
        Cursor cursor = database.rawQuery("SELECT green_colors FROM Lusher_Test_Table3_fourth WHERE index_id=?", greenIndex);
        cursor.moveToFirst();
        String result = "<b><FONT COLOR=" + sTextColor + ">Характеристика воли и самооценка</font></b><br>"
                + cursor.getString(0);
        cursor.close();
        close();
        return result;
    }

    public String getRedColors(String[] redIndex) {
        open();
        Cursor cursor = database.rawQuery("SELECT red_colors FROM Lusher_Test_Table3_fourth WHERE index_id=?", redIndex);
        cursor.moveToFirst();
        String result = "<b><FONT COLOR=" + sTextColor + ">Возбудимость и импульсивность</font></b><br>"
                + cursor.getString(0);
        cursor.close();
        close();
        return result;
    }

    public String getYellowColors(String[] yellowIndex) {
        open();
        Cursor cursor = database.rawQuery("SELECT yellow_colors FROM Lusher_Test_Table3_fourth WHERE index_id=?", yellowIndex);
        cursor.moveToFirst();
        String result = "<b><FONT COLOR=" + sTextColor + ">Ожидания и отношение к окружению</font></b><br>"
                + cursor.getString(0);
        cursor.close();
        close();
        return result;
    }



    public String getNegPos(String[] indexId) {
        open();
        Cursor cursor = database.rawQuery("SELECT minus_plus FROM Lusher_Test_Table3_coub WHERE index_id=?", indexId);
        cursor.moveToFirst();
        String result = "<b><FONT COLOR=" + sTextColor + ">Компенсация</font></b><br>"
                + cursor.getString(0);
        cursor.close();
        close();
        return result;
    }

    public String getPosNeg(String[] indexId) {
        open();
        Cursor cursor = database.rawQuery("SELECT plus_minus FROM Lusher_Test_Table3_coub WHERE index_id=?", indexId);
        cursor.moveToFirst();
        String result = "<b><FONT COLOR=" + sTextColor + ">Причины конфликта</font></b><br>"
                + cursor.getString(0);
        cursor.close();
        close();
        return result;
    }

    public String getPosPos(String[] indexId) {
        open();
        Cursor cursor = database.rawQuery("SELECT plus_plus FROM Lusher_Test_Table3_coub WHERE index_id=?", indexId);
        cursor.moveToFirst();
        String result = "<b><FONT COLOR=" + sTextColor + ">Иллюзорное ожидание</font></b><br>"
                + cursor.getString(0);
        cursor.close();
        close();
        return result;
    }

    public String getNegNeg(String[] indexId) {
        open();
        Cursor cursor = database.rawQuery("SELECT minus_minus FROM Lusher_Test_Table3_coub WHERE index_id=?", indexId);
        cursor.moveToFirst();
        String result = "<b><FONT COLOR=" + sTextColor + ">Страх-защита</font></b><br>"
                + cursor.getString(0);
        cursor.close();
        close();
        return result;
    }


}
