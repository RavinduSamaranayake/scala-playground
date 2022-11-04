package com.kushan_scala.monads

object UsageExample1 {
  //census

  case class Person(firstName : String,lastName : String){
    assert(firstName!=null && lastName!=null)
  }

  //traditional java approach
  def getPerson(firstName : String,lastName : String) : Person = {
    if (firstName != null){
      if(lastName != null) {
        Person(firstName, lastName)
      }else {
        null
      }
    }else{
      null
    }
  }

  //using Optional
  def getPersonBetter(firstName : String,lastName : String) : Option[Person] = {
    Option(firstName).flatMap(
      fname => Option(lastName).flatMap(
        lname => Option(Person(fname,lname))
      )
    )
  }

  //using for comprehensive
  def getPersonFor(firstName : String,lastName : String) : Option[Person] = for {
    fname <- Option(firstName)
    lname <- Option(lastName)
  } yield Person(fname,lname)
}
