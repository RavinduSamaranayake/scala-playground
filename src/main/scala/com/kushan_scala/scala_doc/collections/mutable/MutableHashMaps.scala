package com.kushan_scala.scala_doc.collections.mutable

import scala.collection.mutable

object MutableHashMaps extends App{
  val map = mutable.HashMap.empty[Int,String]
  map += (1 -> "Kushan")
  map += (2 -> "Ravindu")
  println(map)
  map.addOne(3,"Sam")
  map ++= Seq(6->"Janak",7->"Afg",8->"Mahesh")
  println(map)
  map.addAll(Seq(4->"Janak4",5->"Afg4"))
  println(map)
  println(map(4))
  println(map contains 5)
}
