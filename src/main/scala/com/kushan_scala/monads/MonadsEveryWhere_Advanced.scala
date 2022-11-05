package com.kushan_scala.monads

import scala.util.Try

object MonadsEveryWhere_Advanced extends App {
  val aList = List(1,2,3,4)
  val anIncrementedList = aList.map(x => x+1) //same as asList.map(_+1)
  val aFlatMapList = aList.flatMap(x => List(x,x+1))

  // same for Lists, Options, Try, IO, many other types

  def combineList(chr : List[Char],num : List[Int]) : List[(Char,Int)] = for {
    s <- chr
    n <- num
  } yield (s,n)
  println(combineList(List('A','B','C'),List(1,2,3,4)))

  def combineOptions(chr : Option[Char],num : Option[Int]) : Option[(Char,Int)] = for {
    s <- chr
    n <- num
  } yield (s,n)

  val combineOp = combineOptions(Option('A'),Option(1))
  println(combineOp)

  def combineTry(chr: Try[Char], num: Try[Int]): Try[(Char, Int)] = for {
    s <- chr
    n <- num
  } yield (s, n)
  println(combineTry(Try('A'),Try(3)))


  //Let's generics All together
  trait Monad[M[_]] {
    def pure[A](a: A) : M[A]
    def flatMap[A,B](ma: M[A])(f: A => M[B]) : M[B]

    //for free
    def map[A,B](ma: M[A])(f: A => B) : M[B] =
      flatMap(ma)(a => pure(f(a)))
  }
  //def combine[M[_]](str : M[String])(num : M[Int])(monad: Monad[M]) : M[(String, Int)] = monad.flatMap(str)(s => monad.map(num)(n => (s,n)))
  //Todo indeep learn

}
