package com.zonsim.nestedscroll.nestingscroll;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.NestedScrollingChild;
import android.support.v4.view.NestedScrollingChildHelper;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.OverScroller;

/**
 * desc
 * <p>
 * Created by tangjunwei on 2018/3/22.
 * <a href="mailto:tjwabc@gmail.com">Contact me</a>
 * <a href="https://github.com/tangjw">Follow me</a>
 */
public class MyFrameLayout extends FrameLayout implements NestedScrollingChild {
    
    private static String tag = "MyFrameLayout";
    private NestedScrollingChildHelper mChildHelper;
    private float mDownX;
    private float mDownY;
    
    private int[] consumed = new int[2];
    private int[] offsetInWindow = new int[2];
    private OverScroller mScroller;
    
    private void init() {
        mScroller = new OverScroller(getContext());
        mChildHelper = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
    }
    
    public MyFrameLayout(@NonNull Context context) {
        super(context);
        init();
    }
    
    public MyFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    
    public MyFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
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
                startNestedScroll(ViewCompat.SCROLL_AXIS_VERTICAL);
                
                break;
            case MotionEvent.ACTION_MOVE:
                int dx = (int) (x - mDownX);
                int dy = (int) (y - mDownY);
                if (dispatchNestedPreScroll(dx, dy, consumed, offsetInWindow)) {
                    dx -= consumed[0];
                    dy -= consumed[1];
                }
                
                //offsetLeftAndRight(dx);
                scrollBy(dx, dy);
                
                break;
            case MotionEvent.ACTION_UP:
                stopNestedScroll();
                break;
        }
        
        return true;
    }
    
    @Override
    public void scrollTo(int x, int y) {
        
        y = y < 0 ? 0 : y;
        
        if (y != getScrollY()) {
            super.scrollTo(x, y);
        }
        
        super.scrollTo(x, y);
    }
    
    @Override
    public boolean performClick() {
        return super.performClick();
    }
    
    /**
     * 是否允许嵌套滚动
     *
     * @param enabled
     */
    @Override
    public void setNestedScrollingEnabled(boolean enabled) {
        System.out.println(tag + " setNestedScrollingEnabled");
        mChildHelper.setNestedScrollingEnabled(true);
    }
    
    @Override
    public boolean isNestedScrollingEnabled() {
        System.out.println(tag + " isNestedScrollingEnabled");
        return mChildHelper.isNestedScrollingEnabled();
    }
    
    /**
     * 开始嵌套滚动
     *
     * @param axes 支持滚动的方向
     * @return 返回true 支持嵌套滚动
     */
    @Override
    public boolean startNestedScroll(int axes) {
        System.out.println(tag + " startNestedScroll");
        return mChildHelper.startNestedScroll(ViewCompat.SCROLL_AXIS_VERTICAL);
    }
    
    @Override
    public void stopNestedScroll() {
        System.out.println(tag + " stopNestedScroll");
        mChildHelper.stopNestedScroll();
    }
    
    /**
     * @return 返回是否有支持嵌套滚动的 Parent
     */
    @Override
    public boolean hasNestedScrollingParent() {
        System.out.println(tag + " hasNestedScrollingParent");
        return mChildHelper.hasNestedScrollingParent();
    }
    
    /**
     * Dispatch one step of a nested scroll in progress before this view consumes any portion of it.
     * <p>
     * <p>Nested pre-scroll events are to nested scroll events what touch intercept is to touch.
     * <code>dispatchNestedPreScroll</code> offers an opportunity for the parent view in a nested
     * scrolling operation to consume some or all of the scroll operation before the child view
     * consumes it.</p>
     *
     * @param dx             Horizontal scroll distance in pixels
     * @param dy             Vertical scroll distance in pixels
     * @param consumed       Output. If not null, consumed[0] will contain the consumed component of dx
     *                       and consumed[1] the consumed dy.
     * @param offsetInWindow Optional. If not null, on return this will contain the offset
     *                       in local view coordinates of this view from before this operation
     *                       to after it completes. View implementations may use this to adjust
     *                       expected input coordinate tracking.
     * @return true if the parent consumed some or all of the scroll delta
     * @see #dispatchNestedScroll(int, int, int, int, int[])
     */
    @Override
    public boolean dispatchNestedPreScroll(int dx, int dy, @Nullable int[] consumed, @Nullable int[] offsetInWindow) {
        System.out.println(tag + " dispatchNestedPreScroll");
        return mChildHelper.dispatchNestedPreScroll(dx, dy, consumed, offsetInWindow);
    }
    
    /**
     * Dispatch one step of a nested scroll in progress.
     * <p>
     * <p>Implementations of views that support nested scrolling should call this to report
     * info about a scroll in progress to the current nested scrolling parent. If a nested scroll
     * is not currently in progress or nested scrolling is not
     * {@link #isNestedScrollingEnabled() enabled} for this view this method does nothing.</p>
     * <p>
     * <p>Compatible View implementations should also call
     * {@link #dispatchNestedPreScroll(int, int, int[], int[]) dispatchNestedPreScroll} before
     * consuming a component of the scroll event themselves.</p>
     *
     * @param dxConsumed     Horizontal distance in pixels consumed by this view during this scroll step
     * @param dyConsumed     Vertical distance in pixels consumed by this view during this scroll step
     * @param dxUnconsumed   Horizontal scroll distance in pixels not consumed by this view
     * @param dyUnconsumed   Horizontal scroll distance in pixels not consumed by this view
     * @param offsetInWindow Optional. If not null, on return this will contain the offset
     *                       in local view coordinates of this view from before this operation
     *                       to after it completes. View implementations may use this to adjust
     *                       expected input coordinate tracking.
     * @return true if the event was dispatched, false if it could not be dispatched.
     * @see #dispatchNestedPreScroll(int, int, int[], int[])
     */
    @Override
    public boolean dispatchNestedScroll(int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, @Nullable int[] offsetInWindow) {
        System.out.println(tag + " dispatchNestedScroll");
        return mChildHelper.dispatchNestedScroll(dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, offsetInWindow);
    }
    
    @Override
    public boolean dispatchNestedPreFling(float velocityX, float velocityY) {
        System.out.println(tag + " dispatchNestedPreFling");
        return mChildHelper.dispatchNestedPreFling(velocityX, velocityY);
    }
    
    @Override
    public boolean dispatchNestedFling(float velocityX, float velocityY, boolean consumed) {
        System.out.println(tag + " dispatchNestedFling");
        return mChildHelper.dispatchNestedFling(velocityX, velocityY, consumed);
    }
    
    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mChildHelper.onDetachedFromWindow();
    }
    
    private void fling(int velocityY, int maxY) {
        mScroller.fling(0, getScrollY(), 0, velocityY, 0, 0, 0, maxY);
        invalidate();
        //postInvalidate();
    }
}
