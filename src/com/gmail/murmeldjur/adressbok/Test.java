package com.gmail.murmeldjur.adressbok;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Human {

    boolean isAhuman = false;

    Human(){

    }

    Human(boolean isHuman){
        this.isAhuman = isHuman;
    }


}

class Person extends Human implements Serializable {
    public String name;
    public String address;
    public int age;

    Person(String name, String address, int age) {
        super(true);
        this.name = name;
        this.address = address;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                '}';
    }
}

public class Test {
    public static List<Human> arr = new ArrayList<>();

    public static void main(String[] args) {
        Human p = new Person("Ola", "Skjulvägen", 51);
        Human p1 = new Person("Kalle", "Hamngatan", 37);
        Human p2 = new Person("Stina", "Sveavägen", 27);
        arr.add(p);
        arr.add(p1);
        arr.add(p2);
        addToSer(arr);
        unfoldSer();
        printSer();

    }

    static void addToSer(List<Human> p) {
        try {
            FileOutputStream fileOut =
                    new FileOutputStream("person.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(p);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in person.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }

    }

    static void unfoldSer() {
        Person e = null;
        try {
            FileInputStream fileIn = new FileInputStream("person.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            arr = (List<Human>) in.readObject();

        } catch (IOException i) {
            i.printStackTrace();

        } catch (ClassNotFoundException c) {
            System.out.println("Person class not found");
            c.printStackTrace();

        }
    }

    static void printSer(){
        for(Human per: arr){
            System.out.println(per);
        }
    }
}
