package com.hzg.nowcoder;

import javafx.scene.layout.Priority;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * 比较器
 * @author zhengguohuang
 */
public class MyComparator {

    public static class Student {
        public String name;
        public int id;
        public int age;

        public Student(String name, int id, int age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }
    }

    public static class IdAscendingComparator implements Comparator<Student> {
        @Override
        public int compare(Student o1, Student o2) {
            return o1.id - o2.id;
        }
    }

    public static class IdDescendingComparator implements Comparator<Student> {
        @Override
        public int compare(Student o1, Student o2) {
            return o2.id - o1.id;
        }
    }

    public static class AgeAscendingComparator implements Comparator<Student> {
        @Override
        public int compare(Student o1, Student o2) {
            return o1.age - o2.age;
        }

    }

    public static class AgeDescendingComparator implements Comparator<Student> {
        @Override
        public int compare(Student o1, Student o2) {
            return o2.age - o1.age;
        }

    }

    public static void printStudents(Student[] students) {
        for (Student student : students) {
            System.out.println("Name : " + student.name + ", Id : " + student.id + ", Age : " + student.age);
        }
        System.out.println("===========================");
    }

    public static void main(String[] args) {
        Student student1 = new Student("A", 1, 23);
        Student student2 = new Student("B", 2, 21);
        Student student3 = new Student("C", 3, 22);

        Student[] students = new Student[] { student3, student2, student1 };
        printStudents(students);

        Arrays.sort(students, new IdAscendingComparator());
        printStudents(students);

        Arrays.sort(students, new IdDescendingComparator());
        printStudents(students);

        Arrays.sort(students, new AgeAscendingComparator());
        printStudents(students);

        Arrays.sort(students, new AgeDescendingComparator());
        printStudents(students);


//        优先级队列(本质是堆)
        PriorityQueue<Student> heap = new PriorityQueue<Student>(new IdAscendingComparator());
        heap.add(student2);
        heap.add(student1);
        heap.add(student3);
        System.out.println(heap.poll().id);
        System.out.println(heap.poll().id);
        System.out.println(heap.poll().id);

        TreeSet<Student> ts = new TreeSet<Student>(new IdAscendingComparator());
        ts.add(student2);
        ts.add(student1);
        ts.add(student3);
        System.out.println(ts.pollFirst().id);
        System.out.println(ts.pollFirst().id);
        System.out.println(ts.pollFirst().id);


    }

}
