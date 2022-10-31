package com.kushan_scala.scala_doc.compariosn_with_java.classes

object ScalaRunner extends App {
 val person_Scala = new Person_Scala("Kushan","Ravindu",27)
 val person_Java = new Person_J("Kushan_J","Ravindu_J",27)//We can use java object also
 println(person_Scala.toString)
 println(person_Java.toString)

 val person_Scala2 = new Person_Scala_V2("Kushan2")
 val person_Java2 = new Person_Java_V2("Kushan_J_2")
 println(person_Scala2.toString)
 println(person_Java2)
}
