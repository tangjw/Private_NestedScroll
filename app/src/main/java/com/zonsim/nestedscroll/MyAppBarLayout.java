package com.zonsim.nestedscroll;

import android.content.Context;
import android.os.Build;
import android.support.design.widget.AppBarLayout;
import android.util.AttributeSet;

/**
 * desc
 * <p>
 * Created by tangjunwei on 2018/3/15.
 * <a href="mailto:tjwabc@gmail.com">Contact me</a>
 * <a href="https://github.com/tangjw">Follow me</a>
 */
public class MyAppBarLayout extends AppBarLayout {
    public MyAppBarLayout(Context context) {
        super(context);
        setPaddingTop();
    }
    
    public MyAppBarLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        setPaddingTop();
        
    }
    
    private void setPaddingTop() {
        int compatPadingTop = 0;
        // android 4.4以上将Toolbar添加状态栏高度的上边距，沉浸到状态栏下方
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            compatPadingTop = getStatusBarHeight();
        }
        this.setPadding(getPaddingLeft(), getPaddingTop() + compatPadingTop, getPaddingRight(), getPaddingBottom());
    }
    
    public int getStatusBarHeight() {
        int statusBarHeight = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            statusBarHeight = getResources().getDimensionPixelSize(resourceId);
        }
        return statusBarHeight;
    }
    
}
