package com.kushan_scala.scala_doc.collections.immutable

object ImmutableMap extends App {
  val states = Map("AK" -> "Kushan", "BL" -> "Ravindu", "CL" -> "Samaranayake", "CN" -> "ovkr")

  //Access
  val ak = states("AK")
  val bl = states("BL")
  println(s"AK : $ak BL : $bl")
  for ((k,v) <- states) println(s"Key : $k , Value : $v")

  //Add
  println("-----------------------Adding part-------------------")
  val states2 = states + ("MG" -> "Mageed") + ("AB" -> "Abeed")
  println(states2)
  val states3 = states ++ states2 ++ Seq("AL" -> "Alee","TL" -> "Telee")
  println(states3)

  //Remove
  println("-----------------------Removing part--------------------")
  val states4 = states - "CN" - "CL"
  println(states4)
  val states5 = states.removed("AK")
  println(states5)

  //Update
  println("-----------------------Updating Part--------------------")
  val states6 = states.updated("AK" , "Ravindu95")
  val states7 = states + ("AK" -> "Kushan95")
  println(states7)
  println(states6)
}
