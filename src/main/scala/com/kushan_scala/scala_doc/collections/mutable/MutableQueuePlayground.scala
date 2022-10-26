package com.kushan_scala.scala_doc.collections.mutable

import scala.collection.mutable

object MutableQueuePlayground extends App{
  val queue = new mutable.Queue[String]()
  queue += "a"
  queue += "b"
  queue ++= List("l","m","n")
  println(queue)
  queue -= "b"
  println(queue)
  println(queue.dequeue())
  println(queue)
}
