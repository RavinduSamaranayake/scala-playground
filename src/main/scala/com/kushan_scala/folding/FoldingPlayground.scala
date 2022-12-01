package com.kushan_scala.folding

object FoldingPlayground extends App {
  /**
   * The fold method takes two sets of arguments. One contains a start value and the other a combining function.
   * It then steps through the list, recursively applying the function to two operands: an accumulated value and the next element in the list.
   *
   *  Subsequent steps then keep using the next element in the list as the second operand to the combining function,
   *  the accumulated value remaining the first operand in each case, until the end of the list:
   *  list.fold(0)((x,y) => (x+y))
   *
   */


  val list = List(1, 2, 3, 4, 5, 6)
  val sum1 = list.fold(0)((x, y) => (x + y))
  println(s"1st Sum is : $sum1") //1st Sum is : 21

    /**  Step 1: x(0) + y(1) = 1
       *  Step 2: x(1) + y(2) = 3
       *  Step 3: x(3) + y(3) = 6
       *  Step 4: x(6) + y(4) = 10
       *  Step 5: x(10) + y(5) = 15
       *  Step 6: x(15) + y(6) = 21
     */


  val sum2 = list.fold(1)((x, y) => (x + y))
  println(s"2nd Sum is : $sum2") //2nd Sum is : 22

  val sum3 = list.fold(2)((x, y) => (x + y))
  println(s"3rd Sum is : $sum3") //3rd Sum is : 23

  /**
   *  foldLeft
   *  foldLeft iterates through the list from left to right, accumulating elements in that order.
   *  This also means that when processing the two operands to the combining function, the accumulator is the argument on the left:
   */
  case class Person(name: String, sex: String)
  val persons = List(Person("Thomas", "male"), Person("Sowell", "male"), Person("Liz", "female"))

  val foldedLeftList = persons.foldLeft(List[String]()) { (accumulator , person) =>
    val title = person.sex match {
      case "male" => "Mr."
      case "female" => "Mrs."
    }
    accumulator :+ s"$title ${person.name}"   //accumulator.appended(s"$title ${person.name}")
  }
  println(foldedLeftList) //List(Mr. Thomas, Mr. Sowell, Mrs. Liz)

  /**
   * 4. foldRight
   *  foldRight, on the other hand, iterates through the list from right to left,
   *  accumulating elements in that order. Conversely, this means that our accumulator will be the operand on the right in each iteration:
   */

  val foldedRightList = persons.foldRight(List[String]()) { (person,accumulator) =>
    val title = person.sex match {
      case "male" => "Mr."
      case "female" => "Mrs."
    }
    accumulator :+ s"$title ${person.name}" //accumulator.appended(s"$title ${person.name}")
  }

  println(foldedRightList) //List(Mrs. Liz, Mr. Sowell, Mr. Thomas)

  /**
   * Also, notice the order of the elements in the final list. More formally, foldRight associates to the right. i.e., an accumulator will be initialized, and elements will be accumulated in right-to-left order:
   *
   *  List(1, 2, 3).foldRight(0)(f) = f(1, f(2, f(3, 0)))
   */

  //simple Conclusion
  println(List(1, 2, 3, 4, 5).fold(0)(_ + _)) //15
  println(List(1, 2, 3, 4, 5).foldLeft(0)(_ + _)) //15
  println(List(1, 2, 3, 4, 5).foldRight(0)(_ + _)) //15

  /**
   * All the above lines produce the same results. However, if we drill into their internal execution, we’ll see some glaring differences.
   * First, let’s parallelize the list so fold can do the magic it’s intended to do.
   * Without parallelizing, it will just work like foldLeft; like in the very first example:
   * */


  //TODO REFER MORE ABOUT https://www.baeldung.com/scala/folding-lists

  val parallelNumSeq = List(1, 2, 3, 4, 5) //List(1, 2, 3, 4, 5).par
  /**
   * We should pay close attention to the names of the parameters in the combiner function.
   *
   *  Summing with foldLeft:
   *
   */
  val foldLeftResult =
    parallelNumSeq.foldLeft(0) { (acc, currNum) =>
      val sum = acc + currNum
      println(s"FoldLeft: acc($acc) + currNum($currNum) = $sum ")
      sum
    }
  println(foldLeftResult)

  /**
   * Accumulation is done left to right. It’s even clearer when we see the printed result:
   *
   *  FoldLeft: acc(0) + currNum(1) = 1
   *  FoldLeft: acc(1) + currNum(2) = 3
   *  FoldLeft: acc(3) + currNum(3) = 6
   *  FoldLeft: acc(6) + currNum(4) = 10
   *  FoldLeft: acc(10) + currNum(5) = 15
   *  15
   *  */


}
