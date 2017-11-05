package lili.tesla.lushertest.table1.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;
import lili.tesla.lushertest.R;
import lili.tesla.lushertest.base.BaseActivity;
import lili.tesla.lushertest.table1.presenter.Table1Presenter;
import lili.tesla.lushertest.table2.view.Table2Activity;

public class Table1Activity extends BaseActivity implements Table1View, View.OnClickListener {

    public static void start(Context context ) {
        Intent intent = new Intent(context, Table1Activity.class);
        Bundle bundle = new Bundle();
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    private Table1Presenter mPresenter;
    private int clickCount;
    private int[] arrayTab1;

    @BindView(R.id.image0_table1) ImageView mImage0Tab1;
    @BindView(R.id.image1_table1) ImageView mImage1Tab1;
    @BindView(R.id.image2_table1) ImageView mImage2Tab1;
    @BindView(R.id.image3_table1) ImageView mImage3Tab1;
    @BindView(R.id.image4_table1) ImageView mImage4Tab1;

    @BindView(R.id.textViewTable1_description) TextView mTextTab1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table1);

        ButterKnife.bind(this);
        mPresenter = new Table1Presenter();
        mPresenter.setView(this);
        mPresenter.setImagesColors();

        mImage0Tab1.setOnClickListener(this);
        mImage1Tab1.setOnClickListener(this);
        mImage2Tab1.setOnClickListener(this);
        mImage3Tab1.setOnClickListener(this);
        mImage4Tab1.setOnClickListener(this);

        clickCount = 0;
        arrayTab1 = new int[3];
    }

    @Override
    public void setImagesColors() {
        mImage0Tab1.setBackgroundResource(R.color.gray);
        mImage1Tab1.setBackgroundResource(R.color.darkGray);
        mImage2Tab1.setBackgroundResource(R.color.black);
        mImage3Tab1.setBackgroundResource(R.color.lightGray);
        mImage4Tab1.setBackgroundResource(R.drawable.borders);
    }

    @Override
    public void showTable2Screen() {
        Table2Activity.start(this, 0);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.image0_table1: {
                mImage0Tab1.setVisibility(View.INVISIBLE);
                onClickAction(0);
                break;
            }
            case R.id.image1_table1: {
                mImage1Tab1.setVisibility(View.INVISIBLE);
                onClickAction(1);
                break;
            }
            case R.id.image2_table1: {
                mImage2Tab1.setVisibility(View.INVISIBLE);
                onClickAction(2);
                break;
            }
            case R.id.image3_table1: {
                mImage3Tab1.setVisibility(View.INVISIBLE);
                onClickAction(3);
                break;
            }
            case R.id.image4_table1: {
                mImage4Tab1.setVisibility(View.INVISIBLE);
                onClickAction(4);
                break;
            }
        }
    }

    private void onClickAction( int num) {
        arrayTab1[clickCount] = num;

        if (clickCount == 1) {
            mTextTab1.setText(R.string.text_worst);
        }
        if (clickCount == 2) {
            // TODO: 05.11.2017 сохранение
            mPresenter.showTable2Screen();
        }

        clickCount ++;
    }
}
