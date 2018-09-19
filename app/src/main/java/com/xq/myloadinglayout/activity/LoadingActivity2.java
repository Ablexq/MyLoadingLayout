package com.xq.myloadinglayout.activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.xq.myloadinglayout.R;
import com.xq.myloadinglayout.view.LoadingLayout;


public class LoadingActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_layout);


        final LoadingLayout mLoadingLayout = (LoadingLayout) findViewById(R.id.loading_view);
        final TextView mTvData = ((TextView) this.findViewById(R.id.data_tv));

        //加载时
        mTvData.setVisibility(View.GONE);
        mLoadingLayout.setLoadingType(LoadingLayout.TYPE_LOADING);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //加载完数据
                if (mLoadingLayout.getState() == LoadingLayout.STATE_REFRESH) {
                    mLoadingLayout.setLoadingType(LoadingLayout.TYPE_LOAD_ERROR);
                }
            }
        }, 2000);

    }
}
