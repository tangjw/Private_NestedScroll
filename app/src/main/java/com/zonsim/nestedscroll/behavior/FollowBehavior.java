package com.zonsim.nestedscroll.behavior;

import android.content.Context;
import android.graphics.Rect;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.WindowInsetsCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * desc
 * <p>
 * Created by tangjunwei on 2018/3/26.
 * <a href="mailto:tjwabc@gmail.com">Contact me</a>
 * <a href="https://github.com/tangjw">Follow me</a>
 */
public class FollowBehavior extends CoordinatorLayout.Behavior<RelativeLayout> {
    
    private String tag = "FollowBehavior ";
    
    public FollowBehavior() {
        System.out.println(tag + "空参构造");
    }
    
    public FollowBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
        System.out.println(tag + "有参构造");
    }
    
    @Override
    public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams params) {
        System.out.println(tag + "onAttachedToLayoutParams");
    }
    
    @Override
    public void onDetachedFromLayoutParams() {
        System.out.println(tag + "onDetachedFromLayoutParams");
    }
    
    @Override
    public boolean onInterceptTouchEvent(CoordinatorLayout parent, RelativeLayout child, MotionEvent ev) {
        System.out.println(tag + "onInterceptTouchEvent");
        return super.onInterceptTouchEvent(parent, child, ev);
    }
    
    @Override
    public boolean onTouchEvent(CoordinatorLayout parent, RelativeLayout child, MotionEvent ev) {
        System.out.println(tag + "onTouchEvent");
        return super.onTouchEvent(parent, child, ev);
    }
    
    @Override
    public int getScrimColor(CoordinatorLayout parent, RelativeLayout child) {
        System.out.println(tag + "getScrimColor");
        return super.getScrimColor(parent, child);
    }
    
    @Override
    public float getScrimOpacity(CoordinatorLayout parent, RelativeLayout child) {
        System.out.println(tag + "getScrimOpacity");
        return super.getScrimOpacity(parent, child);
    }
    
    @Override
    public boolean blocksInteractionBelow(CoordinatorLayout parent, RelativeLayout child) {
        System.out.println(tag + "blocksInteractionBelow");
        return super.blocksInteractionBelow(parent, child);
    }
    
    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, RelativeLayout child, View dependency) {
        System.out.println(tag + "layoutDependsOn");
        return super.layoutDependsOn(parent, child, dependency);
    }
    
    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, RelativeLayout child, View dependency) {
        System.out.println(tag + "onDependentViewChanged");
        return super.onDependentViewChanged(parent, child, dependency);
    }
    
    @Override
    public void onDependentViewRemoved(CoordinatorLayout parent, RelativeLayout child, View dependency) {
        System.out.println(tag + "onDependentViewRemoved");
        super.onDependentViewRemoved(parent, child, dependency);
    }
    
    @Override
    public boolean onMeasureChild(CoordinatorLayout parent, RelativeLayout child, int parentWidthMeasureSpec, int widthUsed, int parentHeightMeasureSpec, int heightUsed) {
        System.out.println(tag + "onMeasureChild");
        return super.onMeasureChild(parent, child, parentWidthMeasureSpec, widthUsed, parentHeightMeasureSpec, heightUsed);
    }
    
    @Override
    public boolean onLayoutChild(CoordinatorLayout parent, RelativeLayout child, int layoutDirection) {
        System.out.println(tag + "onLayoutChild");
        return super.onLayoutChild(parent, child, layoutDirection);
    }
    
    @Override
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull RelativeLayout child, @NonNull View directTargetChild, @NonNull View target, int axes, int type) {
        System.out.println(tag + "onStartNestedScroll");
        //return super.onStartNestedScroll(coordinatorLayout, child, directTargetChild, target, axes, type);
        return true;
    }
    
    @Override
    public void onNestedScrollAccepted(@NonNull CoordinatorLayout coordinatorLayout, @NonNull RelativeLayout child, @NonNull View directTargetChild, @NonNull View target, int axes, int type) {
        System.out.println(tag + "onNestedScrollAccepted");
        super.onNestedScrollAccepted(coordinatorLayout, child, directTargetChild, target, axes, type);
    }
    
    @Override
    public void onStopNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull RelativeLayout child, @NonNull View target, int type) {
        System.out.println(tag + "onStopNestedScroll");
        super.onStopNestedScroll(coordinatorLayout, child, target, type);
    }
    
    @Override
    public void onNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull RelativeLayout child, @NonNull View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type) {
        System.out.println(tag + "onNestedScroll");
        System.out.println("onNestedScroll dyConsumed: " + dyConsumed);
        System.out.println("onNestedScroll dyUnconsumed: " + dyUnconsumed);
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, type);
    }
    
    @Override
    public void onNestedPreScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull RelativeLayout child, @NonNull View target, int dx, int dy, @NonNull int[] consumed, int type) {
        System.out.println(tag + "onNestedPreScroll");
        System.out.println("onNestedPreScroll dy: " + dy);
        int height = child.getHeight();
    
        /*if (dy != 0) {
            int min, max;
            if (dy < 0) {
                // We're scrolling down
                min = -child.getTotalScrollRange();
                max = min + child.getDownNestedPreScrollRange();
            } else {
                // We're scrolling up
                min = -child.getUpNestedPreScrollRange();
                max = 0;
            }
            if (min != max) {
                consumed[1] = scroll(coordinatorLayout, child, dy, min, max);
            }
        }*/
    
        //ViewCompat.offsetTopAndBottom(child, -dy);
    
        //super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed, type);
    }
    
    @Override
    public boolean onNestedFling(@NonNull CoordinatorLayout coordinatorLayout, @NonNull RelativeLayout child, @NonNull View target, float velocityX, float velocityY, boolean consumed) {
        System.out.println(tag + "onNestedFling");
        return super.onNestedFling(coordinatorLayout, child, target, velocityX, velocityY, consumed);
    }
    
    @Override
    public boolean onNestedPreFling(@NonNull CoordinatorLayout coordinatorLayout, @NonNull RelativeLayout child, @NonNull View target, float velocityX, float velocityY) {
        System.out.println(tag + "onNestedPreFling");
        return super.onNestedPreFling(coordinatorLayout, child, target, velocityX, velocityY);
    }
    
    @NonNull
    @Override
    public WindowInsetsCompat onApplyWindowInsets(CoordinatorLayout coordinatorLayout, RelativeLayout child, WindowInsetsCompat insets) {
        return super.onApplyWindowInsets(coordinatorLayout, child, insets);
    }
    
    @Override
    public boolean onRequestChildRectangleOnScreen(CoordinatorLayout coordinatorLayout, RelativeLayout child, Rect rectangle, boolean immediate) {
        return super.onRequestChildRectangleOnScreen(coordinatorLayout, child, rectangle, immediate);
    }
    
    @Override
    public void onRestoreInstanceState(CoordinatorLayout parent, RelativeLayout child, Parcelable state) {
        super.onRestoreInstanceState(parent, child, state);
    }
    
    @Override
    public Parcelable onSaveInstanceState(CoordinatorLayout parent, RelativeLayout child) {
        return super.onSaveInstanceState(parent, child);
    }
    
    @Override
    public boolean getInsetDodgeRect(@NonNull CoordinatorLayout parent, @NonNull RelativeLayout child, @NonNull Rect rect) {
        return super.getInsetDodgeRect(parent, child, rect);
    }
}
