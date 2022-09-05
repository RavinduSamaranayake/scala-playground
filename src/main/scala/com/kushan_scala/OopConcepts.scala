package com.kushan_scala

/**
 * @author Ravindu
 *         9/5/2022
 */
object OopConcepts extends App {
  //class and instance
  class Animal {
    //define fields
    var age = 0

    //define methods
    def eat(): Unit = println("Eating animal")
    def isWalking(animalType : String) : Boolean = {
      println("Animal Type is : " + animalType)
      animalType.equals("DOG") || animalType.equals("CAT")
    }
  }

  val animal = new Animal
  animal.eat()


}
