package ru.job4j.profession;

public class Builder extends  Engineer{

    private  boolean foreman;

    public Builder(String name, String surname, String education, String birthday, int level, boolean foreman) {
        super(name, surname, education, birthday, level);
        this.foreman = foreman;
    }

    public boolean isForeman() {
        return foreman;
    }

    public  boolean altitudeResolution () {
    return  false;
}
}
