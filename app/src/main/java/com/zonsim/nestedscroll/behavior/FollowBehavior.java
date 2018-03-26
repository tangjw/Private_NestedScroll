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
import android.widget.Button;
import android.widget.TextView;

/**
 * desc
 * <p>
 * Created by tangjunwei on 2018/3/26.
 * <a href="mailto:tjwabc@gmail.com">Contact me</a>
 * <a href="https://github.com/tangjw">Follow me</a>
 */
public class FollowBehavior extends CoordinatorLayout.Behavior<TextView> {
    public FollowBehavior() {
    }
    
    public FollowBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    
    /**
     * super. 返回 默认false
     *
     * @param parent
     * @param child
     * @param dependency
     * @return
     */
    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, TextView child, View dependency) {
        return dependency instanceof Button;
    }
    
    /**
     * super. 返回 默认false
     *
     * @param parent
     * @param child
     * @param dependency
     * @return
     */
    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, TextView child, View dependency) {
        
        child.setX(dependency.getX() + 100);
        child.setY(dependency.getY() + 100);
        
        return true;
    }
    
    
    @Override
    public void onNestedPreScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull TextView child, @NonNull View target, int dx, int dy, @NonNull int[] consumed, int type) {
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed, type);
    }
    
    @Override
    public boolean onNestedPreFling(@NonNull CoordinatorLayout coordinatorLayout, @NonNull TextView child, @NonNull View target, float velocityX, float velocityY) {
        return super.onNestedPreFling(coordinatorLayout, child, target, velocityX, velocityY);
    }
    
    @Override
    public boolean onTouchEvent(CoordinatorLayout parent, TextView child, MotionEvent ev) {
        return super.onTouchEvent(parent, child, ev);
    }
    
    @Override
    public boolean onInterceptTouchEvent(CoordinatorLayout parent, TextView child, MotionEvent ev) {
        return super.onInterceptTouchEvent(parent, child, ev);
    }
    
    @Override
    public boolean onLayoutChild(CoordinatorLayout parent, TextView child, int layoutDirection) {
        return super.onLayoutChild(parent, child, layoutDirection);
    }
    
    @Override
    public boolean onMeasureChild(CoordinatorLayout parent, TextView child, int parentWidthMeasureSpec, int widthUsed, int parentHeightMeasureSpec, int heightUsed) {
        return super.onMeasureChild(parent, child, parentWidthMeasureSpec, widthUsed, parentHeightMeasureSpec, heightUsed);
    }
    
    @Override
    public boolean onNestedFling(@NonNull CoordinatorLayout coordinatorLayout, @NonNull TextView child, @NonNull View target, float velocityX, float velocityY, boolean consumed) {
        return super.onNestedFling(coordinatorLayout, child, target, velocityX, velocityY, consumed);
    }
    
    @Override
    public boolean onRequestChildRectangleOnScreen(CoordinatorLayout coordinatorLayout, TextView child, Rect rectangle, boolean immediate) {
        return super.onRequestChildRectangleOnScreen(coordinatorLayout, child, rectangle, immediate);
    }
    
    @Override
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull TextView child, @NonNull View directTargetChild, @NonNull View target, int axes, int type) {
        return super.onStartNestedScroll(coordinatorLayout, child, directTargetChild, target, axes, type);
    }
    
    @Override
    public void onDependentViewRemoved(CoordinatorLayout parent, TextView child, View dependency) {
        super.onDependentViewRemoved(parent, child, dependency);
    }
    
    @Override
    public void onStopNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull TextView child, @NonNull View target, int type) {
        super.onStopNestedScroll(coordinatorLayout, child, target, type);
    }
    
    @Override
    public void onNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull TextView child, @NonNull View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type) {
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, type);
    }
    
    @Override
    public void onNestedScrollAccepted(@NonNull CoordinatorLayout coordinatorLayout, @NonNull TextView child, @NonNull View directTargetChild, @NonNull View target, int axes, int type) {
        super.onNestedScrollAccepted(coordinatorLayout, child, directTargetChild, target, axes, type);
    }
    
    @Override
    public void onRestoreInstanceState(CoordinatorLayout parent, TextView child, Parcelable state) {
        super.onRestoreInstanceState(parent, child, state);
    }
    
    @Override
    public Parcelable onSaveInstanceState(CoordinatorLayout parent, TextView child) {
        return super.onSaveInstanceState(parent, child);
    }
    
    @Override
    public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams params) {
        super.onAttachedToLayoutParams(params);
    }
    
    @Override
    public void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
    }
    
    @NonNull
    @Override
    public WindowInsetsCompat onApplyWindowInsets(CoordinatorLayout coordinatorLayout, TextView child, WindowInsetsCompat insets) {
        return super.onApplyWindowInsets(coordinatorLayout, child, insets);
    }
    
    @Override
    public boolean getInsetDodgeRect(@NonNull CoordinatorLayout parent, @NonNull TextView child, @NonNull Rect rect) {
        return super.getInsetDodgeRect(parent, child, rect);
    }
}
