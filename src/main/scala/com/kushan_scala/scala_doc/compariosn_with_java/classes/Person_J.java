package com.kushan_scala.scala_doc.compariosn_with_java.classes;


class Person_J {
    public String firstName;
    public String lastName;
    public int age;
    public Person_J(
            String firstName,
            String lastName,
            int age
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
    public String toString() {
        return String.format("%s %s is %d years old.", firstName, lastName, age);
    }
}