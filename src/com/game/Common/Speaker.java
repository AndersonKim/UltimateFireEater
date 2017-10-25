package com.game.Common;

/**
 * edited by AndersonKim
 * at 2017/10/23
 */

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 为游戏世界提供旁白
 */
public class Speaker {
    /**
     * 返回指定类的指定函数结果
     * 暂时只支持获取无参函数的String返回值
     * @param name 类名
     * @param function  方法名
     * @return
     */
    public static String bindFunction(String name,String function){
        String result=null;
        try {
            Class c=Class.forName(name);
            Method m=c.getMethod(function);
            Object value = m.invoke(c);
            result=value.toString();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return result;
    }


}
