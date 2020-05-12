package org.study.date;

import org.junit.Test;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

/**
 * Instant测试.
 *
 * @author lcc
 * @version 1.0
 * @date 2020/5/11     
 */
public class InstantTest {

    @Test
    public void test() {
        //返回默认 UTC(格林威治) 时区的 Instant 类的对象
        Instant now = Instant.now();
        System.out.println(now);

        //返回在 1970 01 01 00 00 00 基础上加上指定毫秒数之后的 Instant 类的对象
        Instant instant = Instant.ofEpochMilli(123434L);
        System.out.println(instant);

        //instant --> 时间戳
        long l = now.toEpochMilli();
        System.out.println(l);

        //时间戳 --> instant
        Instant instant1 = Instant.ofEpochMilli(1589249949518L);
        System.out.println(instant1);

        //结合即时的偏移来创建一个OffsetDateTime（带偏移量的时间类）
        OffsetDateTime offsetDateTime = now.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);
    }
}
