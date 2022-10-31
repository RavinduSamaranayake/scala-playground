package com.kushan_scala.scala_doc.collections.mutable

import scala.collection.mutable.ArrayBuffer

object ArrayBufferPlayGround extends App {
  var stringBuffer = ArrayBuffer[String]() //empty buffers
  var intBuffer = ArrayBuffer[Int]() // empty
  println(stringBuffer)

  intBuffer ++= Set(2,4,5,5)
  println(intBuffer)

  case class Person(name : String) // same as java records

  var numBuf = ArrayBuffer(1,2,3,4)
  var peoples = ArrayBuffer(Person("Kushan"),Person("Ravindu"),Person("Sachin"))

  println("-------Adding Values--------")
  numBuf += 5
  numBuf ++= List(8,9,12)
  peoples += Person("Sahan")
  println(peoples)
  println(numBuf)
  println("------Removing Values----------")
  numBuf -= 9
  numBuf --= Seq(1,3)
  println(numBuf)
  println("------Updating Values----------")
  numBuf(1) = 100
  numBuf.update(0,78)
  println(numBuf)
}
