package com.kushan_scala.scala_doc.collections

object Collections extends App {
  //lists
  val aList = List(1,2,3,4,5)
  val firstElement = aList.head
  val rest = aList.tail
  val aPrependList = 0::aList //List(0,1,2,3,4,5)
  println(aPrependList)
  val anExtendedList = 0 +: aList :+ 6 //List(0,1,2,3,4,5,6)

  //sequences
  val aSequence: Seq[Int] = Seq(1,2,3) //Seq.apply(1,2,3)
  val accessedElement = aSequence(1) //aSequence.apply(1)
  println(accessedElement)

  //vectors : fast Seq implementation
  val aVector = Vector(1,2,3,4,5)

  //sets = no duplicates
  val aSet = Set(1,2,3,4,1,2,3) //Set(1,2,3,4)
  val setHas5 = aSet.contains(5) //false
  val andAddedSet = aSet + 5 //Set(1,2,3,4,5)
  val aRemoveSet = aSet - 3 // Set(1,2,4)
  println(s"access element of set ${aRemoveSet(0)}")

  //tuples = groups of values under the same value
  val aTuple = ("Bon Jovi","Rock",1982)

  //maps
  val aPhoneBook : Map[String,Int] = Map(
    ("Kushan",12),
    "Ravindu"->20,
     "Jan" -> 18)

  println(aPhoneBook("Kushan"))
  println(aPhoneBook("Ravindu"))



}
