package ru.job4j.collection;

import java.util.HashSet;

public class UniqueText {
    public static boolean isEquals(String originText, String duplicateText) {
        String[] origin = originText.split(" ");
        String[] text = duplicateText.split(" ");
        HashSet<String> check = new HashSet<>();
for (String string: origin){
    check.add(string);
}
for (String string : text) {
    if (!check.contains(string)) {
return false;
    }
}
        return true;
    }
}