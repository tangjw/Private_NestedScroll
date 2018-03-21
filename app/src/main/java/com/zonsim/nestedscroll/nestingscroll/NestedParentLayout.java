package com.zonsim.nestedscroll.nestingscroll;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.NestedScrollingParent;
import android.support.v4.view.NestedScrollingParentHelper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

/**
 * desc
 * <p>
 * Created by tangjunwei on 2018/3/21.
 * <a href="mailto:tjwabc@gmail.com">Contact me</a>
 * <a href="https://github.com/tangjw">Follow me</a>
 */
public class NestedParentLayout extends FrameLayout implements NestedScrollingParent {
    
    private static String tag = "NestedParentLayout";
    
    private float mLastX;
    private float mLastY;
    
    private float mDownX;
    private float mDownY;
    
    private NestedScrollingParentHelper mNestedScrollingParentHelper;
    
    public NestedParentLayout(@NonNull Context context) {
        super(context);
        init();
    }
    
    public NestedParentLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    
    public NestedParentLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    
    private void init() {
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
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                performClick();
                mDownX = x;
                mDownY = y;
                
                // onStartNestedScroll(ViewCompat.SCROLL_AXIS_HORIZONTAL | ViewCompat.SCROLL_AXIS_VERTICAL);
                
                break;
            
            case MotionEvent.ACTION_MOVE:
                int dx = (int) (x - mDownX);
                int dy = (int) (y - mDownY);
        
                /*if (dispatchNestedPreScroll(dx, dy, consumed, offsetInWindow)) {
                    dx -= consumed[0];
                    dy -= consumed[1];
                }*/
                
                offsetLeftAndRight(dx);
                offsetTopAndBottom(dy);
                break;
            
            case MotionEvent.ACTION_UP:
                // stopNestedScroll();
                break;
        }
        
        return true;
    }
    
    @Override
    public void onNestedPreScroll(@NonNull final View target, int dx, int dy, @NonNull int[] consumed) {
        System.out.println(tag + " onNestedPreScroll");
        if (dx > 0) {
            if (target.getRight() + dx > getWidth()) {
                dx = target.getRight() + dx - getWidth();//多出来的
                offsetLeftAndRight(dx);
                consumed[0] += dx;//父亲消耗
            }
            
        } else {
            if (target.getLeft() + dx < 0) {
                dx = dx + target.getLeft();
                offsetLeftAndRight(dx);
                consumed[0] += dx;//父亲消耗
            }
            
        }
        
        if (dy > 0) {
            if (target.getBottom() + dy > getHeight()) {
                dy = target.getBottom() + dy - getHeight();
                offsetTopAndBottom(dy);
                consumed[1] += dy;
            }
        } else {
            if (target.getTop() + dy < 0) {
                dy = dy + target.getTop();
                offsetTopAndBottom(dy);
                consumed[1] += dy;//父亲消耗
            }
        }
        
    }
    
    @Override
    public boolean onNestedFling(@NonNull View target, float velocityX, float velocityY, boolean consumed) {
        System.out.println(tag + " onNestedFling");
        return false;
    }
    
    @Override
    public boolean onNestedPreFling(@NonNull View target, float velocityX, float velocityY) {
        System.out.println(tag + " onNestedPreFling");
        return false;
    }
    
    @Override
    public int getNestedScrollAxes() {
        System.out.println(tag + " getNestedScrollAxes");
        return mNestedScrollingParentHelper.getNestedScrollAxes();
    }
    
}
