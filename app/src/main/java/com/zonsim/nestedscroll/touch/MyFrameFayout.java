package com.zonsim.nestedscroll.touch;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/**
 * desc
 * <p>
 * Created by tangjunwei on 2018/3/21.
 * <a href="mailto:tjwabc@gmail.com">Contact me</a>
 * <a href="https://github.com/tangjw">Follow me</a>
 */
public class MyFrameFayout extends FrameLayout {
    public MyFrameFayout(Context context) {
        super(context);
    }
    
    public MyFrameFayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
    
    public MyFrameFayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                System.out.println("---MyFrameFayout onTouchEvent ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                System.out.println("---MyFrameFayout onTouchEvent ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                System.out.println("---MyFrameFayout onTouchEvent ACTION_UP");
                break;
        }
        return true;
    }
    
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                System.out.println("---MyFrameFayout dispatchTouchEvent ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                System.out.println("---MyFrameFayout dispatchTouchEvent ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                System.out.println("---MyFrameFayout dispatchTouchEvent ACTION_UP");
                break;
        }
        return super.dispatchTouchEvent(ev);
    }
    
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                System.out.println("---MyFrameFayout onInterceptTouchEvent ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                System.out.println("---MyFrameFayout onInterceptTouchEvent ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                System.out.println("---MyFrameFayout onInterceptTouchEvent ACTION_UP");
                break;
        }
        return super.onInterceptTouchEvent(ev);
    }
}
