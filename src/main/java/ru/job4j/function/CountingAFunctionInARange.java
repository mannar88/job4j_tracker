package ru.job4j.function;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

public class CountingAFunctionInARange {

    public  static List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List <Double> rst = new ArrayList<>();
        for (int i = start; i < end; i++) {
            rst.add(func.apply((double) i));
        }
   return  rst;
    }
}
