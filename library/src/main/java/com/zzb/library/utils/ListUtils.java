package com.zzb.library.utils;

import java.util.List;

/**
 * Created by ZZB on 2015/6/5 16:33
 */
public class ListUtils {

    /**
     * 判断list是不是空
     * @param list 判断的List
     * @return true list是空
     * @author ZZB
     */
    public static boolean isEmpty(List list) {
        return list == null || list.size() == 0;
    }

    /**
     * 获取list的长度
     * @param list 判断的List
     * @return list的长度
     * @author ZZB
     */
    public static int getSize(List list) {
        return list == null ? 0 : list.size();
    }
}
