package com.kushan_scala.implicits

/**
 * @author Ravindu
 *         12/8/2022
 */
object ImplicitPlayground extends App{
  //normal way
  def multiply(num1 : Int)(num2 : Int) = num1*num2
  println(multiply(10)(25)) // parsing arguments explicitly

  //with implicits
  def multiplyWithImplicit(num1 : Int)(implicit num2 : Int) = num1*num2
  println(multiplyWithImplicit(10)(20)) //200
  //println(multiplyWithImplicit(30)) //could not find implicit value for parameter num2: Int
  implicit val impNum = 23
  println(multiplyWithImplicit(12)) //276 // when you declare the implicit value no need to pass that value to function
  //in here the compiler will internally check is there any declaration that exist for the implicit keyword

  //usage : according to this ex if you no need to change second parameter in other usages and need to change only one parameter Implicit is the IDEAL.
}
