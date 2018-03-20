package com.zonsim.nestedscroll;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * desc
 * <p>
 * Created by tangjunwei on 2018/3/15.
 * <a href="mailto:tjwabc@gmail.com">Contact me</a>
 * <a href="https://github.com/tangjw">Follow me</a>
 */
public class FollowBehavior extends CoordinatorLayout.Behavior<TextView> {
    public FollowBehavior() {
    }
    
    public FollowBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    
    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, TextView child, View dependency) {
        return dependency instanceof Button;
    }
    
    
    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, TextView child, View dependency) {
        child.setX(dependency.getX() + 150);
        child.setY(dependency.getY() + 150);
        return true;
    }
}
