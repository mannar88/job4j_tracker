package ru.job4j.condition;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaxTest {

    @Test
public  void  thenAdd(){
        int a = 1;
        int b = 2;
int c = 3;
int d = 4;
    int rsl = Max.max(a, b);
    Assert.assertEquals( rsl, 2);
    rsl = Max.max(a, b, c);
        Assert.assertEquals(rsl, 3);
    rsl = Max.max(a, b, c, d);
        Assert.assertEquals(rsl, 4);
    }

    }