package ru.job4j.profession;

import javax.sound.midi.Instrument;

public class Surgeon  extends  Doctor {

    private boolean traumatologist;

    public Surgeon(String name, String surname, String education, String birthday, int category, boolean traumatologist) {
        super(name, surname, education, birthday, category);
        this.traumatologist = traumatologist;
    }

    public boolean isTraumatologist() {
        return traumatologist;
    }
}