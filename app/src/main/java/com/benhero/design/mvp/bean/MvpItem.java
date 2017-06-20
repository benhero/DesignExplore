package com.benhero.design.mvp.bean;

/**
 * Mvp展示Bean
 *
 * @author benhero
 */
public class MvpItem {
    private int mTitleId;
    private int mDescId;

    public int getTitleId() {
        return mTitleId;
    }

    public void setTitleId(int titleId) {
        mTitleId = titleId;
    }

    public int getDescId() {
        return mDescId;
    }

    public void setDescId(int descId) {
        mDescId = descId;
    }

    @Override
    public String toString() {
        return "PremiumFunctionFactorItem{" +
                "mTitleId=" + mTitleId +
                ", mDescId=" + mDescId +
                '}';
    }
}
