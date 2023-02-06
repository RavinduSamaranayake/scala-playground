package com.kushan_scala.advance_concepts

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.DurationInt
import scala.concurrent.{Await, Future}

object ForComprehension extends App {

  //https://nrinaudo.github.io/scala-best-practices/tricky_behaviours/future_in_comprehensions.html
  //Example1
  private def longRunning(): Int = {
    Thread.sleep(100)
    println("LONG")
    1
  }

  private def immediate(): Int = {
    println("IMMEDIATE")
    2
  }

  def combine(): Future[Int] = for {
    i <- Future(longRunning())
    j <- Future(immediate())
  } yield i + j

  //println(Await.result(combine(),100.millis))

  /**
   * This can be worked around by creating the two Future instances outside of the for-comprehension:
   * Future has the controversial behaviour that it starts executing when created, not when evaluated.
   */


  println("---------------------------------------------------------------------------------------------------------------------")


  /**   And if we now evaluate betterCombine, the log messages should print in the expected order:   */
  private def betterCombine(): Future[Int] = {
    val f1 = Future(longRunning())
    val f2 = Future(immediate())

    for {
      i <- f1
      j <- f2
    } yield i + j
  }

  println(Await.result(betterCombine(), 100.millis))


//  private def betterCombine2() = {
//    val f1 = Future(None)
//    val f2 = Future("ABCD")
//
//    for {
//      i <- f1
//      j <- f2
//    } yield i + j
//  }
//
//  //println(Await.result(betterCombine2(), 100.millis))
//
//  val f1 = Future(None)
//  val f2 = Future("ABCD")
//
//  private def combine3() = {
//
//
//    for {
//      i <- f1
//      j <- f2
//    } yield i + j
//  }
//
//  println(Await.result(combine3(), 100.millis))
//

}