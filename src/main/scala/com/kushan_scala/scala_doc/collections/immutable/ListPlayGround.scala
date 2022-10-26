package com.kushan_scala.scala_doc.collections.immutable

object ListPlayGround extends App {
  //same as List charList = List.of(1,2,3,4,5,6) in java
  val anyList = List('a', 'b', 'c', 'd', 'e',"Hello",3)

  val anyList2 = anyList.appended('k', 'm') // we can't add modify same object collection and instead of that we can create
  // a separate collection with appending to the previous collection
  println(anyList2)
  println(anyList)
  println(anyList2)

  //Modifications
  val intList: List[Int] = List(1, 2, 3, 4, 5, 6) // with type safe
  val intList2 = 16 +: intList //prepend
  val intList3 = intList2.prepended(32)
  println(intList3)
  println(intList2)
  val intList4 = intList :+ 12
  val intList5 = intList4 :+ 17
  println(intList5)
  println(intList4)
  val intList6 = intList4 ::: intList5 ::: intList3
  println(intList6)

  //printing all values
  for( i <- anyList2) println(s"element : $i")



  println("-------------------------Lazy Lists--------------------------")
  val lazyList = LazyList.range(1,20)
  lazyList.take(1) // LazyList(<not computed>)
  lazyList.take(5) // LazyList(<not computed>)
  lazyList.map(_ + 1) // LazyList(<not computed>)

  lazyList.take(6).foreach(println)

}
