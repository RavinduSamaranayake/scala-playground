package com.kushan_scala.scala_doc.compariosn_with_java.classes

class Person_Scala(var firstName : String,
                   var lastName : String,
                   var age : Int){

  override def toString: String = s"$firstName $lastName is $age years old"
}
