package com.hongliang.demo.otherActivity.draeable;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hongliang.demo.R;

public class ShapeDrawable extends Fragment {

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Log.i("LOG", "onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("LOG", "onCreate");
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = getLayoutInflater().inflate(R.layout.layout_fragment_shape_drawable, null);
        Log.i("LOG", "onCreateView");
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i("LOG", "onActivityCreated");
    }



    @Override
    public void onDestroyView() {
        Log.i("LOG", "onDestroyView");
        super.onDestroyView();
    }

    @Override
    public void onDetach() {
        Log.i("LOG", "onDetach");
        super.onDetach();
    }

    @Override
    public void onDestroy() {
        Log.i("LOG", "onDestroy");
        super.onDestroy();
    }
}
