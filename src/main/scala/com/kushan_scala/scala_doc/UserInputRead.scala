package com.kushan_scala.scala_doc

import scala.io.StdIn.readLine

/**
 * @author Ravindu
 *         9/5/2022
 */
object UserInputRead extends App {
  print("Enter your first name : ")
  val firstName = readLine()

  print("Enter your last name : ")
  val lastName = readLine()

  println(s"Your full name is : $firstName $lastName")
}
