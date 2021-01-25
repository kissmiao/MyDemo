package com.hongliang.demo.util.dialog;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.hongliang.demo.R;
import com.hongliang.demo.util.ScreenUtils;

public abstract class BaseFragmentDialog extends DialogFragment implements View.OnClickListener {
    //https://blog.csdn.net/zh_nan811/article/details/83015076
    protected View mLoading;
    protected Context mContext;
    protected View mContentView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //在这里调用setStyle设置主题样式
        setStyle(DialogFragment.STYLE_NO_TITLE,
                R.style.dialog_style);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        //RootView用来给Dialog添加loading，如果要在Dialog中做网络请求那么Loading会使内容布局复杂一层
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.dialog_base_view, container, false);
        this.mLoading = rootView.findViewById(R.id.loading_layout);
        //ContentView是真正的内容
        int layoutId = getLayoutResId();
        if (layoutId > 0) {
            mContentView = inflater.inflate(layoutId, rootView, false);
        }
        if (mContentView != null) {
            //这个位置，把ContentView放在Loading的下面
            rootView.addView(mContentView, 0);
            return rootView;
        } else {
            return super.onCreateView(inflater, container, savedInstanceState);
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.mContext = getDialog().getContext();
        //抽象方法，子类通过实现它，在其中实例化View
        initView(view);
    }

    @Override
    public void onStart() {
        super.onStart();
        //初始化窗口大小
        initWindow();
        //DialogFragment需要的参数可以通过Bundle传递
        resolveBundle(getArguments());
        //初始化页面数据
        initData();
    }

    //默认实现onClick方法，子类需要处理点击事件时再覆写该方法
    @Override
    public void onClick(View v) {

    }

    //给View绑定点击事件
    protected void bindViewClickListener(int id) {
        if (id <= 0) {
            return;
        }
        View view = mContentView.findViewById(id);
        if (view != null) {
            view.setOnClickListener(this);
        }
    }


    /**
     * 获取资源ID
     *
     * @return
     */
    protected abstract int getLayoutResId();

    /**
     * 初始化视图
     *
     * @param view
     */
    protected abstract void initView(View view);

    /**
     * 解析参数
     *
     * @param args
     */
    protected abstract void resolveBundle(Bundle args);

    /**
     * 初始化数据
     */
    protected abstract void initData();


    /**
     * 显示弹窗
     *
     * @param manager
     * @param args    封装了参数的Bundle对象
     * @param tag
     */
    public void showDialog(FragmentManager manager, Bundle args, String tag) {
        if (isAdded()) {
            //避免重复添加改Dialog
            return;
        }
        this.setArguments(args);
        super.show(manager, tag);
    }

    /**
     * 初始化窗口属性
     */
    protected void initWindow() {
        //设置窗口属性
        configWindowPercent(Gravity.CENTER, 0.8f, 0.1f);
    }

    /**
     * 设置弹窗位置
     * 设置弹窗大小（固定大小）
     */
    protected void configWindowFixSize(int gravity, int width, int height) {
        getDialog().getWindow().setGravity(gravity);
        getDialog().getWindow().setLayout(width, height);
    }

    /**
     * 设置弹窗位置
     * 设置弹窗大小（按屏幕比例）
     */
    protected void configWindowPercent(int gravity, float widthPercent, float heightPercent) {


        WindowManager.LayoutParams params = getDialog().getWindow().getAttributes();
        params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        params.width = ViewGroup.LayoutParams.MATCH_PARENT;
        getDialog().getWindow().setAttributes((WindowManager.LayoutParams) params);
    }
}



