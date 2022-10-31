package com.kushan_scala.scala_doc.collections.immutable

object ImmutableSet extends App {
  val valueSet = Set(1,2,3,3,3,4)
  println(valueSet)
  println("-----------add values to set-------------------")
  val set1 = valueSet + 8
  val set2 = valueSet ++ set1
  println(set1)
  println(set2)
  println("-----------deleting element from set------------")
  val set3 = valueSet - 3 - 1
  println(set3)
}
