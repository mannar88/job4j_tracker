package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

public class StreamNum {
public  static  List <Integer> sortPositive (List <Integer> list){
return list.stream().filter(
        i -> i> 0
).collect(Collectors.toList());
}
}
