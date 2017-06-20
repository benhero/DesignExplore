package com.benhero.design.module.bottom;

import android.view.View;

import com.benhero.design.module.base.ViewHolder;

/**
 * 抽屉列表的ViewHolder
 *
 * @author benhero
 */
public class ModuleBottomListViewHolder extends ViewHolder {

    public ModuleBottomListViewHolder(View contentView) {
        super(contentView);
        init();
    }

    private void init() {
        // 此处也可以使用RecycleView实现，而使用NestedScrollView可以提高拓展性，可以实现每个列表Item对应不同的布局
    }

}
