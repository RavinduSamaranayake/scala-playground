package com.kushan_scala.scala_doc.collections.mutable

import scala.collection.mutable

object MutableStackPlayground extends App {
  val stack = new mutable.Stack[Int]()
  stack += 1
  stack ++= List(1,3,5)
  println(stack)
  stack.push(10,23)
  println(stack)
  println(stack.pop())
  println(stack)
}
