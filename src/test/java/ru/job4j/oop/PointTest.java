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

@Test
public  void  thenPoiit3d (){
    Point a = new Point(0, 0, 0);
    Point b = new Point(0, 0, 5);
    Assert.assertEquals(a.distance3d(b), 5.0, 0.1);
}

}