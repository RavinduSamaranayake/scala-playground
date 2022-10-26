package com.kushan_scala.scala_doc.compariosn_with_java.traits_interfaces

trait Adder{
  def add(a : Int,b : Int) : Int
}

trait Multiplier{
  def multiply(a : Int,b : Int) : Int = a*b
}

class ScalaMath extends Adder with Multiplier {
  override def add(a: Int, b: Int): Int = a+b
}
