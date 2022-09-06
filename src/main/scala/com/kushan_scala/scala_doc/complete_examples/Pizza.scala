package com.kushan_scala.scala_doc.complete_examples

import scala.collection.mutable.ArrayBuffer

/**
 * @author Ravindu
 *         9/6/2022
 */
sealed trait Topping
case object Cheese extends Topping
case object Pepperoni extends Topping
case object Sausage extends Topping
case object Mushrooms extends Topping
case object Onions extends Topping

sealed trait CrustSize
case object SmallCrustSize extends CrustSize
case object MediumCrustSize extends CrustSize
case object LargeCrustSize extends CrustSize

sealed trait CrustType
case object RegularCrustType extends CrustType
case object ThinCrustType extends CrustType
case object ThickCrustType extends CrustType

class Pizza(var crustSize : CrustSize = MediumCrustSize
            ,var crustType : CrustType = RegularCrustType) { //init pizza class constructor with default values

  // ArrayBuffer is a mutable sequence (list)
  val toppings = ArrayBuffer[Topping]()

  def addToppings(t : Topping) : Unit = toppings += t
  def removeTopping(t : Topping) : Unit = toppings -= t
  def removeAllToppings(): Unit = toppings.clear()

  override def toString: String = {
    s"""
    |Crust Size : $crustSize
    |Crust Type : $crustType
    |Toppings : $toppings
    """.stripMargin
  }
}
// a little "driver" app
object PizzaTest extends App{
  val p = new Pizza(LargeCrustSize) // get default value of CrustType
  p.addToppings(Cheese)
  p.addToppings(Pepperoni)
  p.addToppings(Sausage)
  println(p)

  val p1 = new Pizza(SmallCrustSize,ThinCrustType)
  p1.addToppings(Cheese)
  p1.addToppings(Pepperoni)
  p1.addToppings(Sausage)
  p1.removeTopping(Cheese)
  println(p1)

  val p2 = new Pizza(crustType = ThinCrustType)// get default value of CrustSize
  p2.addToppings(Cheese)
  p2.addToppings(Pepperoni)
  p2.addToppings(Sausage)
  p2.removeTopping(Pepperoni)
  println(p2)
}
