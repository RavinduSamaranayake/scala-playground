package com.kushan_scala.advance_concepts

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Success, Try}


object Advanced extends App {
/**
 *  1. lazy evaluation
 **/
  lazy val aLazyValue = 2
  lazy val lazyValueWithSideEffects = {
    println("very lazy man!")
    43
  }
  val withoutLazy = {
    println("not lazy man!")
    43
  }

  //lazy value is evaluated when it's first used
  val eagerValue = lazyValueWithSideEffects + 1

  // useful in infinite collections


/**
 *  2.pseudo-collections : Option, Try
 **/
  // these are very useful in some use cases in large code bases when you have unsafe methods
  def methodCanReturnNull(): String = "Hello, Scala"

  val anOption = Option(methodCanReturnNull()) //Some("Hello, Scala")
  // option = "Collection" which contains at most one element: Some(value) or None

  val stringProcessing = anOption match {
    case Some(value) => s"Obtained value is : $value"
    case None => "Obtained Nothing"
  }

  def methodWhichCanThrowException(): String = throw new RuntimeException

  //without using pseudo-collections
  try {
    methodWhichCanThrowException()
  } catch {
    case e: Exception => s"defined against this evil value : $e"
  }
  //with using pseudo-collections
  val aTry = Try(methodWhichCanThrowException())
  // a try = "collection" with either a value if the code went well, or an exception if the code threw one

  val anotherStringProcessing = aTry match {
    case Success(validValue) => s"Obtained a valid value : $validValue"
    case Failure(exception) => s"Obtained exception : $exception"
  }

  //the Try object and the Option object can be processed like we did with collections so both try and option have the map flatmap and
  // filter compositional functions alongside some others

  /**
   *3. Evaluate something on another thread
   * (asynchronous programming)
   **/
  // this is done with another quote-unquote pseudo collection known as a future

  val aFuture = Future({ // same to Future.apply(....)
    println("Loading...........")
    Thread.sleep(1000)// this call is very familiar with java devs - this will actually block the running thread by one second (1000ms)
    println("I have computed a value")
    67
  })
  //import scala.concurrent.ExecutionContext.Implicits.global
  // after the above import now global value is available to you run this future
  /** the global value is the equivalent of a thread pool that is a collection of threads on which we can schedule the evaluation of this expression*/

/*  if we run this app we will see "loading...." but main thread of the JVM the main thread of the application finished before this future had the chance to
   evaluate. that is a proof that this future the block that I put here under the constructor of the future was actually evaluated on another thread*/

  //if I do  Thread.sleep(2000) under the main JVM thread then this feature will also have the chance to evaluate
  Thread.sleep(2000)

  //Future is a "collection" which contains a value when it's evaluated
  //Future is composable with map, flatMap and filter
  //The Future Try amd Option types are called monads in functional programming
  //but for now just don't think about it. think of future try an option as some sort of a collection

  /**
   *4. Implicits
   **/
  //this is the most powerfully feature of scala compiler




}
