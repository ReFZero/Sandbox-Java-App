package pl.ReFZero.reflection;

import java.io.Serializable;
import java.util.Objects;

public  class Person implements Serializable {

    private final String name;
    private int age;


    public Person(String name) {
        this.name = name;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void publicMethod(){
        System.out.println("public method");
    }

    public void publicMethodWithParameters(int a, int b){
        System.out.println("public method with parameter a=" + a + " b=" + b);
    }


    private void privateMethod(){
        System.out.println("private method");
    }


    public static void publicAndStaticMethod(){
        System.out.println("public static method");
    }

    private static void privateAndStaticMethod(){
        System.out.println("private static method");
    }
}
