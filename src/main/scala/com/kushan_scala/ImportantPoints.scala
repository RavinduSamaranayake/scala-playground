package com.kushan_scala

object ImportantPoints extends App { // Java equivalent : public static void main(String[] args)

  // Point #1: in Scala we usually operate with Immutable values/Objects
  // Any modifications to an object must return Another object
  /*
  Benefits :
    1) works miracles in multithreaded/distributed env
    2) helps making sense of the code ("reasoning about")
  */
  val aList: List[Int] = List(1,2,3)
  val reverseList: List[Int] = aList.reverse // returns a new List

  //Point #2: Scala is closest to the Object Orient ideal
  /*
   because all the code and all the values that we operate with are inside an instance of some type if you notice every single piece of code that
   we have written so far is part of a class or part of an object so given the fact that there are no values or methods that are outside a class
   or an object we can call scala a true object oriented language
   */
  val num = 1.+(2)
}
