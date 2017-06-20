package com.benhero.design.module.bg;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.benhero.design.R;

/**
 * 模块化背景Fragment
 */
public class ModuleBgFragment extends Fragment {

    public ModuleBgFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_module_bg, container, false);
    }

}
