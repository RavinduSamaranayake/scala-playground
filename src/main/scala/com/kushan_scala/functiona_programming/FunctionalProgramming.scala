package com.kushan_scala.functiona_programming

object FunctionalProgramming extends App {
  //Scala is OO
  class Person(name : String){
    def apply(age : Int): Unit = println(s"I have aged $age years")
  }
  val bob = new Person("bob")
  bob.apply(43)
  bob(43) // Invoking bob as a function === bob.apply(43)

  /*
  Scala runs on the JVM
  Functional programming:
  - compose functions
  - compose functions as args
  - compose functions as results

  Conclusion: FunctionX = Function1,Function2,Function3,..................,Function22 //22 is the maximum number of args that you pass the function
   */

  val simpleIncrementer = new Function1[Int,Int] {
    override def apply(arg: Int): Int = arg + 1
  }
  simpleIncrementer.apply(23) // 24
  simpleIncrementer(23) //simpleIncrementer.apply(23)

  val summer = new Function2[Int,Int,Int] {
    override def apply(v1: Int, v2: Int): Int = v1 + v2
  }
  println(summer(12,13))

  //ALL SCALA FUNCTIONS ARE INSTANCES OF THESE FUNCTION_X TYPES

  val concatWords = new Function2[String, String, String] {
    override def apply(v1: String, v2: String): String = v1+v2
  }
  println(concatWords("Kushan"," Ravindu"))

  val summerWith3args = new Function3[Int,Int,Int,Int] {
    override def apply(v1: Int, v2: Int, v3: Int): Int = v1 + v2 + v3
  }
  println(summerWith3args(10,23,12))

  // Syntax Sugars
  println("-------------------Simplify the above functions using some syntax sugars--------------------------------------")
  val simpleSummer = (v1 : Int,v2 : Int) => v1+v2 // with return type : val simpleSummer : (Int,Int) => Int = (v1 : Int,v2 : Int) => v1+v2
  println(simpleSummer(12,13))

  val simpleConcatWords = (v1 : String,v2 : String) => v1+v2
  println(simpleConcatWords("Kushan"," Ravindu"))



}
