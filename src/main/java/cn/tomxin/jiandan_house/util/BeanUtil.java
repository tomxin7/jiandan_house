package cn.tomxin.jiandan_house.util;

import java.lang.reflect.Field;

public class BeanUtil {

    /**
     * 合并两个bean
     * @param origin 要修改的属性
     * @param destination 是原来的属性
     * @param <T>
     * @return
     */
    public static  <T> T mergeObject(T origin, T destination) {
        if (origin == null || destination == null){
            return null;

        }
        if (!origin.getClass().equals(destination.getClass())){
            return null;
        }

        Field[] fields = origin.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            try {
                fields[i].setAccessible(true);
                Object value = fields[i].get(origin);
                if (null != value) {
                    fields[i].set(destination, value);
                }
                fields[i].setAccessible(false);
            } catch (Exception e) {
            }
        }
        return destination;
    }
}
