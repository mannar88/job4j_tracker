package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;

public class ProfilesTest {

    @Test
    public void collect() {
        Address addressMSk = new Address("Москва", "Тверскя", 2, 1);
    Address addressSpb = new Address("Санкт-Петербург", "Рубинштейна", 66, 4);
Address addressEkb = new Address("Екатеринбург", "Бориса Ельцина", 1,1);
    List <Profile> profiles = List.of(
            new Profile(addressMSk),
            new Profile(addressSpb),
            new Profile(addressEkb)
    );
    List <Address> expect = List.of(addressMSk, addressSpb, addressEkb);
        assertThat(new Profiles().collect(profiles), is(expect));

    }

     }