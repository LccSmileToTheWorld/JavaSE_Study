package org.study.compare;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 自然排序.
 *
 * @author lcc
 * @version 1.0
 * @date 2020/5/11     
 */
public class ComparableTest {

    @Test
    public void test(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(11, "张三"));
        students.add(new Student(12, "李四"));
        students.add(new Student(11, "王五"));
        //2、调用Arrays.sort()，或 Collections.sort()
        Collections.sort(students);
        for (Student student : students){
            System.out.println(student);
        }
    }
}

//1、实现Comparable接口，重写compareTo方法，对象>形参时，返回正数；对象=形参时，返回0；对象<形参时，返回负数
class Student implements Comparable<Student>{
    private Integer age;
    private String name;

    @Override
    public int compareTo(Student student) {
        //包装类已重写compareTo()
        int i = this.age.compareTo(student.getAge());
        if (i == 0){
            return this.name.compareTo(student.getName());
        }
        return i;
    }

    public Student(Integer age, String name){
        this.age = age;
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}