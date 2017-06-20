package com.benhero.design.module.activity;

import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.benhero.design.R;

/**
 * 模块化Activity
 *
 * @author benhero
 */
public class ModuleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module);
        BottomSheetBehavior<View> behavior = BottomSheetBehavior.from(findViewById(R.id.activity_main_bottom_sheet));
        behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
    }
}
