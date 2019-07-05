package com.hongliang.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.hongliang.demo.otherActivity.Circular2Activity;
import com.hongliang.demo.otherActivity.CircularActivity;
import com.hongliang.demo.otherActivity.CurveActivity;
import com.hongliang.demo.otherActivity.DialogActivity;
import com.hongliang.demo.otherActivity.DrawableActivity;
import com.hongliang.demo.otherActivity.HandlerActivity;
import com.hongliang.demo.otherActivity.ImageViewGroupActivity;
import com.hongliang.demo.otherActivity.ItemViewGroupActivity;
import com.hongliang.demo.otherActivity.MyViewActivity;
import com.hongliang.demo.otherActivity.PopwActivity;
import com.hongliang.demo.otherActivity.QQHealthActivity;
import com.hongliang.demo.otherActivity.SolidViewActivity;


/**
 * Created by Administrator on 2016/6/28.
 */
public class EFragment extends Fragment implements View.OnClickListener {
    private Button mViewl;
    private View view;
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
     * Item
     */
    private Button mBtItem;
    /**
     * curve
     */
    private Button mBtCurve;
    /**
     * drawable
     */
    private Button mBtDrawable;
    /**
     * ImageViewGroup
     */
    private Button mBtImageViewgroup;
    /**
     * Circular
     */
    private Button mBtCircular;
    /**
     * Circular2
     */
    private Button mBtCircular2;
    /**
     * listView
     */
    private Button mBtListView;
    /**
     * RecycleView
     */
    private Button mBtRecycle;
    /**
     * ViewPage
     */
    private Button mBtViewpage;
    /**
     * popwindow
     */
    private Button mBtPopw;
    /**
     * 测试Handler
     */
    private Button mBtHandler;
    /**
     * Dialog
     */
    private Button mBtDialog;
    /**
     * OK
     */
    private Button mBtOk;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.efragment_layout, null);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mBtView = (Button) view.findViewById(R.id.bt_view);
        mBtView.setOnClickListener(this);
        mBtSolid = (Button) view.findViewById(R.id.bt_solid);
        mBtSolid.setOnClickListener(this);
        mQqHealth = (Button) view.findViewById(R.id.qq_health);
        mQqHealth.setOnClickListener(this);
        mBtItem = (Button) view.findViewById(R.id.bt_item);
        mBtItem.setOnClickListener(this);
        mBtCurve = (Button) view.findViewById(R.id.bt_curve);
        mBtCurve.setOnClickListener(this);
        mBtDrawable = (Button) view.findViewById(R.id.bt_drawable);
        mBtDrawable.setOnClickListener(this);
        mBtImageViewgroup = (Button) view.findViewById(R.id.bt_image_viewgroup);
        mBtImageViewgroup.setOnClickListener(this);
        mBtCircular = (Button) view.findViewById(R.id.bt_circular);
        mBtCircular.setOnClickListener(this);
        mBtCircular2 = (Button) view.findViewById(R.id.bt_circular2);
        mBtCircular2.setOnClickListener(this);
        mBtListView = (Button) view.findViewById(R.id.bt_listView);
        mBtListView.setOnClickListener(this);
        mBtRecycle = (Button) view.findViewById(R.id.bt_recycle);
        mBtRecycle.setOnClickListener(this);
        mBtViewpage = (Button) view.findViewById(R.id.bt_viewpage);
        mBtViewpage.setOnClickListener(this);
        mBtPopw = (Button) view.findViewById(R.id.bt_popw);
        mBtPopw.setOnClickListener(this);
        mBtHandler = (Button) view.findViewById(R.id.bt_handler);
        mBtHandler.setOnClickListener(this);
        mBtDialog = (Button) view.findViewById(R.id.bt_dialog);
        mBtDialog.setOnClickListener(this);
        mBtOk = (Button) view.findViewById(R.id.bt_ok);
        mBtOk.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Intent intent=null;
        switch (v.getId()) {
            case R.id.bt_view:
                intent = new Intent(getActivity(), MyViewActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_solid:
                intent = new Intent(getActivity(), SolidViewActivity.class);
                startActivity(intent);
                break;
            case R.id.qq_health:
                intent = new Intent(getActivity(), QQHealthActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_item:
                intent = new Intent(getActivity(), ItemViewGroupActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_curve:
                intent = new Intent(getActivity(), CurveActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_drawable:
                intent = new Intent(getActivity(), DrawableActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_image_viewgroup:
                intent = new Intent(getActivity(), ImageViewGroupActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_circular:
                intent = new Intent(getActivity(), CircularActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_circular2:
                intent = new Intent(getActivity(), Circular2Activity.class);
                startActivity(intent);
                break;
            case R.id.bt_listView:
                break;
            case R.id.bt_recycle:
                break;
            case R.id.bt_viewpage:
                break;
            case R.id.bt_popw:
                intent = new Intent(getActivity(), PopwActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_handler:
                intent = new Intent(getActivity(), HandlerActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_dialog:
                intent = new Intent(getActivity(), DialogActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_ok:
                break;
        }
    }
}
