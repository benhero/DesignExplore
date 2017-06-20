package com.benhero.design.mvp.view;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.benhero.design.R;

/**
 * MVP结果页
 *
 * @author benhero
 */
public class MvpResultActivity extends AppCompatActivity {
    public static final String EXTRA_ENTER = "enter";
    public static final int ENTER_MAIN = 0;
    public static final int ENTER_A = 1;
    public static final int ENTER_B = 2;
    public static final int ENTER_C = 3;
    public static final int ENTER_D = 4;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp_result);
        mTextView = (TextView) findViewById(R.id.mvp_result_text);
        checkIntent();
    }

    private void checkIntent() {
        Intent intent = getIntent();
        if (intent != null) {
            int enter = intent.getIntExtra(EXTRA_ENTER, 0);
            if (enter == 0) {
                errorEnter();
            } else {
                mTextView.setText(String.valueOf(enter));
            }
        } else {
            errorEnter();
        }
    }

    /**
     * 状态错误
     */
    private void errorEnter() {
        Toast.makeText(this, "Error Intent", Toast.LENGTH_SHORT).show();
        finish();
    }

}
