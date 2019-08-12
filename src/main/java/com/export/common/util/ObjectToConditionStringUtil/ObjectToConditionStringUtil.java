package com.export.common.util.ObjectToConditionStringUtil;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @Author KingBoy
 * @Date 2017/2/8 18:10
 * @Description ${DESCRIPTION}
 */
public class ObjectToConditionStringUtil {
    public static String ObjectToConditionString(Object object){
        Class clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();                          //根据Class对象获得属性 私有的也可以获得
        String string = Arrays.stream(fields).filter(field -> {
            try {
                field.setAccessible(true);
                if(field.getType().toString().endsWith("String")){
                    if(field.get(object)!=null&&field.get(object).toString().equals(""))return false;//string空字符串值不包括
                }
                return field.getAnnotation(PropertyStringName.class) != null && field.get(object) != null;
            } catch (IllegalAccessException e) {
                e.printStackTrace();return false;
            }
        }).map(field -> getStringValue(field,object)).collect(Collectors.joining(",")).toString();

        return string;
    }
    private static String getStringValue(Field field , Object object){
        try {
        //field.setAccessible(true);                                           //设置些属性是可以访问的
        Object val = field.get(object);                                           //得到此属性的值
        PropertyStringName t = field.getAnnotation(PropertyStringName.class);//获得属性上的注解的值
        if(field.getType().isEnum()){                                        //如果是枚举，则取枚举的value值
            Method method = val.getClass().getMethod("getValue");
            String enumValue = (String)method.invoke(val);
            return t.name()+":"+enumValue;
        }

        else if(field.getType().equals(LocalDateTime.class)){               //如果是时间，则取时间的格式化字符串
            LocalDateTime time = (LocalDateTime) val;
            String timeString = time.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
            return t.name()+":"+timeString;
        }

        else{                                                            //其余属性取其值
            return t.name()+":"+val;
        }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return "";
    }

//    public static String ObjectToConditionString(Object object){
//        StringBuilder sb = new StringBuilder("");
//        try {
//            Class clazz = object.getClass();
//            Field[] fields = clazz.getDeclaredFields();                          //根据Class对象获得属性 私有的也可以获得
//            for(Field field : fields) {
//                field.setAccessible(true);                                           //设置些属性是可以访问的
//                Object val = field.get(object);                                           //得到此属性的值
//                PropertyStringName t = field.getAnnotation(PropertyStringName.class);//获得属性上的注解的值
//                if(t == null || val == null ) continue;                          //如果没有属性值，或者没有加注解，则忽略该属性
//
//                if(field.getType().isEnum()){                                        //如果是枚举，则取枚举的value值
//                    Method method = val.getClass().getMethod("getValue");
//                    String enumValue = (String)method.invoke(val);
//                    sb.append(t.name()+":"+enumValue+",");
//                }
//
//                else if(field.getType().equals(LocalDateTime.class)){               //如果是时间，则取时间的格式化字符串
//                    LocalDateTime time = (LocalDateTime) val;
//                    String timeString = time.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
//                    sb.append(t.name()+":"+timeString+",");
//                }
//
//                else{                                                            //其余属性取其值
//                    sb.append(t.name()+":"+val+",");
//                }
//            }
//        } catch(Exception e) {
//            e.printStackTrace();
//        }
//        sb.deleteCharAt(sb.length()-1);                                          //删除最后一个分号
//        return sb.toString();
//    }
}
