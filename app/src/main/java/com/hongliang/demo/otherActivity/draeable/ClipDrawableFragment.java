package com.hongliang.demo.otherActivity.draeable;

import android.animation.ValueAnimator;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.hongliang.demo.R;

public class ClipDrawableFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = getLayoutInflater().inflate(R.layout.layout_fragment_clip, null);
        init(view);
        return view;
    }

    private void init(View view) {
        ImageView button = view.findViewById(R.id.iv_clip_image);

        final ClipDrawable drawable = (ClipDrawable) button.getDrawable();
        ValueAnimator valueAnimator = ValueAnimator.ofInt(0, 10000);
        valueAnimator.setInterpolator(new DecelerateInterpolator());
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int leftMargin = (int) animation.getAnimatedValue();
                drawable.setLevel(leftMargin);
            }
        });
        valueAnimator.setDuration(2000);
        valueAnimator.start();

    }
}
