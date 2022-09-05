package com.kushan_scala.scala_doc.scala_classes

/**
 * @author Ravindu
 *         9/5/2022
 */
class Person(private var firstName : String,var lastName : String) {
  def getFirstName: String = firstName

  def getLastName: String = lastName

  def setFirstName(firstName : String) : Unit = {
    this.firstName = firstName
  }
  def setLastName(lastName : String) : Unit = {
    this.lastName = lastName
  }
}
