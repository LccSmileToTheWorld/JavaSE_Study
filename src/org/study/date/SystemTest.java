package org.study.date;

import org.junit.Test;

/**
 * System类获取时间戳.
 *
 * @author lcc
 * @version 1.0
 * @date 2020/4/21     
 */
public class SystemTest {

    @Test
    public void test(){
        long millis = System.currentTimeMillis();
        System.out.println(millis);
    }
}
