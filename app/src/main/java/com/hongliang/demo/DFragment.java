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
import com.hongliang.demo.viewActivity.CanvasActivity;
import com.hongliang.demo.viewActivity.PaintActivity;
import com.hongliang.demo.viewActivity.PathActivity;


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
        }
    }
}
