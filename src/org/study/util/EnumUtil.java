package org.study.util;


/**
 * 自定义枚举类.
 *
 *  使用 enum 定义的枚举类 默认继承了java.lang.Enum 类，因此不能再继承其他类
 *  枚举类的构造器只能使用 private 权限修饰符（不写默认）
 *  枚举类的所有实例必须在枚举类中显式列出(,分隔 ;结尾)。列出的实例系统会自动添加public static final修饰
 *  必须在枚举类的第一行声明枚举类对象
 *
 * @author lcc
 * @version 1.0
 * @date 2020/3/26     
 */
public class EnumUtil {

    /**
     *<p> 季节.
     *
     */
    public enum season {
        spring("春", 1), summer("夏", 2), autumn("秋", 3), winter("冬", 4);

        private final String key;
        private final Integer value;

        season(String key, Integer value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public Integer getValue() {
            return value;
        }

        public static season getSeason(String key){
            for(season bean : season.values()){
                if (bean.key.equals(key)){
                    return bean;
                }
            }
            return null;
        }
    }

}
