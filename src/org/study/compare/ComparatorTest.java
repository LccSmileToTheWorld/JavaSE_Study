package org.study.compare;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 定制排序.
 *
 * @author lcc
 * @version 1.0
 * @date 2020/5/12     
 */
public class ComparatorTest {

    @Test
    public void test(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(11, "张三"));
        students.add(new Student(12, "李四"));
        students.add(new Student(10, "王五"));
        //调用Arrays.sort()，或 Collections.sort()，参数传入Comparator对象，重写compare()
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return -o1.getAge().compareTo(o2.getAge());
            }
        });
        for (Student student : students){
            System.out.println(student);
        }
    }
}
