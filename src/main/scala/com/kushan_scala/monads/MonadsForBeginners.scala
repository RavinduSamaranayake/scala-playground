package com.kushan_scala.monads

object MonadsForBeginners extends App {
  case class SafeValue[+T](private val internalValue : T){ //in oop this is "Constructor" = in functional this is "Pure or Unit"
    def get : T = synchronized( //we synchronized due to multithreading effect
      //does something interesting
      internalValue
    )

    def transform[S](transformer: T => SafeValue[S]): SafeValue[S] = synchronized( //bind or flatMap
      transformer(internalValue) // apply the internal value here
    )
  }

  //example : external API
  def gimmeSafeValue[T](value: T): SafeValue[T] = SafeValue(value)

  /*  ETW Pattern (Extract->Transform->Wrap) */

  val safeString: SafeValue[String] = gimmeSafeValue("Hello Kushan..")
  //extract
  val stringValue: String = safeString.get
  //transform
  val upperString: String = stringValue.toUpperCase()
  //wrap
  val upperSafeValue: SafeValue[String] = SafeValue(upperString)
  println("ETW : "+upperSafeValue)

 /* so now let's do this ETW pattern using implementing transform (bind or flatMap) method on above case class*/

  //ETW pattern compressed to the one line
  val upperSafeValue2 : SafeValue[String] = safeString.transform(str => SafeValue(str.toUpperCase())) // same to flatMap
  println("CompressedETW : "+upperSafeValue2)

}
