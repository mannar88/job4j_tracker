package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;

public class StreamNumTest {

    @Test
public    void  positive (){
    List <Integer> list = List.of(-2, -1, 0, 1,2);
    assertThat(StreamNum.sortPositive(list), is(List.of(1,2)));
}

}