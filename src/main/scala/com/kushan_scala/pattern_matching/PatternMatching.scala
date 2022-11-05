package com.kushan_scala.pattern_matching

object PatternMatching extends App{
  // switch expression
  val anInt = 55
  val order = anInt match {
    case 1 => "first"
    case 2 => "second"
    case 3 => "third"
    case _ => anInt + "th"
  } //PM is an Expression
  println(order)

  //Case class decomposition
  case class Person(name : String,age : Int)
  val bob = Person("Bob",22)
  val personGreet = bob match {
    case Person(n,a) => s"Hi, I'm $n and My age is $a ."
    case _ => "Something else"
  }
  println(personGreet)

  //Deconstructing tuples
  val aTuple = ("Kushan Ravindu","Creative SE")
  val user_desc = aTuple match {
    case (name,company) => s"$name works on $company"
    case _ => s"Unknown user"
  }
  println(user_desc)

  //Decomposing Lists
  val aList = List(1,2,3)
  val listDisc = aList match {
    case List(_,2,_) => s"List containing 2 on its 2nd pos"
    case List(_,_,3) => s"List containing 3 on its 3rd pos"
    case _ => "unknown List"
  }
  println(listDisc)

  //PM will try all cases in sequence
}
