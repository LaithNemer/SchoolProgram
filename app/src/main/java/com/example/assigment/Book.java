package com.example.assigment;

public class Book {
    private String name;
    private  int pages;
    private String nameAuther;

    public Book(String name,int pages,String nameAuther){
        this.name=name;
        this.pages=pages;
        this.nameAuther=nameAuther;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameAuther() {
        return nameAuther;
    }

    public void setNameAuther(String nameAuther) {
        this.nameAuther = nameAuther;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", pages=" + pages +
                ", nameAuther='" + nameAuther + '\'' +
                '}';
    }
}
