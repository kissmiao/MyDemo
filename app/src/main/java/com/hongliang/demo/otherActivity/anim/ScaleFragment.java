package com.hongliang.demo.otherActivity.anim;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

import com.hongliang.demo.BaseFragment;
import com.hongliang.demo.R;

public class ScaleFragment extends BaseFragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = getLayoutInflater().inflate(R.layout.anim_scale, null);
        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageView imageView = view.findViewById(R.id.iv_scale);
        ScaleAnimation alphaAnimation = (ScaleAnimation) AnimationUtils.loadAnimation(getContext(), R.anim.anim_scale);
        imageView.startAnimation(alphaAnimation);
    }
}
