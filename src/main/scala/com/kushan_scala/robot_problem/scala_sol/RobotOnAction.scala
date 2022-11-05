package com.kushan_scala.robot_problem.scala_sol

/**
 * @author Ravindu
 *         10/31/2022
 */
object RobotOnAction {

    def getDirectionOn90Degree(initDir: Char, action: Char): Char = initDir match {
      case 'N' if action == 'L' => 'W'
      case 'N' if action == 'R' => 'E'
      case 'W' if action == 'L' => 'S'
      case 'W' if action == 'R' => 'N'
      case 'S' if action == 'L' => 'E'
      case 'S' if action == 'R' => 'W'
      case 'E' if action == 'L' => 'N'
      case 'E' if action == 'R' => 'S'
      case _ => initDir
    }

  def canBeMoveRobot(currentX: Int, currentY: Int, direction: Char, maxWidth: Int, maxHigh: Int): Boolean = {
    if (currentX == maxWidth - 1 && direction == 'E') return false
    else if (currentY == maxHigh - 1 && direction == 'N') return false
    if (currentX == 0 && direction == 'W') false
    else currentY != 0 || direction != 'S'
  }

  def updateLocationOnMove(robot: Robot): Robot = {
    val initDir = robot.getDirection()
    if (initDir == 'N') robot.setY(robot.getY().+(1))
    else if (initDir == 'E') robot.setX(robot.getX().+(1))
    else if (initDir == 'S') robot.setY(robot.getY().-(1))
    else robot.setX(robot.getX().-(1))
    robot
  }

  def getActionOnInput(robot: Robot, inputAction: Char, maxWidth: Int, maxHigh: Int): Robot = {
    if (inputAction == 'L' || inputAction == 'R')
      robot.setDirection(getDirectionOn90Degree(robot.getDirection(), inputAction))
    else if (canBeMoveRobot(robot.getX(), robot.getY(), robot.getDirection(), maxWidth, maxHigh))
      updateLocationOnMove(robot)
    robot
  }

  def setInputValues(inputArray: Array[Char], robot: Robot, maxWidth: Int, maxHigh: Int): Unit = {
    val initRobot : Robot = new Robot(robot.getX(),robot.getY(),robot.getDirection())//to keep for printing initial state in print method
    var updatedRobot: Robot = robot
    for (input <- inputArray) {
      updatedRobot = getActionOnInput(robot, input, maxWidth, maxHigh)
    }
    println(s"Final State Of Robot : ${initRobot.toString} is => ${updatedRobot.toString}")
  }

  def main(args: Array[String]): Unit = {
    setInputValues(Array('L', 'M', 'L', 'M', 'L', 'M', 'L', 'M', 'M'), new Robot(1, 2, 'N'), 6, 6)
    setInputValues(Array('M', 'L', 'M'), new Robot(3, 5, 'N'), 6, 6)
  }
}
