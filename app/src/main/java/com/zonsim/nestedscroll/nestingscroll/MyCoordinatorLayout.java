package com.zonsim.nestedscroll.nestingscroll;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;

/**
 * desc
 * <p>
 * Created by tangjunwei on 2018/3/26.
 * <a href="mailto:tjwabc@gmail.com">Contact me</a>
 * <a href="https://github.com/tangjw">Follow me</a>
 */
public class MyCoordinatorLayout extends CoordinatorLayout {
    public MyCoordinatorLayout(Context context) {
        super(context);
    }
    
    public MyCoordinatorLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    
    public MyCoordinatorLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    
    @Override
    public boolean onNestedPreFling(View target, float velocityX, float velocityY) {
        System.out.println("MyCoordinatorLayout velocityY: " + velocityY);
        return super.onNestedPreFling(target, velocityX, velocityY);
    }
    
    @Override
    public void onNestedPreScroll(View target, int dx, int dy, int[] consumed) {
        System.out.println("MyCoordinatorLayout dy: " + dy);
        super.onNestedPreScroll(target, dx, dy, consumed);
    }
}
