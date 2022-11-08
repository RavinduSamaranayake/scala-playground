package com.kushan_scala.exception

object Exception {
  /* exceptions
   scala as you know is based on JVM. all the scala codes that we write actually compiled to JVM byte code that can be then run on every single device
   that has a JVM installed like an Android phone or a computer or anything else that can run java can also run Scala. the JVM also has this notion of exceptions
   which means that if one of these objects is *thrown , the JVM will interrupt its normal code flow execution and exceptions are special objects treated by the JVM
   with  these try-catch expressions
   */
  try {
    // code that can throw
    val x: String = null
    x.length
  } catch {
    case e: Exception => "Some faulty error message"
  } finally {
    // execute some code no matter what
  }
}
