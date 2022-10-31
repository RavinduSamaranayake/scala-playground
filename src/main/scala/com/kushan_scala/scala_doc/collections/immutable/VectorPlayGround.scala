package com.kushan_scala.scala_doc.collections.immutable

object VectorPlayGround extends App {
  val nums = Vector(1,2,3,5,6,8,12)
  //nums = nums :+ 5 we can't use due to immutable
  val nums2 = nums.appended(10)
  val nums3 = nums2 :+ 8
  println(nums2)
  println(nums3)

  val nums4 = nums2 ++: nums3
  for(i <- nums4) println(i)
}
