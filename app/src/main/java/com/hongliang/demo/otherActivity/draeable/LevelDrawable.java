package com.hongliang.demo.otherActivity.draeable;

import android.media.Image;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.hongliang.demo.R;

public class LevelDrawable extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = getLayoutInflater().inflate(R.layout.layout_fragment_level_drawable, null);
        init(view);
        return view;
    }

    private void init(View view) {
        ImageView view1 = view.findViewById(R.id.iv_level);
        Button button = view.findViewById(R.id.ll_change);
        button.setOnClickListener(new View.OnClickListener() {
            boolean change = false;

            @Override
            public void onClick(View v) {
                if (change) {
                    setImage(view1, 1);
                    change = false;
                } else {
                    setImage(view1, 2);
                    change = true;
                }

            }
        });
    }

    private void setImage(ImageView view, int level) {
        view.setImageLevel(level);
    }
}
