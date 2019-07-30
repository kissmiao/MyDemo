package com.hongliang.demo.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PixelFormat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.hongliang.demo.R;
import com.hongliang.demo.util.FloatingManager;

public class FloatingView extends FrameLayout {
    private Context mContext;
    private View mView;
    private ImageView mImv;
    private int mImgId;
    private int mTouchStartX, mTouchStartY;//手指按下时坐标
    private WindowManager.LayoutParams mParams;
    private FloatingManager mManager;
    private int tempX, tempY;
    private onFloatClicklistener mOnFloatClicklistener;
    private LinearLayout mLayout;
    private int startX, startY, endX, endY;

    public FloatingView(Context context) {
        this(context, null);
    }

    public FloatingView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FloatingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        init(attrs);
    }

    private void init(AttributeSet attrs) {

        Log.i("LOG", "init===========");
        initAttr(attrs);
        initViews();
    }

    private void initViews() {
        try {
            mView = LayoutInflater.from(mContext).inflate(R.layout.item_floating_view, null);
            mImv = mView.findViewById(R.id.imageview);
            mImv.setImageResource(mImgId);
            mManager = FloatingManager.getInstance(mContext);
            mLayout = mView.findViewById(R.id.ll_floating_container);
        } catch (Exception e) {
            throw new RuntimeException("cmo:init FloatingView erro");
        }
        mLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnFloatClicklistener.onFloatingClick();
            }
        });
        mView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        mTouchStartX = (int) event.getRawX();
                        mTouchStartY = (int) event.getRawY();
                        startX = (int) event.getRawX();
                        startY = (int) event.getRawY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        endX = (int) event.getRawX();
                        endY = (int) event.getRawY();
                        mParams.x = tempX + (int) event.getRawX() - mTouchStartX;
                        mParams.y = tempY + (int) event.getRawY() - mTouchStartY;
                        if (Math.abs(startX - endX) > 25 || Math.abs(startY - endY) > 25) {
                            mManager.updateView(mView, mParams);//移动的过程中及时更新View
                        }
                        break;
                    case MotionEvent.ACTION_CANCEL:
                    case MotionEvent.ACTION_UP:

                        tempX = mParams.x;
                        tempY = mParams.y;
                        break;
                }
                endX = (int) event.getRawX();
                endY = (int) event.getRawY();
                return false;
            }
        });
    }

    private void initAttr(AttributeSet attrs) {
        TypedArray typedArray = null;
        try {
            typedArray = mContext.obtainStyledAttributes(attrs, R.styleable.FloatingView);
            mImgId = typedArray.getResourceId(R.styleable.FloatingView_float_btn_src, R.mipmap.ic_launcher);
        } catch (Exception e) {
            throw new RuntimeException("cmo:init attrs failed!");
        } finally {
            if (typedArray != null) {
                typedArray.recycle();
            }
        }
    }

    public ImageView getImageView() {
        return this.mImv;
    }

    public void setImageView(int resId) {
        mImv.setImageResource(resId);
    }

    /**
     * 通过WindowManager 添加悬浮View
     */
    public void show() {
        mParams = new WindowManager.LayoutParams();
        mParams.gravity = Gravity.TOP | Gravity.LEFT;
        mParams.x = 0;
        mParams.y = 100;
        //总是出现在应用程序窗口之上
        mParams.type = WindowManager.LayoutParams.TYPE_TOAST;
        //设置图片格式，效果为背景透明
        mParams.format = PixelFormat.RGBA_8888;
        mParams.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL |
                WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN | WindowManager.LayoutParams.FLAG_LAYOUT_INSET_DECOR |
                WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH;
        mParams.width = WindowManager.LayoutParams.WRAP_CONTENT;
        mParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
        mManager.addView(mView, mParams);
        //逐帧动画
       /* AnimationDrawable animationDrawable=(AnimationDrawable)mImv.getDrawable();
        animationDrawable.start();
        */



    }

    public void hide() {
        mManager.removeView(mView);
    }

    public void setOnFloatingClickListener(onFloatClicklistener listener) {
        this.mOnFloatClicklistener = listener;
    }

    public interface onFloatClicklistener {
        void onFloatingClick();
    }
}
