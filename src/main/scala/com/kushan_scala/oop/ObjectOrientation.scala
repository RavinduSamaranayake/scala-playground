package com.kushan_scala.oop

object ObjectOrientation extends App {
  class Animal{
    //define fields
    val age : Int = 0
    //define methods
    def eat(): Unit = println("I'm eating")
  }
  val anAnimal = new Animal

  //inheritance
  class Dog(val name:String) extends Animal // constructor definition : when we put a val before constructor argument it becomes public member of that class
  val aDog = new Dog("Lassie")        // if u need to restrict access to the outside put private before val    class Dog(private val name:String)

  // constructor arguments are not field : to promote as a field need to put a val before the constructor argument
  aDog.name

  // subtype polymorphism
  val aDeclaredAnimal : Animal = new Dog("Hachi")
  aDeclaredAnimal.eat()

  // abstract class
  abstract class WalkingAnimal {
    protected val hasLegs = true // by default public, can restrict by adding protected or private
    def walk() : Unit
  }

  // "interface" = ultimate abstract type
  trait Carnivore {
    def eat(animal: Animal) : Unit
  }

  //Scala is single-class inheritance and multi trait "mixins"
  //Class 'WalkingAnimal' needs to be trait to be mixed in
  /*class Crocodile extends Animal with WalkingAnimal{
    override def walk(): Unit = ???
  }*/
  //some actor method name
  trait Philosopher {
    def ?!(thought: String): Unit // valid method name
  }
  //mixins
  class Crocodile extends Animal with Carnivore with Philosopher {
    override def eat(animal: Animal): Unit = println(s"Eating a $animal")

    override def eat(): Unit = super.eat()

    override def ?!(thought: String): Unit = println(s"I was thinking $thought")
  }

  val littleCrocodile = new Crocodile
  littleCrocodile.eat(aDog)
  littleCrocodile eat aDog //infix notation = object method argument, only available for methods with ONE argument
  littleCrocodile.eat()
  littleCrocodile ?! "what if we could we fly?"

  // Operators in Scala are actually methods
  val basicMath = 1 + 2
  val anotherBasicMath = 1.+(2)

  // Anonymous classes
  val dinosaur = new Carnivore {
    override def eat(animal: Animal): Unit = println("I'm a dinosaur so I can eat anything")
  }
  /*
  what you tell the compiler :

  1. Hey compiler create a new class ,

  class Carnivore_Anonymous_35728 extends Carnivore {
      override def eat(animal: Animal): Unit = println("I'm a dinosaur so I can eat anything")
  }

  2. Hey Compiler can you Instantiate this class for me

  val dinosaur = new Carnivore_Anonymous_35728
  */

  // singleton object
  object MySingleton { // the only instance of the MySingleton type
    val mySpecialValue = 532798
    def mySpecialMethod() : Int = 5327
    def apply(x:Int) : Int = x+1
  }
  MySingleton.mySpecialMethod()
  MySingleton.apply(65)
  MySingleton(65) // equivalent to MySingleton.apply(65)

  object Animal{ //companions - companion object (class name and object name are same)
    //companions can access each each other's private fields/methods
    //singleton Animal and instances of Animal are different thing
    val canLive = false
  }

  val animalCanLive = Animal.canLive // "static" fields/methods
  println(animalCanLive)
  /*

  */

}
