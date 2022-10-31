package com.kushan_scala.scala_doc.compariosn_with_java.mixins
//Java has no mixins
trait GreetingService {
  def translate(text: String): String

  def sayHello: String = translate("Hello")
}

trait TranslationService {
  def translate(text: String): String = s">>>>$text"
}

trait PrintingService{
  def printText(text: String) : String
}
class MixinsOnlyInScala extends GreetingService with PrintingService  with TranslationService{
  override def printText(text: String): String = translate(text)

  //override def translate(text: String): String = s"???$text"
}


object runner extends App {
  val mixinsOnlyInScala = new MixinsOnlyInScala()
  println(s"Scala2 output is : ${mixinsOnlyInScala.printText("Kushan....")}")
  println(s"Scala2 output is : ${mixinsOnlyInScala.sayHello}")
  }
