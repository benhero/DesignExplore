package com.benhero.design.mvp.base;

/**
 * BaseView
 * @author benhero
 * @param <T> Presenter
 */
public interface BaseView<T> {
    void setPresenter(T presenter);
}
