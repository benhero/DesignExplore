package com.benhero.design.module.base;

import android.view.View;

/**
 * ViewHolder基类
 *
 * @author benhero
 */
public class ViewHolder {
    private View mContentView;

    public ViewHolder() {
    }

    public ViewHolder(View contentView) {
        mContentView = contentView;
    }

    public final void setContentView(View contentView) {
        mContentView = contentView;
    }

    public View getContentView() {
        return mContentView;
    }
}
