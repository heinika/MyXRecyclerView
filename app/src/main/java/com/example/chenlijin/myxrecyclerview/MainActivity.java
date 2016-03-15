package com.example.chenlijin.myxrecyclerview;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.chenlijin.myxrecyclerview.adapter.TestAdapter;
import com.example.chenlijin.myxrecyclerview.bean.BaseInfo;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements XRecyclerView.LoadingListener,View.OnClickListener{
    private XRecyclerView mXRecyclerViewChen;
    private Button mButtonStart;
    private Button mButtonStop;
    private TestAdapter mAdapter;
    private List<BaseInfo> mBaseInfoList;
    private static final int REFRESH = 1;
    private static final int LOAD = 2;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case REFRESH:
                    mXRecyclerViewChen.refreshComplete();
                    break;
                case LOAD:
                    mXRecyclerViewChen.refreshComplete();
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        mXRecyclerViewChen = (XRecyclerView) findViewById(R.id.xrecyclerview_chen);
        mButtonStart = (Button) findViewById(R.id.button_start);
        mButtonStop = (Button) findViewById(R.id.button_stop);
        mButtonStop.setOnClickListener(this);
        mButtonStart.setOnClickListener(this);
        mXRecyclerViewChen.setLoadingListener(this);
        initData();
        mAdapter = new TestAdapter(mBaseInfoList,this);
        mXRecyclerViewChen.setAdapter(mAdapter);
        mXRecyclerViewChen.setLayoutManager(layoutManager);
        mXRecyclerViewChen.startLayoutAnimation();
        mXRecyclerViewChen.setLoadingMoreEnabled(true);
//        mXRecyclerViewChen.setLoadingMoreEnabled(false);
    }

    private void initData() {
        mBaseInfoList = new ArrayList<>();
        for(int i=0;i<12;i++){
            BaseInfo baseInfo = new BaseInfo();
            mBaseInfoList.add(baseInfo);
        }
    }

    @Override
    public void onRefresh() {
        handler.sendEmptyMessageDelayed(REFRESH,2000);
    }

    @Override
    public void onLoadMore() {
        handler.sendEmptyMessageDelayed(LOAD,2000);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_start:
                mXRecyclerViewChen.startRefresh();
                break;
            case R.id.button_stop:
                mXRecyclerViewChen.refreshComplete();
                break;
            default:
                break;
        }

    }

    /**
     * 根据手机分辨率从dp转成px
     *
     * @param context
     * @param dpValue
     * @return
     */
    public int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return  (int)(dpValue * scale + 0.5f);
    }
}
