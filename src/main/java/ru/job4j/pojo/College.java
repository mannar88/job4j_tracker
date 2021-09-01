package ru.job4j.pojo;

public class College {

    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Бурдин Виктор Равилевич");
        student.setGroup("Стажер");
        student.setDate("27.07.2021");
        System.out.println(student.getName() + " " + student.getGroup() + " " + student.getDate());
    }
}
