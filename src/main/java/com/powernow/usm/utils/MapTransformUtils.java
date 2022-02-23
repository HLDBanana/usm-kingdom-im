package com.powernow.usm.utils;


import cn.hutool.core.bean.BeanUtil;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @description:
 * @create: 2021/5/31 10:22
 * @update: 2021/5/31 10:22
 */
public class MapTransformUtils {


    /**
     *
     * @Title: objectToMap
     * @Description: TODO(bean转换为Map)
     * @return Map<?,?>    返回类型
     * @param obj
     * @return
     */
    public static Map<?, ?> objectToMap(Object obj) {
        if(obj == null) {
            return null;
        }
        return BeanUtil.beanToMap(obj);
    }

    /**
     *
     * @Title: objectToMap
     * @Description: TODO(bean转换为Map)
     * @return Map<?,?>    返回类型
     * @param objs
     * @return
     */
    public static List<Map<String, Object>> objectsToMap(List objs) {
        if(objs == null) {
            return null;
        }
        return (List<Map<String, Object>>) objs.stream()
                .map(obj -> {
                    return BeanUtil.beanToMap(obj);
                }).collect(Collectors.toList());
    }
}
