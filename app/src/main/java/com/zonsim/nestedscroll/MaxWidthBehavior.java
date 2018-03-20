package com.zonsim.nestedscroll;

/**
 * desc
 * <p>
 * Created by tangjunwei on 2018/3/15.
 * <a href="mailto:tjwabc@gmail.com">Contact me</a>
 * <a href="https://github.com/tangjw">Follow me</a>
 */

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;

/**
 * Behavior that imposes a maximum width on any ViewGroup.
 * <p>
 * <p />Requires an attrs.xml of something like
 * <p>
 * <pre>
 * &lt;declare-styleable name="MaxWidthBehavior_Params"&gt;
 *     &lt;attr name="behavior_maxWidth" format="dimension"/&gt;
 * &lt;/declare-styleable&gt;
 * </pre>
 */
public class MaxWidthBehavior<V extends ViewGroup> extends CoordinatorLayout.Behavior<V> {
    private int mMaxWidth;
    
    public MaxWidthBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs,
                R.styleable.MaxWidthBehavior_Params);
        mMaxWidth = a.getDimensionPixelSize(
                R.styleable.MaxWidthBehavior_Params_behavior_maxWidth, 0);
        a.recycle();
    }
    
    @Override
    public boolean onMeasureChild(CoordinatorLayout parent, V child,
                                  int parentWidthMeasureSpec, int widthUsed,
                                  int parentHeightMeasureSpec, int heightUsed) {
        if (mMaxWidth <= 0) {
            // No max width means this Behavior is a no-op
            return false;
        }
        int widthMode = MeasureSpec.getMode(parentWidthMeasureSpec);
        int width = MeasureSpec.getSize(parentWidthMeasureSpec);
        
        if (widthMode == MeasureSpec.UNSPECIFIED || width > mMaxWidth) {
            // Sorry to impose here, but max width is kind of a big deal
            width = mMaxWidth;
            widthMode = MeasureSpec.AT_MOST;
            parent.onMeasureChild(child,
                    MeasureSpec.makeMeasureSpec(width, widthMode), widthUsed,
                    parentHeightMeasureSpec, heightUsed);
            // We've measured the View, so CoordinatorLayout doesn't have to
            return true;
        }
        
        // Looks like the default measurement will work great
        return false;
    }
}
