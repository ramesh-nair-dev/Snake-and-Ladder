package models;

public class Snake extends Obstacle{
    public Snake (int start, int end) {
        super(start, end, ObstacleType.SNAKE);
    }
}
