package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArrayStream {
    public  static List <Integer> matrix (Integer[][] array) {
       return  Arrays.stream(array).flatMap(Stream::of).collect(Collectors.toList());
    }
    }
