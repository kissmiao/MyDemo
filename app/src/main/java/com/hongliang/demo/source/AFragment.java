package com.hongliang.demo.source;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.hongliang.demo.BaseFragment;
import com.hongliang.demo.R;
import com.hongliang.demo.otherActivity.DeleteView;
import com.hongliang.demo.source.activity.FileActivity;
import com.hongliang.demo.source.activity.GlideActivity;
import com.hongliang.demo.source.activity.HandlerThreadActivity;
import com.hongliang.demo.source.activity.LayoutInflateActivity;
import com.hongliang.demo.otherActivity.MessengerActivity;
import com.hongliang.demo.source.activity.RefreshViewActivity;
import com.hongliang.demo.otherActivity.TimeViewGroupActivity;
import com.hongliang.demo.otherActivity.TransverseScrollView;
import com.hongliang.demo.otherActivity.ViewPagerActivity;
import com.hongliang.demo.otherActivity.ViewSlideActivity;
import com.hongliang.demo.source.activity.TouchEventActivity;
import com.hongliang.demo.source.activity.AidlActivity;
import com.hongliang.demo.util.BitmapUtil;


/**
 * Created by Administrator on 2016/6/28.
 */
public class AFragment extends BaseFragment implements View.OnClickListener {
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

    /**
     * View的滑动
     */
    private Button bt_Slide;
    /**
     * View滑动
     */
    private Button mBtSlide;


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


        mBtSlide = view.findViewById(R.id.bt_Slide);
        mBtSlide.setOnClickListener(this);

        ImageView imageView = view.findViewById(R.id.iv_afragment);
        BitmapUtil.loadResImage(getActivity(), imageView, R.drawable.a);

        ImageView imageView2 = view.findViewById(R.id.iv_afragment2);
        BitmapUtil.loadResImage(getActivity(), imageView2, R.drawable.avastar);

        ImageView imageView3 = view.findViewById(R.id.iv_afragment3);
        BitmapUtil.loadResImage(getActivity(), imageView3, R.drawable.e);

        ImageView imageView4 = view.findViewById(R.id.iv_afragment3);
        BitmapUtil.loadResImage(getActivity(), imageView4, R.drawable.c);

        ImageView imageView5 = view.findViewById(R.id.iv_afragment3);
        BitmapUtil.loadResImage(getActivity(), imageView5, R.drawable.d);

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
                intent = new Intent(getActivity(), FileActivity.class);
                startActivity(intent);
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
                intent = new Intent(getActivity(), MessengerActivity.class);
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
            case R.id.bt_Slide:
                intent = new Intent(getActivity(), ViewSlideActivity.class);
                startActivity(intent);
                break;
        }
    }


    /**
     * 首先AFragment加载5张Bitmap图片到内存，然后从首页跳转到一个Activity，然后直接回到桌面，然后使用应用宝清除内存
     * 打开app,回到首页，会发现，首页白屏，然后重新加载，
     * AFragment：onAttach
     * .AFragment：onCreate
     * MainActivity：onCreate
     * AFragment：onViewCreated
     * AFragment：onActivityCreated
     * AFragment：onStart
     * MainActivity：onStart
     * MainActivity：onRestoreInstanceState
     * MainActivity：onResume
     * mBtnOne=====null
     * AFragment：onResume
     * 在MainActivity的onResume中打印AFragment的某一个控件是为空
     *
     */
    /**
     * 说明清除分两种级别，一个是只清除View还有一种是清除整个Fragment
     * 当有5个Bitmap加载的时候，没有使用应用宝清除内存，正常从activity回来的时候
     * AFragment：onStart
     * MainActivity：onStart
     * MainActivity：onResume
     * mBtnOne=====null
     * AFragment：onResume
     */
    /**
     * 当去掉5个Bitmap的加载没有使用应用宝清除内存，正常从activity回来的时候
     * AFragment：onStart
     * .MainActivity：onStart
     * MainActivity：onResume
     * mBtnOne=====android.support.v7.widget.AppCompatButton
     * AFragment：onResume
     */
    public void changeTest() {
        Log.i("LOG", "mBtnOne=====" + mBtnOne);
    }

}
