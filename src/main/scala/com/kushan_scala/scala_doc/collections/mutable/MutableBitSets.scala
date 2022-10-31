package com.kushan_scala.scala_doc.collections.mutable

import scala.collection.mutable

object MutableBitSets extends App{
  val bits = mutable.BitSet.empty
  bits += 1
  bits += 10
  println(bits)
}
