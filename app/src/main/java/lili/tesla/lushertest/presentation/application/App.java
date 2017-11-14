package lili.tesla.lushertest.presentation.application;

import android.app.Application;

import com.facebook.stetho.Stetho;

import lili.tesla.lushertest.BuildConfig;
import lili.tesla.lushertest.data.database.DataBaseAccess;

/**
 * Created by Лилия on 06.11.2017.
 */

public class App extends Application {

    private static App instance;
    public static int[] arrayTab1;
    public static int[] arrayTab2_1;
    public static int[] arrayTab2_2;
    public static int[][] arrayTab3;

    public static int fragmentPosition;

    public static DataBaseAccess dataBaseAccess;


    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            stethoInit();
        }

        arrayTab1 = new int[5];
        arrayTab2_1 = new int[8];
        arrayTab2_2 = new int[8];
        arrayTab3 = new int[6][4];

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                App.arrayTab3[i][j] = 0;
            }
        }

        fragmentPosition = 0;

        dataBaseAccess = new DataBaseAccess(this);
    }

    public static App getInstance() {
        return instance;
    }

    //процедура для просмотра базы с компа
    private void stethoInit() {
        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this)).build());
    }
}
