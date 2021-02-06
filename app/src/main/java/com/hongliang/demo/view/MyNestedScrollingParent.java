package com.hongliang.demo.view;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.NestedScrollingParent2;
import android.support.v4.view.NestedScrollingParentHelper;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;

public class MyNestedScrollingParent extends LinearLayout implements NestedScrollingParent2 {
    private NestedScrollingParentHelper mParentHelper;
    private int mFirstChildHeight;

    public MyNestedScrollingParent(Context context) {
        this(context, null);
    }

    public MyNestedScrollingParent(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyNestedScrollingParent(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public MyNestedScrollingParent(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }



    private void init() {
        this.mParentHelper = new NestedScrollingParentHelper(this);
    }
    /**
     * 即将开始嵌套滑动，此时嵌套滑动尚未开始，由子控件的 startNestedScroll 方法调用
     *
     * @param child  嵌套滑动对应的父类的子类(因为嵌套滑动对于的父控件不一定是一级就能找到的，可能挑了两级父控件的父控件，child的辈分>=target)
     * @param target 具体嵌套滑动的那个子类
     * @param axes   嵌套滑动支持的滚动方向
     * @param type   嵌套滑动的类型，有两种ViewCompat.TYPE_NON_TOUCH fling效果,ViewCompat.TYPE_TOUCH 手势滑动
     * @return true 表示此父类开始接受嵌套滑动，只有true时候，才会执行下面的 onNestedScrollAccepted 等操作
     */
    @Override
    public boolean onStartNestedScroll(@NonNull View child, @NonNull View target, int axes, int type) {
     //   return false;
        Log.e("LOG","2-parent-onNestedScrollAccepted");
        return (ViewCompat.SCROLL_AXIS_VERTICAL & axes) != 0;
    }

    /**
     * 当onStartNestedScroll返回为true时，也就是父控件接受嵌套滑动时，该方法才会调用
     *
     * @param child
     * @param target
     * @param axes
     * @param type
     */
    @Override
    public void onNestedScrollAccepted(@NonNull View child, @NonNull View target, int axes, int type) {
        Log.e("LOG","3-parent-onNestedScrollAccepted");
        this.mParentHelper.onNestedScrollAccepted(child, target, axes, type);
    }


    /**
     * 停止滑动
     *
     * @param target
     * @param type     滑动类型，ViewCompat.TYPE_NON_TOUCH fling效果,ViewCompat.TYPE_TOUCH 手势滑动
     */
    @Override
    public void onStopNestedScroll(@NonNull View target, int type) {

    }

    /**
     * 在 onNestedPreScroll 中，父控件消耗一部分距离之后，剩余的再次给子控件，
     * 子控件消耗之后，如果还有剩余，则把剩余的再次还给父控件
     *
     * @param target       具体嵌套滑动的那个子类
     * @param dxConsumed   水平方向嵌套滑动的子控件滑动的距离(消耗的距离)
     * @param dyConsumed   垂直方向嵌套滑动的子控件滑动的距离(消耗的距离)
     * @param dxUnconsumed 水平方向嵌套滑动的子控件未滑动的距离(未消耗的距离)
     * @param dyUnconsumed 垂直方向嵌套滑动的子控件未滑动的距离(未消耗的距离)
     * @param type     滑动类型，ViewCompat.TYPE_NON_TOUCH fling效果,ViewCompat.TYPE_TOUCH 手势滑动
     */
    @Override
    public void onNestedScroll(@NonNull View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type) {
        Log.e("LOG","56-parent-onNestedScroll");
    }



    /**
     * 在 onNestedPreScroll 中，父控件消耗一部分距离之后，剩余的再次给子控件，
     * 子控件消耗之后，如果还有剩余，则把剩余的再次还给父控件
     *
     * @param target       具体嵌套滑动的那个子类
     * @param dx   水平方向嵌套滑动的子控件滑动的距离(消耗的距离)
     * @param dy   垂直方向嵌套滑动的子控件滑动的距离(消耗的距离)
     * @param consumed 水平方向嵌套滑动的子控件未滑动的距离(未消耗的距离)  垂直方向嵌套滑动的子控件未滑动的距离(未消耗的距离)
     * @param type     滑动类型，ViewCompat.TYPE_NON_TOUCH fling效果,ViewCompat.TYPE_TOUCH 手势滑动
     */
    @Override
    public void onNestedPreScroll(@NonNull View target, int dx, int dy, @NonNull int[] consumed, int type) {
        boolean isFirstChildVisible = (dy > 0 && this.getScrollY() < this.mFirstChildHeight)
                || (dy < 0 && target.getScrollY() <= 0);
        if (isFirstChildVisible) {
            //consume dy
            consumed[1] = dy;
            this.scrollBy(0, dy);
        }
    }


    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        final View firstChild = this.getChildAt(0);
        if (firstChild == null)
            throw new IllegalStateException(String.format("%s must own a child view", MyNestedScrollingParent.class.getSimpleName()));
        firstChild.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                MyNestedScrollingParent.this.mFirstChildHeight = firstChild.getMeasuredHeight();
                firstChild.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });

    }


    @Override
    public boolean onNestedPreFling(View target, float velocityX, float velocityY) {
        return super.onNestedPreFling(target, velocityX, velocityY);
    }

    @Override
    public void scrollTo(int x, int y) {
        y = y < 0 ? 0 : y;
        y = y > this.mFirstChildHeight ? this.mFirstChildHeight : y;
        super.scrollTo(x, y);
    }


}