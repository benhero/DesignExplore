package com.benhero.design.module.bottom;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import com.benhero.design.R;
import com.benhero.design.module.base.ViewHolder;

/**
 * 抽屉顶部的ViewHolder
 *
 * @author benhero
 */
public class ModuleBottomPeekViewHolder extends ViewHolder implements View.OnClickListener {

    private final Context mContext;
    private View mBtn1;
    private View mBtn2;

    public ModuleBottomPeekViewHolder(Context context, View contentView) {
        super(contentView);
        mContext = context;
        initView();
    }

    private void initView() {
        View contentView = getContentView();
        mBtn1 = contentView.findViewById(R.id.bottom_peek_btn_1);
        mBtn2 = contentView.findViewById(R.id.bottom_peek_btn_2);
        mBtn1.setOnClickListener(this);
        mBtn2.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        if (view.equals(mBtn1)) {
            Toast.makeText(mContext, "Click Btn1", Toast.LENGTH_SHORT).show();
        } else if (view.equals(mBtn2)) {
            Toast.makeText(mContext, "Click Btn2", Toast.LENGTH_SHORT).show();
        }
    }
}
