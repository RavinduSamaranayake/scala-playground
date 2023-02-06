package com.kushan_scala.testQS

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}
import scala.util.Try

object QS1 extends App {
  //1
  println("-------------------------------1-----------------------------")
  val a = Option(5)
  val b = Option(3)
  val c = for {
    a1 <- a
    b1 <- b
  } yield s"$a1  $b1"
  println(c)

  //2
  println("-------------------------------2-----------------------------")
  val a2 = Option(5)
  val b2 = Option(3)
  val c2 = for {
    a1 <- a2
    b1 <- b2
  } yield a1 + b1
  println(c2)

  //3
  println("--------------------------------3----------------------------")
  val a3 = Option(5)
  val b3 = Option(3)
  val c3 = for {
    a1 <- a3
    b1 <- b3
  } yield a1 + b1
  val d3 = c3.map(_ + 44)
  println(d3)

  //4
  println("-------------------------------4-----------------------------")
  val a4 = Option(5)
  val b4 = Option(3)
  val c4 = for {
    a1 <- a4
    b1 <- b4
  } yield a1 + b1

  def temp(input: Int): Option[Int] = Option(input)

  val d4 = c4.flatMap(temp)
  println(d4)

  //5
  println("-------------------------------5-----------------------------")
  val a5 = List(Option(4), None, Option(2))
  val c5 = a5.flatten.map(_.toString)
  println(c5)


  //6
  println("-------------------------------6-----------------------------")
  val a6 = List(Try(4), Try(2), Try(2))
  val c6 = a6.map(_.toString)
  println(c6)


  //7
  println("-------------------------------7-----------------------------")
  def temp2(aa: Int, f: Int => Try[List[Int]]): Try[List[String]] = {
    val xx = f(aa)
    xx.map(_.map(_.toString))
  }

  def tempAB(ab: Int): Try[List[Int]] = {
    Try {
      List(ab)
    }
  }

  val value1 = temp2(2, tempAB)
  println(s"7 $value1")


  //8
  println("-------------------------------8-----------------------------")
  val value = 10
  implicit val multiplier: Int = 3

  def multiply(implicit by: Int) = value * by

  val result = multiply
  println(result)


  //9
  println("-------------------------------9-----------------------------")
  val az1 = Try(33)
  val az2 = Try(34)
  val az3 = Try(throw new Exception)
  val aaz = for {
    _ <- az1
    _ <- az3
    _ <- az2
  } yield ()
  println(aaz)

  //10
  println("-------------------------------10-----------------------------")
  val v1 = Future.successful(3)
  val v2 = Future.successful(3)
  val v3 = Future[Int] {
    throw new Exception
  }
  val ccv = for {
    va1 <- v1
    va2 <- v2
    va3 <- v3
  } yield va1 + va2 + va3
  val triedInt = Try {
    Await.result(ccv, Duration.Inf)
  }
  println(triedInt)

  //11
  println("-------------------------------11-----------------------------")
  val az11 = Try(33)
  val az12 = Try(34)
  val aa2z = for {
    ax <- az11
    ay <- az12
  } yield ax + ay
  println(aa2z)

  //12
  println("-------------------------------12-----------------------------")
  val vc1 = Future.successful(3)
  val vc2 = Future.successful(3)
  val vc3 = Future.successful(4)
  val cccv = for {
    va1 <- vc1
    va2 <- vc2
    va3 <- vc3
  } yield va1 + va2 + va3
  val triedInt1 = Try {
    Await.result(cccv, Duration.Inf)
  }
  println(triedInt1)
}
