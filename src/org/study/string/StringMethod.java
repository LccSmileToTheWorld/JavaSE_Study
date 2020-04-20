package org.study.string;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * String常用方法.
 *
 * @author lcc
 * @version 1.0
 * @date 2020/4/16     
 */
public class StringMethod {


    /**
     *<p> String的判断方法.
     *
     * @param
     */
    @Test
    public void test0() {
        String a = "abv上空";

        //equals(String)：判断两个字符串的内容是否一致
        System.out.println(a.equals("abv上空"));

        //equalsIgnoreCase：忽略大小写，判断两个字符串的内容是否一致
        System.out.println(a.equalsIgnoreCase("ABv上空"));

        //isEmpty()：判断字符串是否为空
        System.out.println(a.isEmpty());

        //endsWith(String suffix)：测试此字符串是否以指定的后缀结束
        System.out.println(a.endsWith("空"));

        //startsWith(String prefix)：测试此字符串是否以指定的前缀开始
        System.out.println(a.startsWith("a"));

        //startsWith(String prefix, int toffset)：测试此字符串从指定索引开始的子字符串是否以指定前缀开始
        System.out.println(a.startsWith("v", 2));

        //contains(CharSequence s)：当且仅当此字符串包含指定的 char 值序列时，返回 true
        System.out.println(a.contains("上"));
    }


    /**
     *<p>
     * String 与 byte[]之间的转换
     * 编码：String --> byte[]:调用String的getBytes()
     * 解码：byte[] --> String:调用String的构造器
     *
     * 编码：字符串 -->字节  (看得懂 --->看不懂的二进制数据)
     * 解码：编码的逆过程，字节 --> 字符串 （看不懂的二进制数据 ---> 看得懂）
     *
     * 说明：解码时，要求解码使用的字符集必须与编码时使用的字符集一致，否则会出现乱码。
     *
     * @param
     */
    @Test
    public void test1() throws UnsupportedEncodingException {
        String a = "abv上空";

        //getBytes()：以默认的编码方式，转换成字节数组
        byte[] bytes = a.getBytes();
        System.out.println(Arrays.toString(bytes));

        //调用String构造器，解码
        String b = new String(bytes);
        System.out.println(b);

        //getBytes(String charsetName)：指定编码方式，转换为字节数组
        byte[] gbks = a.getBytes("gbk");
        System.out.println(Arrays.toString(gbks));

        //调用String构造器，以指定编码方式解码
        String gbk = new String(gbks, "gbk");
        System.out.println(gbk);
    }


    /**
     *<p> 字符数组.
     *
     * @param
     */
    @Test
    public void test2() {
        String a = "abv上空";

        //toCharArray()：转换为字符数组
        char[] chars = a.toCharArray();
        System.out.println(Arrays.toString(chars));

        //调用String构造方法，字符数组转换为字符串
        String s = new String(chars);
        System.out.println(s);

        //length()：获取字符串长度
        System.out.println(a.length());

        //charAt(int)：返回字节数组的第x个字节
        System.out.println(a.charAt(0));
    }


    /**
     *<p> String和包装类转换.
     *
     * @param
     */
    @Test
    public void test3() {
        String a = "1231";
        int b = 1231;

        //基本类型转换为String，调用String的静态方法：valueOf()
        String s = String.valueOf(b);
        System.out.println(a == s);

        //String转换为基本类型，调用包装类的静态方法：parseXx()
        int i = Integer.parseInt(a);
        System.out.println(i);
    }


    /**
     *<p> 字符串大小写转换.
     *
     * @param
     */
    @Test
    public void test4() {
        String a = "ksDflA";

        //toLowerCase()：转换为小写
        System.out.println(a.toLowerCase());

        //totoUpperCase()：转换为大写
        System.out.println(a.toUpperCase());
    }


    @Test
    public void test5() {
        String a = "ab";

        //concat(String)：拼接字符串，等同于+
        String b = a.concat("cd");
        System.out.println(b);

        /**
         * compareTo(String)：比较两个字符串大小，返回两者的ASCII码值差，调用者-参数，可以为负数
         * 如果两个字符串的长度不同，并且前面N个字符都相等，则返回两个字符串长度之差
         */
        int c = b.compareTo(a);
        System.out.println(c);
    }


    /**
     *<p> 截取字符串.
     *
     * @param
     */
    @Test
    public void test6() {
        String a = "kdfjlsfj";
        //substring(int start)：从start到结尾截取字符串
        String b = a.substring(3);
        System.out.println(b);
        //substring(int start, int end)：从start到end截取字符串，左闭右开，包头不包尾
        String c = a.substring(2, 5);
        System.out.println(c);
    }

    /**
     *<p> 去掉首尾字符.
     *
     * @param
     */
    @Test
    public void test7() {
        String a = "  dsfsf  ";
        //trim()：去掉首尾字符
        String b = a.trim();
        System.out.println(b);
    }

    @Test
    public void test8() {
        String a = "sklajflajf";
        //indexOf(String)：返回指定子字符串在此字符串中第一次出现处的索引，没有返回-1
        System.out.println(a.indexOf("k"));

        //indexOf(String, int)：返回指定子字符串在此字符串中第一次出现处的索引，从指定的索引开始
        System.out.println(a.indexOf("la", 4));

        //lastIndexOf(String str)：返回指定子字符串在此字符串中最右边出现处的索引
        System.out.println(a.lastIndexOf("f"));

        //lastIndexOf(String str, int fromIndex)：返回指定子字符串在此字符串中最后一次出现处的索引，从指定的索引开始反向搜索
        System.out.println(a.lastIndexOf("a", 8));
    }


    /**
     *<p> 替换.
     *
     * @param
     */
    @Test
    public void test9() {
        String a = "dkfalsdfsafsafgwrhg";
        //replace(char oldChar, char newChar)：返回一个新的字符串，它是通过用 newChar 替换此字符串中出现的所有 oldChar 得到的。
        String b = a.replace("s", "哈");
        System.out.println(b);
        //String replaceAll(String regex, String replacement)：使用给定的 replacement 替换此字符串所有匹配给定的正则表达式的子字符串。
        //String replaceFirst(String regex, String replacement)：使用给定的 replacement 替换此字符串匹配给定的正则表达式的第一个子字符串。
        //匹配:
        //boolean matches(String regex)：告知此字符串是否匹配给定的正则表达式。
        //切片：
        //String[] split(String regex)：根据给定正则表达式的匹配拆分此字符串。
        //String[] split(String regex, int limit)：根据匹配给定的正则表达式来拆分此字符串，最多不超过limit个，如果超过了，剩下的全部都放到最后一个元素中。
    }
}
