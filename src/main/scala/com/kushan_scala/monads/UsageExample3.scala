package com.kushan_scala.monads

object UsageExample3 extends App {
  //double for loops
  val numbers = List(1,2,3)
  val chars = List('a','b','c')
  //need all combinations of these two lists
  //flatMap
  val combList1 = numbers.flatMap(num => chars.map(char => (num,char)))
  println(combList1)

  //for comprehensive
  val combList2 = for {
    number <- numbers //extract this
    char <- chars //extract this
  } yield (number,char) //transform and build a tuple and wrap everything to the list

  println(combList2)
}
