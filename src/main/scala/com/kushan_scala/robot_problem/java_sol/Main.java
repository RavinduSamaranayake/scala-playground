package com.kushan_scala.robot_problem.java_sol;

/**
 * @author ${USER}
 * ${DATE}
 */
public class Main {

    public static RobotEntity getActionOnInput(RobotEntity entity, char ch, int maxFloorWidth, int maxFloorHigh){
        if(ch == 'L' || ch == 'R'){
            entity.setDirection(getDirectionOn90degree(entity.getDirection(), ch));
        } else {
            if(canBeMoveRobot(entity.getX(), entity.getY(), entity.getDirection(),maxFloorWidth,maxFloorHigh)){
                updateLocationOnMove(entity);
            }
        }
        return entity;
    }

    public static char getDirectionOn90degree(char initDir,char action){
        if(initDir == 'N'){
            if(action == 'L')
                return 'W';
            else if(action == 'R')
                return 'E';
            return 'N';
        }else if(initDir == 'W'){
            if(action == 'L')
                return 'S';
            else if(action == 'R')
                return 'N';
            return 'W';
        }else if(initDir == 'S'){
            if(action == 'L')
                return 'E';
            else if(action == 'R')
                return 'W';
            return 'S';
        }else if(initDir == 'E'){
            if(action == 'L')
                return 'N';
            else if(action == 'R')
                return 'S';
            return 'E';
        }
        throw new RuntimeException("Invalid Direction Input");
    }

    public static boolean canBeMoveRobot(int currentX,int currentY,char direction,int maxFloorWidth,int maxFloorHigh){
        if(currentX==maxFloorWidth-1 && direction == 'E'){
            return false;
        } else if (currentY ==maxFloorHigh-1 && direction == 'N') {
            return false;
        }  if(currentX==0 && direction == 'W'){
            return false;
        } else return currentY != 0 || direction != 'S';
    }


    public static RobotEntity updateLocationOnMove(RobotEntity currentEntity) {
        char initDir = currentEntity.getDirection();
        if (initDir == 'N') {
            currentEntity.setY(currentEntity.getY()+1);
        } else if (initDir == 'E') {
            currentEntity.setX(currentEntity.getX()+1);
        } else if (initDir == 'S') {
            currentEntity.setY(currentEntity.getY()-1);
        } else {
            currentEntity.setX(currentEntity.getX()-1);
        }
        return currentEntity;
    }

    public static void main(String[] args) {
        System.out.println("Test Example 1-------------------");

        RobotEntity robotEntity1 = new RobotEntity(1,2,'N');

        char [] inputArray1 = {'L', 'M', 'L', 'M', 'L', 'M', 'L', 'M', 'M'};
        RobotEntity updatedEntity = new RobotEntity(0,0,'N');
        for(char ch : inputArray1){
            updatedEntity = getActionOnInput(robotEntity1,ch,6,6);
        }
        System.out.println(updatedEntity.toString());

        System.out.println("Test Example 2-------------------");

        RobotEntity robotEntity2 = new RobotEntity(3,5,'N');

        char [] inputArray2 = {'M', 'L', 'M'};
        RobotEntity updatedEntity2 = new RobotEntity(0,0,'N');
        for(char ch : inputArray2){
            updatedEntity2 = getActionOnInput(robotEntity2,ch,6,6);
        }
        System.out.println(updatedEntity2.toString());
    }
}