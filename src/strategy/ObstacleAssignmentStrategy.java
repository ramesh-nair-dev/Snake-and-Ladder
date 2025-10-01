package strategy;

import models.Board;

public interface ObstacleAssignmentStrategy {
    void assignObstacles(Board board , int snakesCount , int laddersCount);
}
