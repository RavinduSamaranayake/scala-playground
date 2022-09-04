package com.kushan_scala

/**
 * @author Ravindu
 *         9/5/2022
 */
object Basics extends App {
  //defining const value
  val firstInt: Int = 25 // same as java -> final int firstInt = 25;
  println(firstInt)
  // firstInt = 34 can't reassigning

  //short way
  val secondInt = 28 //Compiler Identified as a Integer
  println(secondInt)

  //defining variable
  var thirdInt = 70 //same as java -> int thirdInt = 70;
  thirdInt = 90; //**********************don't use variables in scala it's no a good practice in scala use val instead
  thirdInt = thirdInt - 32
  println(thirdInt)

  //boolean,char,String,...
  val boolVal = false
  val charVal = 'C'
  val stringVal = "hello"
  var  stringVal2 = "testImmutability"
  stringVal2 = "testedImmutable"
  println("Bool Value is : "+boolVal,"Char Value is : "+charVal,"String value is : "+stringVal2)

  //if expression
  val output = if(secondInt > 40) 33 else 89
  printf("Output is :%d ",output)
  println()

  val secondOutput = if(secondInt > 40) 78 else if(firstInt > 33) 99 else if(thirdInt < 56) 88
            else if(boolVal) "Hii" else if(stringVal.equals("Hii")) "Hello" else true

  println("final output is : "+secondOutput)

  // code blocks
  val codeBlock = {
    val count = 32
    count + 30
  }
  println("Code block value is : "+codeBlock)

  // functions
  def myFunction(x: Int, y: String): String = {
    "Value x is :" + x + " and Y is :" + y
  }
  println(myFunction(10,"kushan"))

  def myFunction2(x: Int, y: String): Unit = { // Unit is same as Java void. scala returns Unit instead java void
    println("Value x is :" + x + " and Y is :" + y)
  }
  myFunction2(20,"kushan2")

  //recursive
  def factorial(n :Int) : Int = { //**********************don't use loops or iterators in scala it's no a good practice in scala use recursive instead
    if(n <= 1 ) 1
    else n*factorial(n-1)
  }

  println("Factorial value is : "+ factorial(5))


}
