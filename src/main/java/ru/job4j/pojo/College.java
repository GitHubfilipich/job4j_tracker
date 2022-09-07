package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFio("Иванов Иван Иванович");
        student.setGroup("Программирование");
        student.setArrive(new Date());
        System.out.println(student.getFio() + " обучается в группе " + student.group + " c " + student.getArrive());
    }
}
