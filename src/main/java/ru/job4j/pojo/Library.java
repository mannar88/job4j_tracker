package ru.job4j.pojo;

public class Library {

    private  static  void  print (Book[] books) {
        for (int i = 0; i < books.length; i++) {
            System.out.println("Книга: " + books[i].getName() + ", " + books[i].getPage() + " страниц");
        }
    }

    public static void main(String[] args) {
Book java = new Book("Java. Руководство для начинающих", 500);
    Book pithon = new Book("Изучаем программирование на Python", 400);
    Book html = new Book("Изучаем HTML, XHTML и CSS", 610);
    Book book = new Book("Clean code", 300);
    Book [] books = new  Book[4];
    books [0] = java;
    books[1] = pithon;
    books[2] = html;
    books[3] = book;
print(books);
    books[3] = java;
    books[0] = book;
print(books)    ;
        for (int i = 0; i < books.length; i++) {
            if (books[i].equals(book)){
                System.out.println(books[i].getName());
            }
        }
    }
}
