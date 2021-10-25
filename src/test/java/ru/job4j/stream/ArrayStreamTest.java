package ru.job4j.stream;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;

public class ArrayStreamTest {

    @Test
    public void thenMatrix() {
    Integer [][] nums = {{1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
    };
        List <Integer> expect = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        assertThat(ArrayStream.matrix(nums), is (expect));
    }
}