package com.hongliang.demo;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * https://www.cnblogs.com/mengdd/p/5582244.html
 */
public class BaseFragment extends Fragment {


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i("LOG", this.getClass().getName() + "：onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("LOG", this.getClass().getName() + "：onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i("LOG", this.getClass().getName() + "：onCreateView");
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.i("LOG", this.getClass().getName() + "：onViewCreated");
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i("LOG", this.getClass().getName() + "：onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i("LOG", this.getClass().getName() + "：onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("LOG", this.getClass().getName() + "：onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i("LOG", this.getClass().getName() + "：onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i("LOG", this.getClass().getName() + "：onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i("LOG", this.getClass().getName() + "：onDestroyView");
    }


    @Override
    public void onDetach() {
        super.onDetach();
        Log.i("LOG", this.getClass().getName() + "：onDetach");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("LOG", this.getClass().getName() + "：onDestroy");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i("LOG", this.getClass().getName() + "：onSaveInstanceState");
    }


    /**
     * 它并不是实例状态恢复的方法, 只是一个View状态恢复的回调.
     * /在onActivityCreated()和onStart()之间调用
     * @param savedInstanceState
     */
    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        Log.i("LOG", this.getClass().getName() + "：onViewStateRestored");
    }
}
