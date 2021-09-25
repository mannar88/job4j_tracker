package ru.job4j.profession;

public class Engineer extends Profession{
private  int level;

    public Engineer(String name, String surname, String education, String birthday, int level) {
        super(name, surname, education, birthday);
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public  void  education () {

}
}
