package com.benhero.design.module.bottom;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.benhero.design.R;

/**
 * 模块化抽屉Fragment
 */
public class ModuleBottomFragment extends Fragment {

    private ModuleBottomPeekViewHolder mPeekViewHolder;
    private ModuleBottomListViewHolder mListViewHolder;

    public ModuleBottomFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_module_bottom, container, false);
        mPeekViewHolder = new ModuleBottomPeekViewHolder(this.getActivity(), layout.findViewById(R.id.bottom_peek_layout));
        mListViewHolder = new ModuleBottomListViewHolder(layout.findViewById(R.id.fragment_bottom_sheet_list));
        return layout;
    }

}
