package ru.job4j.collection;

import java.util.HashMap;
import java.util.HashSet;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap();
        hashMap.put("test@mail.ru","Почтовый аккаунт на Майл.ру");
        hashMap.put("test@yandex.ru", "Почтовый аккаунт на Яндексе");
    hashMap.put("test@rambler.ru", "Почтовый аккаунт на Рамблере");
for (String key : hashMap.keySet()){
    String  string = hashMap.get(key);
    System.out.println("Ключ: "+ key+ " Второй аргумент, соответствующий ключу: " + string);
}
    }
}
