package com.zzb.library.utils;

import android.util.Log;

import java.security.MessageDigest;
import java.text.MessageFormat;

public class MD5Utils {

    private static final String TAG = "MD5Utils";

    /**
     * MD5加密(32位)
     */
    public static String encrypt32bit(String str) {
        String result = encrypt(str);
        return result;
    }

    /**
     * MD5加密(16位)
     */
    public static String encrypt16bit(String str) {
        String result = encrypt(str);
        if (result.length() >= 24)
            result = result.substring(8, 24);
        return result;
    }

    /**
     * MD5加密
     */
    private static String encrypt(String str) {
        String result = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            byte[] encryContext = md.digest(); // 调用该方法完成计算
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < encryContext.length; offset++) {// 做相应的转化（十六进制）
                i = encryContext[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            result = buf.toString();
        } catch (Exception ex) {
            Log.e(TAG, MessageFormat.format("{0}->{1}方法发生异常：{2}", TAG,
                    "encrypt", ex.getMessage()));
            ex.printStackTrace();
        }
        return result;
    }

    public final static String getMessageDigest(byte[] buffer) {
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest mdTemp = MessageDigest.getInstance("MD5");
            mdTemp.update(buffer);
            byte[] md = mdTemp.digest();
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
