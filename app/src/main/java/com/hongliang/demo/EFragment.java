package com.hongliang.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.hongliang.demo.otherActivity.AnimActivity;
import com.hongliang.demo.otherActivity.DialogActivity;
import com.hongliang.demo.otherActivity.DrawableActivity;
import com.hongliang.demo.otherActivity.HandlerActivity;
import com.hongliang.demo.otherActivity.ImageViewGroupActivity;
import com.hongliang.demo.otherActivity.ItemViewGroupActivity;
import com.hongliang.demo.otherActivity.OkHttpActivity;
import com.hongliang.demo.otherActivity.PopwActivity;


/**
 * Created by Administrator on 2016/6/28.
 */
public class EFragment extends Fragment implements View.OnClickListener {
    private Button mViewl;
    private View view;

    /**
     * Item
     */
    private Button mBtItem;

    /**
     * drawable
     */
    private Button mBtDrawable;
    /**
     * ImageViewGroup
     */
    private Button mBtImageViewgroup;

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

        mBtItem = (Button) view.findViewById(R.id.bt_item);
        mBtItem.setOnClickListener(this);
        mBtDrawable = (Button) view.findViewById(R.id.bt_drawable);
        mBtDrawable.setOnClickListener(this);
        mBtImageViewgroup = (Button) view.findViewById(R.id.bt_image_viewgroup);
        mBtImageViewgroup.setOnClickListener(this);
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
        view.findViewById(R.id.bt_anim).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Intent intent = null;
        switch (v.getId()) {

            case R.id.bt_item:
                intent = new Intent(getActivity(), ItemViewGroupActivity.class);
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

            case R.id.bt_listView:
                break;
            case R.id.bt_recycle:
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
                intent = new Intent(getActivity(), OkHttpActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_anim:
                intent = new Intent(getActivity(), AnimActivity.class);
                startActivity(intent);
                break;
        }
    }
}
