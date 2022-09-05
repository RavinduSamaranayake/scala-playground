package com.kushan_scala.scala_doc

/**
 * @author Ravindu
 *         9/5/2022
 */
object MatchExpression extends App {

  def getMonthName(monthNo: Int): String = {
    val monthName = monthNo match {
      case 1 => "January"
      case 2 => "February"
      case 3 => "March"
      case 4 => "April"
      case _ => "Invalid Month"
    }
    monthName
  }
  //Simplify
  def getMonthNameSimple(monthNo: Int): String = monthNo match {
      case 1 => "January"
      case 2 => "February"
      case 3 => "March"
      case 4 => "April"
      case _ => "Invalid Month"
  }

  println(getMonthName(6))
  println(getMonthNameSimple(6))

  def matchAnything(anything : Any) : Boolean = anything match {
    case 0 | "" => true
    case _ => false
  }
  println(matchAnything(123))

  def cmdMatching(cmd : String) : Unit = cmd match {
    case "HI" | "HEY" | "YOO" => println("You re Welcome!")
    case "BYE" | "THANKS" | "CU" | "OK" => println("Good Bye!")
    case _ => println("Thank You!")
  }

  cmdMatching("BYE")

  //Using if expressions in case statements
  def checkSomeCond(value : Int) : Unit = value match {
    case a if a >= 10 && a <= 15 => println(s"Value in Range 10 - 15 : $a")
    case b if 30 to 40 contains b => println(s"Value in Range 30 - 40 : $b ")
    case c if 45 to 55 contains(c) => println(s"Value in Range 45 - 55 : $c ")
    case _ => println("Hmmmm...")
  }
  checkSomeCond(10)


  case class Stock(symbol: String,price : Long){
  }

  def buy(x: Stock): Unit = println(s"Stock $x buy trade...")

  def sell(x: Stock): Unit = println(s"Stock $x sell trade...")

  def doNothing(x: Stock): Unit = println(s"Stock $x not trade...")

  def stockMatching(stock : Stock) : Unit = stock match {
    case x if (x.symbol == "XYZ" && x.price < 20) => buy(x)
    case x if (x.symbol == "XYZ" && x.price > 50) => sell(x)
    case x => doNothing(x)
  }

  stockMatching(Stock("XYZ",10))
  stockMatching(Stock("XYZ",30))
  stockMatching(Stock("XYZ",100))
  stockMatching(Stock("AAPL",100))
}
