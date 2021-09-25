package ru.job4j.profession;

public class Programmer extends  Engineer{
private  Lanh languag;

    public Programmer(String name, String surname, String education, String birthday, int level, Lanh languag) {
        super(name, surname, education, birthday, level);
        this.languag = languag;
    }

    public Lanh getLanguag() {
        return languag;
    }

    public void setLanguag(Lanh languag) {
        this.languag = languag;
    }

    public  void  programmingLanguage () {

    }
}
