package com.kushan_scala.typeclasses

object TestTypeClasses extends App{
  trait Combinable[A] {
    def combine(x: A, y: A): A
  }
  //Now you can implement the instance
  implicit val combineInts = new Combinable[Int] {
    override def combine(x: Int, y: Int): Int = x+y
  }

  println(combineInts.combine(5,6))

  //for custom classes
  case class Foo(val1:String,val2:Int)

  implicit val combineFoo = new Combinable[Foo] {
    override def combine(x: Foo, y: Foo): Foo = {
      Foo(x.val1.concat(y.val1) , x.val2.+(y.val2))
    }
  }
  println(combineFoo.combine(Foo("Kushan",11),Foo("Ravindu",12)))

}
