package com.kushan_scala.scala_doc.compariosn_with_java.classes

class Person_Scala_V2(
var firstName: String,
var lastName: String,
var age: Int
){
  // zero-arg auxiliary constructor
  def this() = this("","",0)
  // one-arg auxiliary constructor
  def this(firstName:String) = this(firstName,"",0)
  // two-arg auxiliary constructor
  def this(firstName:String,age:Int) = this(firstName,"",age)

  override def toString: String = "Person_Scala{" + "firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", age=" + age + '}'
}

