package com.benhero.design.mvp.presenter;


import com.benhero.design.R;
import com.benhero.design.mvp.bean.MvpItem;
import com.benhero.design.mvp.view.MvpResultActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * MvpDPresenter
 *
 * @author benhero
 */
public class MvpPresenterD implements MvpContract.Presenter {

    private final MvpContract.View mView;

    public MvpPresenterD(MvpContract.View view) {
        mView = view;
    }

    @Override
    public void start() {

    }

    @Override
    public void initData() {
        List<MvpItem> list = new ArrayList<>();
        list.add(createFactor(R.string.mvp_d_factor_title_1, R.string.mvp_d_factor_desc_1));
        list.add(createFactor(R.string.mvp_d_factor_title_2, R.string.mvp_d_factor_desc_2));
        mView.initData(list);
        mView.setTitleText(R.string.mvp_d_title);
        mView.setUpgradeBtnText(R.string.mvp_d_upgrade_btn);
    }

    private MvpItem createFactor(int titleId, int descId) {
        MvpItem item = new MvpItem();
        item.setTitleId(titleId);
        item.setDescId(descId);
        return item;
    }

    @Override
    public int getEnter() {
        return MvpResultActivity.ENTER_D;
    }

    @Override
    public void onResume() {
    }

}
