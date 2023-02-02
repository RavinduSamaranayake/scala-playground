package com.kushan_scala.implicits

object ImplicitBasePlayGround extends App{

  //normal method
  def multiply(x : Int)(y: Int) : Int = x*y
  println(multiply(10)(20))

  println("---------------------------------------using implicit---------------------------------------------------")
  def multiplyWithImplicit(x:Int)(implicit y:Int) = x*y

  implicit val  useImplicitInt: Int = 10

  println(multiplyWithImplicit(10)(23))
  println(multiplyWithImplicit(10))

}
