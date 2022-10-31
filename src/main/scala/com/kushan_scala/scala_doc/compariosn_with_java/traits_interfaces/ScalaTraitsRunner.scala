package com.kushan_scala.scala_doc.compariosn_with_java.traits_interfaces

object ScalaTraitsRunner extends App {
  val math = new ScalaMath()
  println(s"Add value is : ${math.add(6,10)} and Multiply value is : ${math.multiply(6,10)}")
  val math_Java = new JavaMath()
  println(s"Java Add value is : ${math_Java.add(6,10)} and Multiply value is : ${math_Java.multiply(6,10)}")
}
