package com.zzb.library.utils;

import android.content.Context;
import android.net.ConnectivityManager;

/**
 * Created by ZZB on 2015/6/4 10:07
 */
public class NetUtils {


    /**
     * wifi 是否可用
     * @param context context
     * @return true 可用
     */
    public static boolean isWifiDataEnable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        boolean isWifiDataEnable = false;
        isWifiDataEnable = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).isConnectedOrConnecting();
        return isWifiDataEnable;
    }
    /**
     * 网络是否可用
     * @param context context
     * @return true 可用
     */
    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(
                Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null &&
                cm.getActiveNetworkInfo().isConnectedOrConnecting();
    }
}
