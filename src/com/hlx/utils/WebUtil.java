package com.hlx.utils;

import com.hlx.entity.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author hlx
 * @create 2020-08-08 10:49
 */
public class WebUtil {
//    public static void copyParamToBean(HttpServletRequest req, Object bean) {
    public static <T>T copyParamToBean(Map value, T bean) {

        System.out.println(bean);
        try {
            BeanUtils.populate(bean, value);
            System.out.println(bean);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }
    public static int parseInt(String str,int defaultValue){
        try {
            if (str!=null)
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return defaultValue;
    }
}
