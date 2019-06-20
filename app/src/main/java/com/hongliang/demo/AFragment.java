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
import com.hongliang.demo.otherActivity.RefreshViewActivity;
import com.hongliang.demo.touchevent.TouchEventActivity;
import com.hongliang.demo.viewActivity.BrokenLineActivity;
import com.hongliang.demo.viewActivity.ClockActivity;
import com.hongliang.demo.viewActivity.ColumnActivity;
import com.hongliang.demo.viewActivity.DeleteView;
import com.hongliang.demo.viewActivity.DrawCircleActivity;
import com.hongliang.demo.viewActivity.LayoutInflateActivity;
import com.hongliang.demo.viewActivity.MenuActivity;
import com.hongliang.demo.viewActivity.ScrollActivity;
import com.hongliang.demo.viewActivity.SlideActivity;
import com.hongliang.demo.viewActivity.SpeedActivity;
import com.hongliang.demo.viewActivity.TimeViewGroupActivity;
import com.hongliang.demo.viewActivity.TransverseScrollView;
import com.hongliang.demo.viewActivity.ViewPagerActivity;


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
     * 点赞
     */
    private Button mBtnLoadeLoade;
    /**
     * viewPage
     */
    private Button mViewPage;
    /**
     * 横向滑动
     */
    private Button mHomeViewpage;
    /**
     * clock
     */
    private Button mClock;
    /**
     * menu
     */
    private Button mMenu;
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
     * 折线
     */
    private Button mBrokenLine;
    /**
     * 柱状图
     */
    private Button mColumn;
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
     * 刻度滑动
     */
    private Button mBtSlide;
    /**
     * 进度
     */
    private Button mBtSpeed;
    /**
     * 刷新View
     */
    private Button mBtRefresh;

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
        mBtnLoadeLoade = (Button) view.findViewById(R.id.btn_loadeLoade);
        mBtnLoadeLoade.setOnClickListener(this);
        mViewPage = (Button) view.findViewById(R.id.view_page);
        mViewPage.setOnClickListener(this);
        mHomeViewpage = (Button) view.findViewById(R.id.home_viewpage);
        mHomeViewpage.setOnClickListener(this);
        mClock = (Button) view.findViewById(R.id.clock);
        mClock.setOnClickListener(this);
        mMenu = (Button) view.findViewById(R.id.menu);
        mMenu.setOnClickListener(this);
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
        mBrokenLine = (Button) view.findViewById(R.id.broken_line);
        mBrokenLine.setOnClickListener(this);
        mColumn = (Button) view.findViewById(R.id.column);
        mColumn.setOnClickListener(this);
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
        mBtSlide = (Button) view.findViewById(R.id.bt_slide);
        mBtSlide.setOnClickListener(this);
        mBtSpeed = (Button) view.findViewById(R.id.bt_speed);
        mBtSpeed.setOnClickListener(this);
        mBtRefresh = (Button) view.findViewById(R.id.bt_refresh);
        mBtRefresh.setOnClickListener(this);
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
                break;
            case R.id.btn_loadeLoade:
                intent = new Intent(getActivity(), DrawCircleActivity.class);
                startActivity(intent);
                break;
            case R.id.view_page:
                intent = new Intent(getActivity(), ViewPagerActivity.class);
                startActivity(intent);
                break;
            case R.id.home_viewpage:
                intent = new Intent(getActivity(), TransverseScrollView.class);
                startActivity(intent);
                break;
            case R.id.clock:
                intent = new Intent(getActivity(), ClockActivity.class);
                startActivity(intent);
                break;
            case R.id.menu:
                intent = new Intent(getActivity(), MenuActivity.class);
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
                intent = new Intent(getActivity(), ScrollActivity.class);
                startActivity(intent);
                break;
            case R.id.broken_line:
                intent = new Intent(getActivity(), BrokenLineActivity.class);
                startActivity(intent);
                break;
            case R.id.column:
                intent = new Intent(getActivity(), ColumnActivity.class);
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
            case R.id.bt_slide:
                intent = new Intent(getActivity(), SlideActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_speed:
                intent = new Intent(getActivity(), SpeedActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_refresh:
                intent = new Intent(getActivity(), RefreshViewActivity.class);
                startActivity(intent);
                break;
        }
    }
}
