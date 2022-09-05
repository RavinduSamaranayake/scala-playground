package com.kushan_scala.scala_doc.scala_classes;

/**
 * @author Ravindu
 * 9/5/2022
 */
public class Person_Java {

    private String firstName;
    String lastName;

    public Person_Java(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
