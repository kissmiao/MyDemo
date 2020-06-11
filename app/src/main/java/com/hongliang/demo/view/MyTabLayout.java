package com.hongliang.demo.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hongliang.demo.R;

import java.util.List;


public class MyTabLayout extends LinearLayout {

    private Context mContext;

    public MyTabLayout(Context context) {
        super(context);
        init(context);
    }

    public MyTabLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public MyTabLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        mContext = context;
    }


    public void setData(List<String> dataList) {
        setData(dataList, 0);
    }

    public void setData(final List<String> dataList, int selectPosition) {


        for (int i = 0; i < dataList.size(); i++) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.view_tablayout_item, null);
            LinearLayout.LayoutParams lp = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            lp.setMargins(0, 0, dip2px(mContext, 15.0f), 0);
            view.setLayoutParams(lp);

            TextView tabTitle = view.findViewById(R.id.tv_tab_layout_title);
            View tabView = view.findViewById(R.id.v_tab_view);
            view.setTag(i);
            tabTitle.setText(dataList.get(i));
            if (selectPosition == i) {
                tabView.setVisibility(VISIBLE);
                if (mOnChangeListener != null) {
                    mOnChangeListener.onChange(selectPosition);
                }
            } else {
                tabView.setVisibility(GONE);
            }

            view.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    setSelectView((Integer) view.getTag());
                }
            });

            addView(view);
        }
    }


    private void setSelectView(int position) {
        int size = getChildCount();
        for (int i = 0; i < size; i++) {
            ViewGroup v = (ViewGroup) getChildAt(i);
            View tabView = v.findViewById(R.id.v_tab_view);
            if (i == position) {
                tabView.setVisibility(VISIBLE);
                if (mOnChangeListener != null) {
                    mOnChangeListener.onChange(position);
                }
            } else {
                tabView.setVisibility(GONE);
            }
        }
    }


    private OnChangeListener mOnChangeListener;

    public interface OnChangeListener {
        void onChange(int position);
    }


    public void setOnChangeListener(OnChangeListener onChangeListener) {
        mOnChangeListener = onChangeListener;
    }


    public static int dip2px(Context context, float dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }


}
