package com.kushan_scala.robot_problem.java_sol;

/**
 * @author Ravindu
 * 10/20/2022
 */
public class RobotEntity {
    int x;
    int y;

    char direction;

    public RobotEntity(int x, int y, char ch) {
        this.direction = ch;
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public char getDirection() {
        return direction;
    }

    public void setDirection(char direction) {
        this.direction = direction;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "RobotEntity{" +
                "x=" + x +
                ", y=" + y +
                ", direction=" + direction +
                '}';
    }
}
