package com.kushan_scala.scala_doc.collections.mutable

import scala.collection.mutable

object StringBuilderPlayground extends App{
  val stringBuilder = new mutable.StringBuilder
  stringBuilder += 'a'
  stringBuilder ++= "hbc"
  println(stringBuilder)
  stringBuilder += 'l'
  println(stringBuilder.toString())
}
