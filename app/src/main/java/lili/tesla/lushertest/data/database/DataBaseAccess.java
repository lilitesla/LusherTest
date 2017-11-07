package lili.tesla.lushertest.data.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Лилия on 06.11.2017.
 */

public class DataBaseAccess {

    private static DataBaseAccess instance;

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

    public String getPositive(String[] positiveIndex) {
        open();
        Cursor cursor = database.rawQuery("SELECT positive_pair, pos_star FROM Table2_pairs WHERE index_id=?", positiveIndex);
        cursor.moveToFirst();
        String result = cursor.getString(0);
        int colStar = cursor.getInt(1);
        if (colStar > 0) {
            result += " <b><FONT COLOR=RED>";
            for (int i = 0; i < colStar; i ++) {
                result += "<b>*</b>";
            }
            result += "</font><b>";
        }

        cursor.close();
        close();
        return result;
    }

    public String getX(String[] xIndex) {
        open();
        Cursor cursor = database.rawQuery("SELECT x_pair, x_star FROM Table2_pairs WHERE index_id=?", xIndex);
        cursor.moveToFirst();
        String result = cursor.getString(0);
        int colStar = cursor.getInt(1);
        if (colStar > 0) {
            result += " <b><FONT COLOR=RED>";
            for (int i = 0; i < colStar; i ++) {
                result += "<b>*</b>";
            }
            result += "</font><b>";
        }
        cursor.close();
        close();
        return result;
    }

    public String getNeitral(String[] neitralIndex) {
        open();
        Cursor cursor = database.rawQuery("SELECT neitral_pair, neitr_star FROM Table2_pairs WHERE index_id=?", neitralIndex);
        cursor.moveToFirst();
        String result = cursor.getString(0);
        int colStar = cursor.getInt(1);
        if (colStar > 0) {
            result += " <b><FONT COLOR=RED>";
            for (int i = 0; i < colStar; i ++) {
                result += "<b>*</b>";
            }
            result += "</font><b>";
        }
        cursor.close();
        close();
        return result;
    }

    public String getNegative(String[] negativeIndex) {
        open();
        Cursor cursor = database.rawQuery("SELECT negative_pair, neg_star FROM Table2_pairs WHERE index_id=?", negativeIndex);
        cursor.moveToFirst();
        String result = cursor.getString(0);
        int colStar = cursor.getInt(1);
        if (colStar > 0) {
            result += " <b><FONT COLOR=RED>";
            for (int i = 0; i < colStar; i ++) {
                result += "<b>*</b>";
            }
            result += "</font><b>";
        }
        cursor.close();
        close();
        return result;
    }

    public String getPositiveNegative(String[] posNegIndex) {
        open();
        Cursor cursor = database.rawQuery("SELECT pos_neg_pair, pos_neg_star FROM Table2_pairs WHERE index_id=?", posNegIndex);
        cursor.moveToFirst();
        String result = cursor.getString(0);
        int colStar = cursor.getInt(1);
        if (colStar > 0) {
            result += " <b><FONT COLOR=RED>";
            for (int i = 0; i < colStar; i ++) {
                result += "<b>*</b>";
            }
            result += "</font><b>";
        }
        cursor.close();
        close();
        return result;
    }

    public String getAchromatic(String[] achromaticIndex) {
        open();
        Cursor cursor = database.rawQuery("SELECT caption, description, stars FROM Table1_achromatic WHERE index_id=?", achromaticIndex);
        cursor.moveToFirst();
        String result = cursor.getString(0) + "\n" + cursor.getString(1);
        int colStar = cursor.getInt(2);
        if (colStar > 0) {
            result += " <b><FONT COLOR=RED>";
            for (int i = 0; i < colStar; i ++) {
                result += "<b>*</b>";
            }
            result += "</font><b>";
        }
        cursor.close();
        close();
        return result;
    }

    public String getMainColors(String[] mainIndex) {
        open();
        Cursor cursor = database.rawQuery("SELECT main_colors FROM Table3_fourth WHERE index_id=?", mainIndex);
        cursor.moveToFirst();
        String result = cursor.getString(0);
        cursor.close();
        close();
        return result;
    }

    public String getBlueColors(String[] blueIndex) {
        open();
        Cursor cursor = database.rawQuery("SELECT blue_colors FROM Table3_fourth WHERE index_id=?", blueIndex);
        cursor.moveToFirst();
        String result = cursor.getString(0);
        cursor.close();
        close();
        return result;
    }

    public String getGreenColors(String[] greenIndex) {
        open();
        Cursor cursor = database.rawQuery("SELECT green_colors FROM Table3_fourth WHERE index_id=?", greenIndex);
        cursor.moveToFirst();
        String result = cursor.getString(0);
        cursor.close();
        close();
        return result;
    }

    public String getRedColors(String[] redIndex) {
        open();
        Cursor cursor = database.rawQuery("SELECT red_colors FROM Table3_fourth WHERE index_id=?", redIndex);
        cursor.moveToFirst();
        String result = cursor.getString(0);
        cursor.close();
        close();
        return result;
    }

    public String getYellowColors(String[] yellowIndex) {
        open();
        Cursor cursor = database.rawQuery("SELECT yellow_colors FROM Table3_fourth WHERE index_id=?", yellowIndex);
        cursor.moveToFirst();
        String result = cursor.getString(0);
        cursor.close();
        close();
        return result;
    }



}
