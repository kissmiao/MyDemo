package com.hongliang.demo.otherActivity.draeable;


import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.hongliang.demo.R;

public class TransitionDrawableFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = getLayoutInflater().inflate(R.layout.layout_fragment_transitiondrawable, null);
        init(view);
        return view;

    }

    private void init(View view) {
        ImageView button = (ImageButton) view.findViewById(R.id.image_button);

        final TransitionDrawable drawable = (TransitionDrawable) button.getDrawable();
        button.setOnClickListener(new View.OnClickListener() {
            boolean change = false;

            @Override
            public void onClick(View v) {
                if (change) {
                    drawable.reverseTransition(1000);
                    change = false;
                } else {
                    drawable.startTransition(1000);
                    change = true;
                }

            }
        });
    }


}
