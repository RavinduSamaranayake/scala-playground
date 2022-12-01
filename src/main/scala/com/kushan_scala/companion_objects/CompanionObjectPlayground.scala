package com.kushan_scala.companion_objects

/*https://docs.scala-lang.org/overviews/scala-book/companion-objects.html*/
object CompanionObjectPlayground {
  //Why this concept
  /**
   1.This has several benefits. First, a companion object and its class can access each other’s private members (fields and methods).
   This means that the printFilename method in this class will work because it can access the HiddenFilename field in its companion object:
   * */
  class SomeClass {
    def printFilename() = {
      println(SomeClass.HiddenFilename)
    }
  }

  object SomeClass {
    private val HiddenFilename = "/tmp/foo.bar"
  }

  val someClass = new SomeClass
  someClass.printFilename()

  /**
   2.without having use the new keyword before the class name

   This functionality comes from the use of companion objects. What happens is that when you define an apply method in a companion object,
   it has a special meaning to the Scala compiler. There’s a little syntactic sugar baked into Scala that lets you type this code:
   */
  class Pizza(pizzaName: String) {
    var name: String = pizzaName

    def printPizza(): Unit = {
      println(name)
    }
  }

  //creating objects
  val pizza: Pizza = new Pizza("Hamberg") // we can't write   val pizza = Pizza("Hamberg")
  pizza.printPizza()


  // with companion objects
  class PizzaWithCompanion {
    var name: String = ""

    def printPizza(): Unit = {
      println(name)
    }
  }

  object PizzaWithCompanion {
    def apply(name: String): PizzaWithCompanion = {
      var pizza = new PizzaWithCompanion
      pizza.name = name
      pizza
    }
  }

  val pizzaWithCompanion: PizzaWithCompanion = PizzaWithCompanion("chicken chilli") //no need to new keyword here compiler takes this as PizzaWithCompanion.apply("chicken chilli")
  pizzaWithCompanion.printPizza()

  /**
  * To be clear, what happens in this process is:

  You type something like val p = Person("Fred")
  The Scala compiler sees that there is no new keyword before Person
  The compiler looks for an apply method in the companion object of the Person class that matches the type signature you entered
  If it finds an apply method, it uses it; if it doesn’t, you get a compiler error
  **/

  //Multiple Construction
  class Person {
    var name : Option[String] = None
    var age : Option[Int] = None

    override def toString: String = s"$name and $age"
  }

  object Person {
    def apply(name : Option[String],age : Option[Int]) = {

    }
  }

  def main(args: Array[String]): Unit = {
    println("Success....")
    val pizzaList = List(new Pizza("Curry"),new Pizza("meet"),new Pizza("veg"))
    val companionList = List(PizzaWithCompanion("Curry"),PizzaWithCompanion("meet"),PizzaWithCompanion("veg"))
  }
}
