package com.zzb.library.utils;

import java.util.List;

/**
 * Created by ZZB on 2015/6/5 16:33
 */
public class ListUtils {
    /**
     * @description 判断list是不是空
     * @created 2015-4-13 下午5:51:24
     * @author ZZB
     */
    public static boolean isEmpty(List list) {
        return list == null || list.size() == 0;
    }

    /**
     * @description 获取list的长度
     * @created 2015-4-13 下午5:53:18
     * @author ZZB
     */
    public static int getSize(List list) {
        return list == null ? 0 : list.size();
    }
}
