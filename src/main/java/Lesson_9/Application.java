package Lesson_9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;


interface Student {
    String getName();
    List<Course> getAllCourses();
}
interface Course {}


class CourseClass implements Course {
    String title;

    public CourseClass(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return title;
    }
}

class StudentClass implements Student {
    private String name;
    private List<Course> courses;

    public StudentClass(String name, String courses) { // ~ "Вася", "тактика, стратегия, основы ДД, основы ПДД"
        this.name = name;
        this.courses = new ArrayList<Course>();
        for (String i: courses.split(", ")) {
            this.courses.add(new CourseClass(i));
        }
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public List<Course> getAllCourses() {
        return this.courses;
    }

    @Override
    public String toString() {
        return "Студент \'" + name + '\'' + ", записан на курсы = " + courses ;
    }
}

/* Работа с данными в точке входа */
public class Application {

    static Set<String> task1(List<StudentClass> students) {
        // Задание 1
        // Ф-я принимающая список Student и возвращающую список уникальных курсов, на которые подписаны студенты.
        return students.stream()
                .map(x -> x.getAllCourses())
                .flatMap(x->x.stream())
                .map(x-> x.toString())
                .collect(Collectors.toSet());
    }

    static List<Student> task2 (List<StudentClass> students) {
        List<Student> res = students.stream()
                .sorted((x,y) -> (int) (y.getAllCourses().size() - x.getAllCourses().size()) )
                .limit(3)
                .collect(Collectors.toList());
        return res;
    }

    static List<Student> task3 (List<StudentClass> students, String toFind) {
        List<Student> res = students.stream()
                .filter(x -> x.getAllCourses().toString().contains(toFind))
                .collect(Collectors.toList());
        return res;

    }

    public static void main(String[] args) {
        List<StudentClass> students = new ArrayList<>();
        students.add(new StudentClass("Вася", "ДД, ПДД, СОП(КС), СОП(Арт), СОП(ДС), НБ"));
        students.add(new StudentClass("Петя", "ДД, ПДД, СОП(КС), СОП(Арт), СОП(ДС)"));
        students.add(new StudentClass("Федя", "ДД, ПДД, СОП(КС), СОП(Арт), СОП(ДС), НБ, ПДО"));
        students.add(new StudentClass("Маша", "ДД, ПДД, СОП(КС), СОП(ДС), НБ"));
        students.add(new StudentClass("Глаша", "ДД, ПДД, СОП(КС), СОП(ДС)"));
        students.add(new StudentClass("Люся", "ПДД, СОП(КС), СОП(ДС)"));
        students.add(new StudentClass("Дуся", "ПДД, СОП(КС), СОП(ДС), КСП, ОСП, Кройка и Шитье, Первая помощь, я ХЗ…"));
        // реально все сокращения которые помнил — собрал…

        System.out.println("-- Все студенты -------------------------------");
        students.stream().forEach(System.out::println);

        // Задание 1 тест
        System.out.println("-- Задание №1 ---------------------------------");
        // вариант 1, как наиболее верный вынесу в метод
        System.out.println(task1(students));
        // вариант 2, не стану выделять в метод
        System.out.println(students.stream()
                .map(x -> x.getAllCourses())
                .flatMap(x->x.stream())
                .map(x-> x.toString())
                .distinct()
                .collect(Collectors.toList())
        );

        // Задание 2 тест
        System.out.println("-- Задание №2 ---------------------------------");
        task2(students).stream().forEach(System.out::println);

        // Задание 3 тест
        System.out.println("-- Задание №3 ---------------------------------");
        String COURSE_NAME = "НБ"; // там их всего трое
        task3(students,COURSE_NAME).stream().forEach(System.out::println);
    }


}
