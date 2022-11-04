package com.kushan_scala.monads

object MonadProperties extends App {
  //prop1
  //Monad(x).flatMap(f) == f(x)
  def twoConsecutive(x: Int) = List(x,x+1)
  val funcVal = twoConsecutive(3)
  val prop1Val = List(3).flatMap(x => twoConsecutive(x))
  println(s"Prop 1 : $prop1Val and funcVal : $funcVal")

  //prop2
  //Monad(v).flatMap(x => Monad(x)) USELESS, returns Monad(V)
  val prop2Val = List(1,2,3).flatMap(x => List(x))
  println(s"Prop 2 : $prop2Val")

  //prop3 - ETW-ETW
  val incrementer = (x: Int) => List(x,x+1)
  val doubler = (x: Int) => List(x,x*2)
  val numbers = List(1,2,3)
  val left = numbers.flatMap(incrementer).flatMap(doubler)
  val right = numbers.flatMap(x => incrementer(x).flatMap(doubler))
  println(s" Left val - $left Right val - $right ")
  println(s"Prop 3 : ${left == right}")
 /* List(1,2,2,4 , 2,3,4,6 , 3,4,6,8)
   List(
   incrementer(1).flatMap(doubler) --- 1,2,2,4
   incrementer(2).flatMap(doubler) --- 2,3,4,6
   incrementer(3).flatMap(doubler) --- 3,4,6,8
  )
  Monad(v).flatMap(f).flatMap(g) == Monad(v).flatMap(x => f(x).flatMap(g))
  */
}
