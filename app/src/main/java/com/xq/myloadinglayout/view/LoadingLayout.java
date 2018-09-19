package com.xq.myloadinglayout.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.xq.myloadinglayout.R;


public class LoadingLayout extends LinearLayout {

    public final static int STATE_REFRESH = 2;
    public final static int STATE_NONE = 1;

    public static final int HIDE_LAYOUT = -0;
    public static final int TYPE_LOADING = 1;
    public static final int TYPE_LOAD_ERROR = 2;//请求-失败
    public static final int TYPE_NET_ERROR = 3;//网络-异常

    public static int sState = STATE_NONE;

    private Context mContext;
    private ImageView mNetErrorImage, mNoDataImage;
    private TextView mTextView;
    private ProgressBar mAnimProgress;

    public LoadingLayout(Context context) {
        this(context, null);
    }

    public LoadingLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LoadingLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        init();
    }

    private void init() {
        setEnabled(false);
        View view = LayoutInflater.from(mContext).inflate(R.layout.loading_layout, this, false);
        mNetErrorImage = (ImageView) view.findViewById(R.id.img_net_error);
        mNoDataImage = (ImageView) view.findViewById(R.id.img_no_data);
        mTextView = (TextView) view.findViewById(R.id.tv_loading);
        mAnimProgress = (ProgressBar) view.findViewById(R.id.animProgress);

        addView(view);
    }

    public int getState() {
        return sState;
    }

    public void setLoadingType(int type) {
        switch (type) {
            case HIDE_LAYOUT:
                setEnabled(false);
                sState = STATE_NONE;
                setVisibility(View.GONE);
                break;

            case TYPE_LOADING:
                setEnabled(false);
                sState = STATE_REFRESH;
                setVisibility(View.VISIBLE);
                mNetErrorImage.setVisibility(View.GONE);
                mNoDataImage.setVisibility(View.GONE);
                mAnimProgress.setVisibility(View.VISIBLE);//加载中
                mTextView.setText("加载中");
                break;

            case TYPE_LOAD_ERROR:
                setEnabled(true);
                sState = STATE_NONE;
                setVisibility(View.VISIBLE);
                mNetErrorImage.setVisibility(View.GONE);
                mNoDataImage.setVisibility(View.VISIBLE);
                mAnimProgress.setVisibility(View.GONE);
                mTextView.setText("暂无数据，请点击重新加载");
                break;

            case TYPE_NET_ERROR:
                setEnabled(true);
                sState = STATE_NONE;
                setVisibility(View.VISIBLE);
                mNetErrorImage.setVisibility(View.VISIBLE);
                mNoDataImage.setVisibility(View.GONE);
                mAnimProgress.setVisibility(View.GONE);
                mTextView.setText("网络有问题，请点击重新加载");
                break;
        }
    }
}
