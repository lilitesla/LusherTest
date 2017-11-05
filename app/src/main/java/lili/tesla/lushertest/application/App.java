package lili.tesla.lushertest.application;

import android.app.Application;

import com.facebook.stetho.Stetho;

import lili.tesla.lushertest.BuildConfig;

/**
 * Created by Лилия on 06.11.2017.
 */

public class App extends Application {

    private static App instance;
    public static int[] arrayTab1;
    public static int[] arrayTab2_1;
    public static int[] arrayTab2_2;
    public static int[][] arrayTab3;

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            stethoInit();
        }

        arrayTab1 = new int[3];
        arrayTab2_1 = new int[6];
        arrayTab2_2 = new int[6];
        arrayTab3 = new int[6][4];
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
