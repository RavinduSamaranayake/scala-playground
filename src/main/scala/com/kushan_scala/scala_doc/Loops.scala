package com.kushan_scala.scala_doc

/**
 * @author Ravindu
 *         9/5/2022
 */
object Loops extends App{
  //For loops
  val numList = List(1,3,4,12,6)
  for(e <- numList) println(e)

  //ForEach
  val people = List("Mahesh","Kushan","Hasaru","Imesh")
  people.foreach(println)

  val numSeq = Seq(1,3,4,12,6)
  numSeq.foreach(println)

  //Map
  val mapValues = Map("Mahesh"->1,"Kushan"->12,"Hasaru"->18,"Imesh"->8)
  //ForEach
  mapValues.foreach{case(k,v) => println(s"Key : $k , Value : $v")}
  //For
  for((k,v) <- mapValues) println(s"Key -: $k, Value -: $v")

  println("--------------------------For Expressions----------------------------------")
  val nums = Seq(1,2,3)
  //You can create a new list of integers where all of the values are doubled, like this:
  val doubledList = for (e <- nums) yield e*2
  println(doubledList)

  //You can use the same approach with a list of strings. For example, given this list of lowercase strings:
  val names = List("adam", "david", "frank")
  val capNames = for (e <- names) yield e.capitalize
  println(capNames)

  //Using a block of code after yield
  val names2 = List("_adam", "_david", "_frank")
  //you first need to remove the underscore character at the beginning of each name, and then capitalize each name.
  val reqNames = for (e <- names) yield e.drop(1).capitalize
  println(reqNames)

}
