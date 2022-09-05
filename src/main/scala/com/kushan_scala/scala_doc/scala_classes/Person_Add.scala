package com.kushan_scala.scala_doc.scala_classes

/**
 * @author Ravindu
 *         9/5/2022
 */
class Person_Add (var firstName : String, var lastName : String){
  println("The constructor begin...")
  // 'public' access by default
  var age = 0

  // some class fields
  private val HOME = System.getProperty("user.home")

  // some methods
  override def toString: String = s"$firstName $lastName is $age years old"

  override def hashCode(): Int = super.hashCode()

  def printHome(): Unit = println(s"HOME = $HOME")
  def printFullName(): Unit = println(this)

  printHome()
  printFullName()
  println(hashCode())
  println("you've reached the end of the constructor")
}
