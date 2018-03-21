package com.zonsim.nestedscroll.nestingscroll;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.view.NestedScrollingChild;
import android.support.v4.view.NestedScrollingChildHelper;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * desc
 * <p>
 * Created by tangjunwei on 2018/3/21.
 * <a href="mailto:tjwabc@gmail.com">Contact me</a>
 * <a href="https://github.com/tangjw">Follow me</a>
 */
public class NestedChildView extends View implements NestedScrollingChild {
    private static String tag = "NestedChildView";
    private float mLastX;
    private float mLastY;
    
    private float mDownX;
    private float mDownY;
    
    private int[] consumed = new int[2];
    private int[] offsetInWindow = new int[2];
    
    private NestedScrollingChildHelper mNestedScrollingChildHelper;
    
    public NestedChildView(Context context) {
        super(context);
        init();
    }
    
    public NestedChildView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    
    public NestedChildView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    
    private void init() {
        mNestedScrollingChildHelper = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
    }
    
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        
        float x = event.getX();
        float y = event.getY();
        
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                performClick();
                mDownX = x;
                mDownY = y;
                mLastX = x;
                mLastY = y;
                
                startNestedScroll(ViewCompat.SCROLL_AXIS_HORIZONTAL | ViewCompat.SCROLL_AXIS_VERTICAL);
                
                break;
            
            case MotionEvent.ACTION_MOVE:
                int dx = (int) (x - mDownX);
                int dy = (int) (y - mDownY);
                
                if (dispatchNestedPreScroll(dx, dy, consumed, offsetInWindow)) {
                    dx -= consumed[0];
                    dy -= consumed[1];
                }
                
                offsetLeftAndRight(dx);
                offsetTopAndBottom(dy);
                break;
            
            case MotionEvent.ACTION_UP:
                stopNestedScroll();
                break;
        }
        
        mLastX = x;
        mLastY = y;
        
        return true;
    }
    
    @Override
    public boolean performClick() {
        return super.performClick();
    }
    
    @Override
    public void setNestedScrollingEnabled(boolean enabled) {
        System.out.println(tag + " setNestedScrollingEnabled");
        mNestedScrollingChildHelper.setNestedScrollingEnabled(enabled);
    }
    
    @Override
    public boolean isNestedScrollingEnabled() {
        System.out.println(tag + " isNestedScrollingEnabled");
        return mNestedScrollingChildHelper.isNestedScrollingEnabled();
    }
    
    @Override
    public boolean startNestedScroll(int axes) {
        System.out.println(tag + " startNestedScroll");
        return mNestedScrollingChildHelper.startNestedScroll(axes);
    }
    
    @Override
    public void stopNestedScroll() {
        System.out.println(tag + " stopNestedScroll");
        mNestedScrollingChildHelper.stopNestedScroll();
    }
    
    @Override
    public boolean hasNestedScrollingParent() {
        System.out.println(tag + " hasNestedScrollingParent");
        return mNestedScrollingChildHelper.hasNestedScrollingParent();
    }
    
    @Override
    public boolean dispatchNestedScroll(int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, @Nullable int[] offsetInWindow) {
        System.out.println(tag + " dispatchNestedScroll");
        return mNestedScrollingChildHelper.dispatchNestedScroll(dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, offsetInWindow);
    }
    
    @Override
    public boolean dispatchNestedPreScroll(int dx, int dy, @Nullable int[] consumed, @Nullable int[] offsetInWindow) {
        System.out.println(tag + " dispatchNestedPreScroll");
        return mNestedScrollingChildHelper.dispatchNestedPreScroll(dx, dy, consumed, offsetInWindow);
    }
    
    @Override
    public boolean dispatchNestedFling(float velocityX, float velocityY, boolean consumed) {
        System.out.println(tag + " dispatchNestedFling");
        return mNestedScrollingChildHelper.dispatchNestedFling(velocityX, velocityY, consumed);
    }
    
    @Override
    public boolean dispatchNestedPreFling(float velocityX, float velocityY) {
        System.out.println(tag + " dispatchNestedPreFling");
        return mNestedScrollingChildHelper.dispatchNestedPreFling(velocityX, velocityY);
    }
    
    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mNestedScrollingChildHelper.onDetachedFromWindow();
    }
    
}
