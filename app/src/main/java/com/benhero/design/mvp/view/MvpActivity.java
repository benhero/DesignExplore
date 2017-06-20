package com.benhero.design.mvp.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.benhero.design.R;
import com.benhero.design.mvp.bean.MvpItem;
import com.benhero.design.mvp.presenter.MvpPresenterD;
import com.benhero.design.mvp.presenter.MvpContract;
import com.benhero.design.mvp.presenter.MvpPresenterB;
import com.benhero.design.mvp.presenter.MvpPresenterC;
import com.benhero.design.mvp.presenter.MvpPresenterA;

import java.util.ArrayList;
import java.util.List;


/**
 * MVP
 *
 * @author benhero
 */
public class MvpActivity extends AppCompatActivity implements MvpContract.View, View.OnClickListener {
    public static final String EXTRA_ENTER = "enter";
    /**
     * 1 : A
     */
    public static final int ENTER_A = 1;
    /**
     * 2 : B
     */
    public static final int ENTER_B = 2;
    /**
     * 3 : C
     */
    public static final int ENTER_C = 3;
    /**
     * 4 : D
     */
    public static final int ENTER_D = 4;

    private MvpContract.Presenter mPresenter;
    private TextView mUpgradeBtn;
    private ListView mListView;
    private List<MvpItem> mList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp_layout);
        initView();
        checkIntent();
        mListView.setAdapter(new MVPAdapter());
    }

    private void initView() {
        mUpgradeBtn = (TextView) findViewById(R.id.mvp_btn);
        mUpgradeBtn.setOnClickListener(this);
        mListView = (ListView) findViewById(R.id.mvp_listview);
    }

    private void checkIntent() {
        Intent intent = getIntent();
        if (intent != null) {
            int enter = intent.getIntExtra(EXTRA_ENTER, 0);
            if (enter == 0) {
                errorEnter();
            } else {
                initData(enter);
            }
        } else {
            errorEnter();
        }
    }

    /**
     * 状态错误
     */
    private void errorEnter() {
        Toast.makeText(this, "Error Intent", Toast.LENGTH_SHORT).show();
        finish();
    }

    private void initData(int extra) {
        switch (extra) {
            case ENTER_A:
                mPresenter = new MvpPresenterA(this);
                break;
            case ENTER_B:
                mPresenter = new MvpPresenterB(this);
                break;
            case ENTER_C:
                mPresenter = new MvpPresenterC(this);
                break;
            case ENTER_D:
                mPresenter = new MvpPresenterD(this);
                break;
            default:
                errorEnter();
                break;
        }
        if (mPresenter != null) {
            mPresenter.initData();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mPresenter != null) {
            mPresenter.onResume();
        }
    }

    @Override
    public void onClick(View v) {
        if (v.equals(mUpgradeBtn)) {
            Intent intent = new Intent(this, MvpResultActivity.class);
            intent.putExtra(MvpResultActivity.EXTRA_ENTER,
                    mPresenter != null ? mPresenter.getEnter() : MvpResultActivity.ENTER_MAIN);
            this.startActivity(intent);
        }
    }

    @Override
    public void initData(List<MvpItem> list) {
        mList.clear();
        mList.addAll(list);
    }

    @Override
    public void setTitleText(int id) {
        setTitle(getString(id));
    }

    @Override
    public void setUpgradeBtnText(int id) {
        mUpgradeBtn.setText(id);
    }

    @Override
    public void setPresenter(MvpContract.Presenter presenter) {
        mPresenter = presenter;
    }

    /**
     * 列表适配器
     *
     * @author benhero
     */
    private class MVPAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return mList.size();
        }

        @Override
        public Object getItem(int position) {
            return mList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            MyViewHolder holder;
            if (convertView == null) {
                holder = new MyViewHolder();
                convertView = LayoutInflater.from(MvpActivity.this).inflate(R.layout.mvp_list_item, parent, false);
                holder.mIndex = (TextView) convertView.findViewById(R.id.mvp_index);
                holder.mTitle = (TextView) convertView.findViewById(R.id.mvp_title);
                holder.mDesc = (TextView) convertView.findViewById(R.id.mvp_desc);
                holder.mDivider = convertView.findViewById(R.id.mvp_divider);
                convertView.setTag(holder);
            } else {
                holder = (MyViewHolder) convertView.getTag();
            }
            MvpItem itemBean = mList.get(position);
            holder.mIndex.setText(position + 1 + "");
            holder.mTitle.setText(itemBean.getTitleId());
            holder.mDesc.setText(itemBean.getDescId());
            holder.mDivider.setVisibility(position == mList.size() - 1 ? View.GONE : View.VISIBLE);
            return convertView;
        }

        /**
         * ViewHolder
         */
        class MyViewHolder {
            TextView mIndex;
            TextView mTitle;
            TextView mDesc;
            View mDivider;
        }
    }
}
