package com.kushan_scala.scala_doc.compariosn_with_java.mixins

class MixinsExample {
  class DavidBanner

  trait Angry {
    println("I’m angry calling")

    def beAngry(): Unit = println("You won’t like me ...")
  }

  trait Big {
    println("I’m big calling")
  }

  trait Green {

    println("I’m green calling")
  }

  // mix in the traits as DavidBanner
  // is created
  def printingMixins(): Unit = {
    println("*******************************Start Printing hulk values*************************************")
    val hulk = new DavidBanner with Big with Angry with Green
    hulk.beAngry()

    println("*******************************Start Printing hulk2 values*************************************")
    val hulk2 = new DavidBanner with Big with Angry
    hulk2.beAngry()
  }
}


object MixinsExampleRunner extends App {
  val mixinsExample = new MixinsExample()
  mixinsExample.printingMixins()
}
