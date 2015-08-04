package com.zzb.library.utils;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * Created by ZZB on 2015/7/31.
 */
public class DecodeBitmapUtils {

    public static int counter = 0;
    /**
     * 压缩bitmap, 如果OOM则继续压缩
     *@author ZZB
     *created at 2015/7/31 11:42
     */
    public static Bitmap decodeBitmap(Resources res, int resId, int reqWidth, int reqHeight){
        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);
        // Calculate inSampleSize
        int sample = calculateInSampleSize(options, reqWidth, reqHeight);
        options.inSampleSize = sample;
        Bitmap bitmap = decodeBitmap(res, resId, options);
        return bitmap;
    }

    private static Bitmap decodeBitmap(Resources res, int resId, BitmapFactory.Options options){

        try{
            // Decode bitmap with inSampleSize set
            options.inJustDecodeBounds = false;
            Bitmap bitmap = BitmapFactory.decodeResource(res, resId, options);
            return bitmap;
        }catch(OutOfMemoryError outOfMemoryError){
            //增加压缩率
            options.inSampleSize += 1;
            Bitmap bitmap = decodeBitmap(res, resId, options);
            return bitmap;
        }

    }
    /**
     * For example, an image with resolution 2048x1536 that is decoded with an inSampleSize of 4
     * produces a bitmap of approximately 512x384. Loading this into memory uses 0.75MB rather than 12MB
     * for the full image (assuming a bitmap configuration of ARGB_8888).
     */
    public static int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) > reqHeight
                    && (halfWidth / inSampleSize) > reqWidth) {
                inSampleSize *= 2;
            }
        }

        return inSampleSize;
    }
}
