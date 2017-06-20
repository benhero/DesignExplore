package com.benhero.design.mvp.presenter;


import com.benhero.design.mvp.base.BasePresenter;
import com.benhero.design.mvp.base.BaseView;
import com.benhero.design.mvp.bean.MvpItem;

import java.util.List;

/**
 * MVP接口
 *
 * @author benhero
 */
public interface MvpContract {
    /**
     * MVP逻辑控制接口
     */
    interface Presenter extends BasePresenter {

        void initData();

        int getEnter();

        void onResume();
    }

    /**
     * MVP界面接口
     */
    interface View extends BaseView<Presenter> {

        void initData(List<MvpItem> list);

        void setTitleText(int id);

        void setUpgradeBtnText(int id);
    }
}
