package org.study.util;

import org.junit.Test;

/**
 * .
 *
 * @author lcc
 * @version 1.0
 * @date 2020/3/26     
 */
public class EnumTest {

    @Test
    public void test(){
        System.out.println(EnumUtil.season.spring.getKey() + "-对应：" + EnumUtil.season.spring.getValue());

        String key = "秋";
        EnumUtil.season season = EnumUtil.season.getSeason(key);

        switch (season){
            case spring:
                System.out.println(season.getKey() + "-对应：" + season.getValue());
                break;
            case summer:
                System.out.println(season.getKey() + "-对应：" + season.getValue());
                break;
            case autumn:
                System.out.println(season.getKey() + "-对应：" + season.getValue());
                break;
            case winter:
                System.out.println(season.getKey() + "-对应：" + season.getValue());
                break;
        }

        EnumUtil.season spring = EnumUtil.season.spring;
        System.out.println(spring);
        // 使用enum编写枚举类，默认继承java.lang.Enum
        System.out.println(spring.getClass().getSuperclass());

    }
}
