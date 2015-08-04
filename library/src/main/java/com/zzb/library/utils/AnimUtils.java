package com.zzb.library.utils;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.zzb.library.R;

/**
 * Created by ZZB on 2015/8/4.
 */
public class AnimUtils {

    /**
     * 左右摆View
     * @param context context
     * @param view 动画的View
     *@author ZZB
     *created at 2015/8/4 14:37
     */
    public static void shake(Context context, View view){
        view.clearAnimation();
        Animation shake = AnimationUtils.loadAnimation(context, R.anim.shake);
        view.startAnimation(shake);
    }
}
