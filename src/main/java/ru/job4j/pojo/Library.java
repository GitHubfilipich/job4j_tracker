package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("Clean code", 100);
        Book book2 = new Book("Head First Java", 1000);
        Book book3 = new Book("Core Java", 200);
        Book book4 = new Book("Java 8 The Complete Reference", 500);
        Book[] books = {book1, book2, book3, book4};
        for (int index = 0; index < 4; index++) {
            System.out.println("Book " + books[index].getName() + ", pages " + books[index].getPages());
        }
        Book tempBook = books[0];
        books[0] = books[3];
        books[3] = tempBook;
        System.out.println("Changed books:");
        for (int index = 0; index < 4; index++) {
            System.out.println("Book " + books[index].getName() + ", pages " + books[index].getPages());
        }
        System.out.println("Books \"Clean code\":");
        for (int index = 0; index < 4; index++) {
            if (books[index].getName().equals("Clean code")) {
                System.out.println("Book " + books[index].getName() + ", pages " + books[index].getPages());
            }
        }
    }
}
