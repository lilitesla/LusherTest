package lili.tesla.lushertest.results.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import lili.tesla.lushertest.R;
import lili.tesla.lushertest.base.BaseActivity;

public class ResultActivity extends BaseActivity implements ResultView {

    public static void start(Context context) {
        Intent intent = new Intent(context, ResultActivity.class);
        Bundle bundle = new Bundle();
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
    }
}
