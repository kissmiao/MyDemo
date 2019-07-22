package com.hongliang.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.hongliang.demo.otherActivity.AidlActivity;
import com.hongliang.demo.otherActivity.GlideActivity;
import com.hongliang.demo.otherActivity.HandlerThreadActivity;
import com.hongliang.demo.otherActivity.RefreshViewActivity;
import com.hongliang.demo.otherActivity.touchevent.TouchEventActivity;
import com.hongliang.demo.otherActivity.DeleteView;
import com.hongliang.demo.otherActivity.LayoutInflateActivity;
import com.hongliang.demo.otherActivity.ListViewScrollActivity;
import com.hongliang.demo.otherActivity.TimeViewGroupActivity;
import com.hongliang.demo.otherActivity.TransverseScrollView;
import com.hongliang.demo.otherActivity.ViewPagerActivity;


/**
 * Created by Administrator on 2016/6/28.
 */
public class AFragment extends Fragment implements View.OnClickListener {
    private View view;
    /**
     * One
     */
    private Button mBtnOne;
    /**
     * two
     */
    private Button mBtnTwo;

    /**
     * viewPage
     */
    private Button mViewPage;
    /**
     * 横向滑动
     */
    private Button mHomeViewpage;

    /**
     * moveview
     */
    private Button mMoveview;
    /**
     * 删除Veiw
     */
    private Button mLoaderimage;
    /**
     * touch
     */
    private Button mTouch;
    /**
     * removeSideslipActivity
     */
    private Button mRemoveSideslip;
    /**
     * scroll
     */
    private Button mScroll;

    /**
     * 时间选择器
     */
    private Button mTime;
    /**
     * LayoutInflate
     */
    private Button mBtLayoutInflate;
    /**
     * recycle
     */
    private Button mBtRecycle;
    /**
     * eventBus
     */
    private Button mEventBus;
    /**
     * 时间
     */
    private Button mBtTime;

    /**
     * 刷新View
     */
    private Button mBtRefresh;

    /**
     * handlerThread
     */
    private Button mBtHandlerThread;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_as, null);

        initView(view);
        return view;
    }


    private void initView(View view) {
        mBtnOne = (Button) view.findViewById(R.id.btn_one);
        mBtnOne.setOnClickListener(this);
        mBtnTwo = (Button) view.findViewById(R.id.btn_two);
        mBtnTwo.setOnClickListener(this);
        mViewPage = (Button) view.findViewById(R.id.view_page);
        mViewPage.setOnClickListener(this);
        mHomeViewpage = (Button) view.findViewById(R.id.home_viewpage);
        mHomeViewpage.setOnClickListener(this);
        mMoveview = (Button) view.findViewById(R.id.moveview);
        mMoveview.setOnClickListener(this);
        mLoaderimage = (Button) view.findViewById(R.id.loaderimage);
        mLoaderimage.setOnClickListener(this);
        mTouch = (Button) view.findViewById(R.id.touch);
        mTouch.setOnClickListener(this);
        mRemoveSideslip = (Button) view.findViewById(R.id.remove_sideslip);
        mRemoveSideslip.setOnClickListener(this);
        mScroll = (Button) view.findViewById(R.id.scroll);
        mScroll.setOnClickListener(this);
        mTime = (Button) view.findViewById(R.id.time);
        mTime.setOnClickListener(this);
        mBtLayoutInflate = (Button) view.findViewById(R.id.bt_LayoutInflate);
        mBtLayoutInflate.setOnClickListener(this);
        mBtRecycle = (Button) view.findViewById(R.id.bt_recycle);
        mBtRecycle.setOnClickListener(this);
        mEventBus = (Button) view.findViewById(R.id.event_bus);
        mEventBus.setOnClickListener(this);
        mBtTime = (Button) view.findViewById(R.id.bt_time);
        mBtTime.setOnClickListener(this);
        mBtRefresh = (Button) view.findViewById(R.id.bt_refresh);
        mBtRefresh.setOnClickListener(this);

        mBtHandlerThread = (Button) view.findViewById(R.id.bt_handler_thread);
        mBtHandlerThread.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.btn_one:
                intent = new Intent(getActivity(), AidlActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_two:
                startActivity(new Intent(getActivity(), GlideActivity.class));
                break;
            case R.id.view_page:
                intent = new Intent(getActivity(), ViewPagerActivity.class);
                startActivity(intent);
                break;
            case R.id.home_viewpage:
                intent = new Intent(getActivity(), TransverseScrollView.class);
                startActivity(intent);
                break;

            case R.id.moveview:
                break;
            case R.id.loaderimage:
                intent = new Intent(getActivity(), DeleteView.class);
                startActivity(intent);
                break;
            case R.id.touch:
                intent = new Intent(getActivity(), TouchEventActivity.class);
                startActivity(intent);
                break;
            case R.id.remove_sideslip:
                break;
            case R.id.scroll:
                intent = new Intent(getActivity(), ListViewScrollActivity.class);
                startActivity(intent);
                break;

            case R.id.time:
                break;
            case R.id.bt_LayoutInflate:
                intent = new Intent(getActivity(), LayoutInflateActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_recycle:

                break;
            case R.id.event_bus:
                break;
            case R.id.bt_time:
                intent = new Intent(getActivity(), TimeViewGroupActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_refresh:
                intent = new Intent(getActivity(), RefreshViewActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_handler_thread:
                intent = new Intent(getActivity(), HandlerThreadActivity.class);
                startActivity(intent);
                break;
        }
    }
}
