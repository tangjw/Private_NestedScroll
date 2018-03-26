package com.zonsim.nestedscroll;

import android.content.res.Resources;

/**
 * desc
 * <p>
 * Created by tangjunwei on 2018/3/26.
 * <a href="mailto:tjwabc@gmail.com">Contact me</a>
 * <a href="https://github.com/tangjw">Follow me</a>
 */
public class Utils {
    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(float dip) {
        return (int) (0.5f + dip * Resources.getSystem().getDisplayMetrics().density);
    }
    
    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static float px2dip(float px) {
        return (px / Resources.getSystem().getDisplayMetrics().density);
    }
}
