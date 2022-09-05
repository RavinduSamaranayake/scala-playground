package com.kushan_scala.scala_doc.scala_classes

/**
 * @author Ravindu
 *         9/5/2022
 */
object testClasses extends App {
  val person = new Person("Kushan","Ravindu")
  //val firstName = person.firstName can't access due to private modifier
  val firstName = person.getFirstName
  val lastName = person.getLastName
  println(s"Full name is : $firstName $lastName")
  person.setFirstName("Hasith")
  person.setLastName("Amarathunge")
  println(s"Full name after setter updates : ${person.getFirstName} ${person.getLastName}")

  val person_add = new Person_Add("Tharika","Samaranayake")

  //other class examples

  class Pizza (var crustSize: Int, var crustType: String)

  // a stock, like AAPL or GOOG
  class Stock(var symbol: String, var price: BigDecimal)

  // a network socket
  class Socket(val timeout: Int, val linger: Int) {
    override def toString = s"timeout: $timeout, linger: $linger"
  }

  class Address (
                  var street1: String,
                  var street2: String,
                  var city: String,
                  var state: String
                )
}
