package com.hongliang.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hongliang.demo.view.ScrollView;
import com.hongliang.demo.viewActivity.AttributeSetActivity;
import com.hongliang.demo.viewActivity.BrokenLineActivity;
import com.hongliang.demo.viewActivity.CanvasActivity;
import com.hongliang.demo.viewActivity.Circular2Activity;
import com.hongliang.demo.viewActivity.CircularActivity;
import com.hongliang.demo.viewActivity.ClockActivity;
import com.hongliang.demo.viewActivity.ColumnActivity;
import com.hongliang.demo.viewActivity.CurveActivity;
import com.hongliang.demo.viewActivity.DrawCircleActivity;
import com.hongliang.demo.viewActivity.MenuActivity;
import com.hongliang.demo.viewActivity.MyViewActivity;
import com.hongliang.demo.viewActivity.OperationViewActivity;
import com.hongliang.demo.viewActivity.PaintActivity;
import com.hongliang.demo.viewActivity.PathActivity;
import com.hongliang.demo.viewActivity.QQHealthActivity;
import com.hongliang.demo.viewActivity.ScrollActivity;
import com.hongliang.demo.viewActivity.SlideActivity;
import com.hongliang.demo.viewActivity.SolidViewActivity;
import com.hongliang.demo.viewActivity.SpeedActivity;


/**
 * Created by Administrator on 2016/6/28.
 */
public class DFragment extends Fragment implements View.OnClickListener {
    private LinearLayout ll_moveview;
    private WindowManager wm;
    private int witch;
    private ScrollView scrollView;
    private View view;
    private LinearLayout mLlMoveview;
    private ScrollView mScrollview;
    /**
     * Path
     */
    private Button mBtPath;
    /**
     * Paint
     */
    private Button mBtPaint;
    /**
     * Canvas
     */
    private Button mBtCanvas;
    /**
     * curve
     */
    private Button mBtCurve;
    /**
     * 点赞
     */
    private Button mBtnLoadeLoade;
    /**
     * clock
     */
    private Button mClock;
    /**
     * menu
     */
    private Button mMenu;
    /**
     * 折线
     */
    private Button mBrokenLine;
    /**
     * 柱状图
     */
    private Button mColumn;
    /**
     * 刻度滑动
     */
    private Button mBtSlide;
    /**
     * 进度
     */
    private Button mBtSpeed;
    /**
     * MyVeiw
     */
    private Button mBtView;
    /**
     * 光晕
     */
    private Button mBtSolid;
    /**
     * QQ
     */
    private Button mQqHealth;
    /**
     * Circular
     */
    private Button mBtCircular;
    /**
     * Circular2
     */
    private Button mBtCircular2;
    /**
     * AttributeSet
     */
    private Button mBtAttributeSet;
    /**
     * AttributeSet
     */
    private Button mBtScroll;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.dfragment_layout, null);
        initView(view);
        return view;
    }


    private void initView(View view) {
        ll_moveview = (LinearLayout) view.findViewById(R.id.ll_moveview);
        wm = getActivity().getWindowManager();
        witch = wm.getDefaultDisplay().getWidth();
        scrollView = (ScrollView) view.findViewById(R.id.scrollview);
        for (int i = 0; i < 5; i++) {
            TextView textView = new TextView(getActivity());
            textView.setGravity(Gravity.CENTER);
            textView.setBackgroundColor(getResources().getColor(R.color.colorAccent));
            LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.MATCH_PARENT
            );
            p.width = witch / 3;
            textView.setText(i + "*****");
            textView.setLayoutParams(p);
            ll_moveview.addView(textView);
        }
        mLlMoveview = (LinearLayout) view.findViewById(R.id.ll_moveview);
        mScrollview = (ScrollView) view.findViewById(R.id.scrollview);
        mBtPath = (Button) view.findViewById(R.id.bt_path);
        mBtPath.setOnClickListener(this);
        mBtPaint = (Button) view.findViewById(R.id.bt_paint);
        mBtPaint.setOnClickListener(this);
        mBtCanvas = (Button) view.findViewById(R.id.bt_canvas);
        mBtCanvas.setOnClickListener(this);
        mBtCurve = (Button) view.findViewById(R.id.bt_curve);
        mBtCurve.setOnClickListener(this);
        mBtnLoadeLoade = (Button) view.findViewById(R.id.btn_loadeLoade);
        mBtnLoadeLoade.setOnClickListener(this);
        mClock = (Button) view.findViewById(R.id.clock);
        mClock.setOnClickListener(this);
        mMenu = (Button) view.findViewById(R.id.menu);
        mMenu.setOnClickListener(this);
        mBrokenLine = (Button) view.findViewById(R.id.broken_line);
        mBrokenLine.setOnClickListener(this);
        mColumn = (Button) view.findViewById(R.id.column);
        mColumn.setOnClickListener(this);
        mBtSlide = (Button) view.findViewById(R.id.bt_slide);
        mBtSlide.setOnClickListener(this);
        mBtSpeed = (Button) view.findViewById(R.id.bt_speed);
        mBtSpeed.setOnClickListener(this);
        mBtView = (Button) view.findViewById(R.id.bt_view);
        mBtView.setOnClickListener(this);
        mBtSolid = (Button) view.findViewById(R.id.bt_solid);
        mBtSolid.setOnClickListener(this);
        mQqHealth = (Button) view.findViewById(R.id.qq_health);
        mQqHealth.setOnClickListener(this);
        mBtCircular = (Button) view.findViewById(R.id.bt_circular);
        mBtCircular.setOnClickListener(this);
        mBtCircular2 = (Button) view.findViewById(R.id.bt_circular2);
        mBtCircular2.setOnClickListener(this);
        mBtAttributeSet = (Button) view.findViewById(R.id.bt_attributeSet);
        mBtAttributeSet.setOnClickListener(this);
        mBtScroll = (Button) view.findViewById(R.id.bt_scroll);
        mBtScroll.setOnClickListener(this);
        view.findViewById(R.id.bt_operaction_view).setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.bt_path:
                startActivity(new Intent(getActivity(), PathActivity.class));
                break;
            case R.id.bt_paint:
                startActivity(new Intent(getActivity(), PaintActivity.class));
                break;
            case R.id.bt_canvas:
                startActivity(new Intent(getActivity(), CanvasActivity.class));
                break;
            case R.id.bt_curve:
                startActivity(new Intent(getActivity(), CurveActivity.class));
                break;
            case R.id.btn_loadeLoade:
                startActivity(new Intent(getActivity(), DrawCircleActivity.class));
                break;
            case R.id.clock:
                startActivity(new Intent(getActivity(), ClockActivity.class));
                break;
            case R.id.menu:
                startActivity(new Intent(getActivity(), MenuActivity.class));
                break;
            case R.id.broken_line:
                startActivity(new Intent(getActivity(), BrokenLineActivity.class));
                break;
            case R.id.column:
                startActivity(new Intent(getActivity(), ColumnActivity.class));
                break;
            case R.id.bt_slide:
                startActivity(new Intent(getActivity(), SlideActivity.class));
                break;
            case R.id.bt_speed:
                startActivity(new Intent(getActivity(), SpeedActivity.class));
                break;
            case R.id.bt_view:
                startActivity(new Intent(getActivity(), MyViewActivity.class));
                break;
            case R.id.bt_solid:
                startActivity(new Intent(getActivity(), SolidViewActivity.class));
                break;
            case R.id.qq_health:
                startActivity(new Intent(getActivity(), QQHealthActivity.class));
                break;
            case R.id.bt_circular:
                startActivity(new Intent(getActivity(), CircularActivity.class));
                break;
            case R.id.bt_circular2:
                startActivity(new Intent(getActivity(), Circular2Activity.class));
                break;

            case R.id.bt_attributeSet:
                startActivity(new Intent(getActivity(), AttributeSetActivity.class));
                break;

            case R.id.bt_scroll:
                startActivity(new Intent(getActivity(), ScrollActivity.class));
                break;
            case R.id.bt_operaction_view:
                startActivity(new Intent(getActivity(), OperationViewActivity.class));
                break;
        }
    }


}
