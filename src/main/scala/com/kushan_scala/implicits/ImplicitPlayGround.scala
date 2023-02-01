package com.kushan_scala.implicits

object ImplicitPlayGround extends App{

  //normal method
  def multiply(x : Int)(y: Int) : Int = x*y
  println(multiply(10)(20))

}
