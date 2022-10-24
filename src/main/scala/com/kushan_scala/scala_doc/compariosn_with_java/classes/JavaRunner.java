package com.kushan_scala.scala_doc.compariosn_with_java.classes;

public class JavaRunner {
    public static void main(String[] args) {
        var person_Scala = new Person_Scala("Kushan","Ravindu",27);//We can use scala object also
        var person_Java = new Person_J("Kushan_J","Ravindu_J",27);
        System.out.println(person_Scala);
        System.out.println(person_Java);
    }
}
