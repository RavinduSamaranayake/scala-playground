package com.kushan_scala.generics

object GenericsPractice extends App {
  case class Student(name : String)
  case class Teacher(name : String)

  case class Institute[A](member : A)
  val institute1 = Institute[Student](Student("Kushan"))
  val institute2 = Institute[Teacher](Teacher("Ravindu"))
  val student = institute1.member
  println(student.name)
  val teacher = institute2.member
  println(teacher)
  //Declaration Syntax
  def middle[A](input: Seq[A]) : A = input(input.size./(2))
  val stuteachers = List(Student("ravindu"),Teacher("Maheshi"),Teacher("Mali"),Student("kush"),Student("jan"),Student("th"))//this is not type safe
  val midval  = middle(stuteachers)//this is not type safe
  println(s"Mid value is : $midval")
  val students = List[Student](Student("ravindu"),Student("kush"),Student("jan"),Student("th"))
  val midval2 = middle[Student](students)
  println(s"Mid value is : $midval2")

}
