package com.kushan_scala.scala_doc.collections.mutable

import scala.collection.mutable.ListBuffer

object ListBufferPlayGround  extends App{
  var stringBuffer = ListBuffer[String]()
  stringBuffer += "Hello"
  stringBuffer ++= List("Hi","Hey","Welcome","Sudo")
  println(stringBuffer)
  stringBuffer -= "Hello"
  stringBuffer --= List("Hey","Sudo")
  println(stringBuffer)
  stringBuffer.update(0,"Hii")
  println(stringBuffer)

}
