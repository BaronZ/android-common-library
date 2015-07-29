package com.zzb.library.utils;

import android.content.res.Resources;

/**
 * Created by ZZB on 2015/7/29 11:20
 */
public class DisplayUtils {


    /**
     * dp转为px
     * @param dp dp值
     * @return px值
     */
    public static int dpToPx(int dp){
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }

    /**
     * px转为dp
     * @param px px值
     * @return dp值
     */
    public static int pxToDp(int px){
        return (int) (px / Resources.getSystem().getDisplayMetrics().density);
    }

    /**
     * 获取屏幕宽度
     * @return 屏幕宽度
     */
    public static int getScreenWidth(){
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    /**
     * 获取屏幕高度
     * @return 屏幕高度
     */
    public static int getScreenHeight(){
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }
}
