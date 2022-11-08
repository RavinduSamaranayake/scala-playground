package com.kushan_scala.generics

object GenericsBasics {
  abstract class MyList[T] {
    def head : T
    def tail : MyList[T]
  }
}
