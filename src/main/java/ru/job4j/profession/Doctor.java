package ru.job4j.profession;

public class Doctor extends  Profession{
private  int category;

    public Doctor(String name, String surname, String education, String birthday, int category) {
        super(name, surname, education, birthday);
        this.category = category;
    }

    public int getCategory() {
        return category;
    }

    public  String Diagnosis () {

    return  null;
}
}
