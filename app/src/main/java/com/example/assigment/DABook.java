package com.example.assigment;

import java.util.ArrayList;
import java.util.LinkedList;

public class DABook implements AnyThing {
    LinkedList<Book>array=new LinkedList<>();
    public DABook(){
        array.add(new Book("Chemestry",100,"mohammad"));
        array.add(new Book("Math",150,"ahmad"));
        array.add(new Book("Science",200,"laith nemer"));
    }


    @Override
    public ArrayList<Book> findData(String name) {
        ArrayList<Book>arr=new ArrayList<>();
        for(int i=0;i<array.size();i++){
            if(name.equals(array.get(i).getName())){
                arr.add(array.get(i));
            }
        }
        return arr;
    }

    @Override
    public String[] FindName() {
        String [] array={"Math","Science"};
        return  array;
    }

    @Override
    public String[] Oparitions() {
        String [] array={"*","-","+","/"};
        return array;
    }


}
