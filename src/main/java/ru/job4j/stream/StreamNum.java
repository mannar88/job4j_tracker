package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

public class StreamNum {
public  static  Listst <Integer> sortPositive (List <Integer> list){
return list.streamam().filter(
        i -> i> 0
).collect(Collectors.toList());
}
}
