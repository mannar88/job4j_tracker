package ru.job4j.oop;

public class Error {

private boolean active;
private int status;
private String message;

public  Error () {
}

public  Error ( boolean active, int status, String message){
    this.active = active;
    this.status = status;
    this.message = message;
}

public  void  print () {
    System.out.println(active + " " + status + " " + message);
}
public static void main(String[] args) {
Error error = new Error();
error.print();
Error nopaje = new Error(true, 404, "страница отсутствует");
nopaje.print();
Error test = new Error(true, -1, "не знаю, что тут написать");
test.print();
}
}
