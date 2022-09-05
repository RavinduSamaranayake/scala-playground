package com.kushan_scala.scala_doc

/**
 * @author Ravindu
 *         9/5/2022
 */
object HelloYou extends App{
  if(args.length == 0)
    println("Hello, You")
  else
    println("Hello, "+ args(0))
}
