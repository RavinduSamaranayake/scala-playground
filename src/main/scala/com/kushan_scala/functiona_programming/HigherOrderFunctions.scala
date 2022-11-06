package com.kushan_scala.functiona_programming
//before this chapter please visit to basic FunctionalProgramming Object
//take functions as args or return functions as results or both
object HigherOrderFunctions extends App { //HOF
  //Map
  val aMappedList: List[Int] = List(1,2,3).map(x => x+1) //using anonymous function
  println(aMappedList)
  //flatMap
  val aFlatMappedList = List(1,2,3).flatMap(x => List(x,2*x))
  println(aFlatMappedList)
  //filters
  val aFilteredList = List(1,2,3,4,5).filter(_ <= 3) //equivalent to (x => x <= 3)

  //all pairs between the numbers 1,2,3 and the letters 'a','b','c'
  val numList = List(1,2,3,4,5,6)
  val letterList = List('a','b','c','d','e')
  val outputList = numList.filter(_<=3)
    .flatMap(number => letterList.filter(_<='c')
      .map(letter => (number,letter))) //in scala we usually work with immutable objects and collections,
  // in this case every single application to MAP FLATMAP or FILTER will always return a another instance of a List.
  // so we can chain to Application to MAP FLATMAP and FILTER
  println(outputList)


  //in big scala code bases chain such as this one are increasingly hard to read if the logic increasingly complex
  //so scala syntax allows for a pretty human readable 'for comprehensions'
  val alternativePairs = for {
    num <- List(1,2,3)
    letter <- List('a','b','c')
  } yield (num,letter) //equivalent to map/flatMap chain above

  println(alternativePairs)

  val alternativePairs3 = for {
    num <- List(1, 2, 3)
    letter <- List('a', 'b', 'c')
    symbol <- List('#', '%')
  } yield (num, letter, symbol) // alternative for nested for loops

  println(alternativePairs3)
}
