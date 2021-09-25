package ru.job4j.profession;

public class Dentist extends Doctor{
private  int tooth;

    public Dentist(String name, String surname, String education, String birthday, int category, int tooth) {
        super(name, surname, education, birthday, category);
        this.tooth = tooth;
    }

    public int getTooth() {
        return tooth;
    }

    public void setTooth(int tooth) {
        this.tooth = tooth;
    }
}
