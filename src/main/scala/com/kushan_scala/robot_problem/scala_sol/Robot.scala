package com.kushan_scala.robot_problem.scala_sol

/**
 * @author Ravindu
 *         10/31/2022
 */
class Robot(private var x:Int,private var y:Int,private var direction:Char) {
  def setX(xVal:Int) : Unit =
    this.x = xVal

  def setY(yVal:Int) : Unit =
    this.y = yVal

  def setDirection(dir:Char): Unit =
    this.direction = dir

  def getX() : Int = x
  def getY() : Int = y
  def getDirection() : Char = direction

  override def toString: String = s"[$x ,$y ,$direction]"
}
