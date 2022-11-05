package com.kushan_scala.futures

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Future, Promise}
import scala.util.{Failure, Success}

object WritableFutures extends App {

  val aFuture = Future{
    42 //this will be evaluated on some thread at some point in time without your control
  }
  // so futures are inherently non-deterministic

  //given - multithreaded
  object MyService{
    def produceAPreciousValue(theArg: Int) : String = "the meaning of value : "+ (theArg/42)
    def submitTask[A](actualArg: A)(function: A => Unit) : Boolean = {
      //run the function on actualArg at SOME POINT
      //println(actualArg)
      true
    }
  }

/*  //target
  def gimmeMyPreciousValue(yourArg: Int): Future[String] = Future {
    MyService.produceAPreciousValue(yourArg) // this will be wrong, in that is because spwaning up the thread responsible for evaluating this function
    // is not up to you it depends on the service. so you cannot spawn the service your self. so you will need to depend on the service and return a future string
  }*/

  // introducing Promises = "controller" of a  future
  // step 1 - create a promise
  val myPromise = Promise[String]()
  // step 2 - extract its future
  val myFuture = myPromise.future
  // step 3 - consume the future
  val furtherProcessing = myFuture.map(_.toUpperCase())

  // step 4
  def asyncCall(promise: Promise[String]) : Unit = {
    promise.success("Your Value here....")
  }

  // step 5 - call the producer
  asyncCall(myPromise)

/*               practical scenario                  */

  //target
  def gimmeMyPreciousValue(yourArg: Int): Future[String] = {

    // step 1 - create the promise
    val thePromise = Promise[String]()

    // step 5
    MyService.submitTask(yourArg){ x : Int =>
      // step 4 - producer logic
      val preciousValue = MyService.produceAPreciousValue(x)
      thePromise.success(preciousValue)
    }

    // step 2 - extract the future
    thePromise.future
  }
    //step 3 - someone will consume my Future
  val strVal = gimmeMyPreciousValue(1000)
  strVal.onComplete{
    case Success(value) => println(s"Output is :$value")
    case Failure(exception) => println(exception)
  }
  println(strVal.isCompleted)
  }
