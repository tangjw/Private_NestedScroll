package com.zonsim.nestedscroll.nestingscroll;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.NestedScrollingParent;
import android.support.v4.view.NestedScrollingParentHelper;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.OverScroller;

import com.zonsim.nestedscroll.R;

/**
 * desc
 * <p>
 * Created by tangjunwei on 2018/3/22.
 * <a href="mailto:tjwabc@gmail.com">Contact me</a>
 * <a href="https://github.com/tangjw">Follow me</a>
 */
public class MyParentLayout extends LinearLayout implements NestedScrollingParent {
    
    private static String tag = "MyParentLayout";
    private NestedScrollingParentHelper mNestedScrollingParentHelper;
    OverScroller mScroller;
    private int mScrollY;
    private int maxScrollY = 600;
    
    public MyParentLayout(@NonNull Context context) {
        super(context);
        init();
    }
    
    public MyParentLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    
    public MyParentLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    
    
    private void init() {
        mScroller = new OverScroller(getContext());
        mNestedScrollingParentHelper = new NestedScrollingParentHelper(this);
    }
    
    @Override
    public boolean onStartNestedScroll(@NonNull View child, @NonNull View target, int axes) {
        System.out.println(tag + " onStartNestedScroll");
        return true;
    }
    
    @Override
    public void onNestedScrollAccepted(@NonNull View child, @NonNull View target, int axes) {
        System.out.println(tag + " onNestedScrollAccepted");
        mNestedScrollingParentHelper.onNestedScrollAccepted(child, target, axes);
    }
    
    @Override
    public void onStopNestedScroll(@NonNull View target) {
        System.out.println(tag + " onStopNestedScroll");
        mNestedScrollingParentHelper.onStopNestedScroll(target);
    }
    
    @Override
    public void onNestedScroll(@NonNull View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        System.out.println(tag + " onStopNestedScroll");
    }
    
    @Override
    public void scrollTo(int x, int y) {
        //校准 y 防止向下滚动
        y = y < 0 ? 0 : y;
        
        if (y != getScrollY()) {
            super.scrollTo(x, y);
        }
        
    }
    
    @Override
    public void onNestedPreScroll(@NonNull final View target, int dx, int dy, @NonNull int[] consumed) {
        System.out.println(tag + " onNestedPreScroll");
        System.out.println("dx " + dx + " onNestedPreScroll");
        System.out.println("dy " + dy + " onNestedPreScroll");
        System.out.println("consumed[0] " + consumed[0] + " onNestedPreScroll");
        System.out.println("consumed[1] " + consumed[1] + " onNestedPreScroll");
        
        switch (target.getId()) {
            case R.id.fl:
                mScrollY -= dy;
                mScrollY = mScrollY < 0 ? 0 : mScrollY;
                mScrollY = mScrollY > 600 ? 600 : mScrollY;
                if (mScrollY <= 600 && mScrollY >= 0) {
                    scrollBy(0, -dy);
                }
                System.out.println("MyChildFrameLayout  onNestedPreScroll" + mScrollY);
                break;
            case R.id.scrollView:
                scrollBy(0, dy);
                System.out.println("MyChildScrollView  onNestedPreScroll");
                break;
            case R.id.rv:
                scrollBy(0, dy);
                System.out.println("MyChildRecyclerView  onNestedPreScroll");
                break;
        }
        
        // offsetTopAndBottom(dy);
    }
    
    @Override
    public boolean onNestedFling(@NonNull View target, float velocityX, float velocityY, boolean consumed) {
        System.out.println(tag + " onNestedFling");
        return false;
    }
    
    @Override
    public boolean onNestedPreFling(@NonNull View target, float velocityX, float velocityY) {
        System.out.println(tag + " onNestedPreFling");
        if (velocityY > 0 && getScrollY() < maxScrollY) {// 向上滑动, 且当前View还没滑到最顶部
            fling((int) velocityY, maxScrollY);
            return true;
        } else if (velocityY < 0 && getScrollY() > 0) {// 向下滑动, 且当前View部分在屏幕外
            fling((int) velocityY, 0);
            return true;
        }
        return false;
    }
    
   /* @Override
    public int getNestedScrollAxes() {
        System.out.println(tag + " getNestedScrollAxes");
        return mNestedScrollingParentHelper.getNestedScrollAxes();
    }*/
    
    @Override
    public int getNestedScrollAxes() {
        System.out.println(tag + " getNestedScrollAxes");
        return mNestedScrollingParentHelper.getNestedScrollAxes();
    }
    
    private void fling(int velocityY, int maxY) {
        mScroller.fling(0, getScrollY(), 0, velocityY, 0, 0, 0, maxY);
        invalidate();
        //postInvalidate();
    }
    
}
