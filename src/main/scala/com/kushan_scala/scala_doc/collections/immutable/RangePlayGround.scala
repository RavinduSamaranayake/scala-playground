package com.kushan_scala.scala_doc.collections.immutable

object RangePlayGround extends App {
  val a = 1 to 10
  println(a)
  val b = a.toList
  println(b)
  val doubleValues = (1 to 7).map(_*2.0)
  println(doubleValues)
}
