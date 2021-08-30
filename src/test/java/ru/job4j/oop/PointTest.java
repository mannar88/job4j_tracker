package ru.job4j.oop;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PointTest {
@Test
    public void  thenPoint(){
    Point a = new Point(0, 0);
    Point b = new Point(5, 0);
    Assert.assertEquals(a.distance(b), 5.0, 0.1);
}

}