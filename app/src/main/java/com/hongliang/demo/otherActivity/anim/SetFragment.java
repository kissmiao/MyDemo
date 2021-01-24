package com.hongliang.demo.otherActivity.anim;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.hongliang.demo.BaseFragment;
import com.hongliang.demo.R;

public class SetFragment extends BaseFragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = getLayoutInflater().inflate(R.layout.anim_set, null);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageView imageView = view.findViewById(R.id.iv_set);
        AnimationSet alphaAnimation = (AnimationSet) AnimationUtils.loadAnimation(getContext(), R.anim.anim_set);
        imageView.startAnimation(alphaAnimation);
    }
}
