package models;

import strategy.ObstacleAssignmentStrategy;
import strategy.RandomObstacleAssignmentStrategy;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int dimension;
    private List<Cell> grid;
    private ObstacleAssignmentStrategy obstacleAssignmentStrategy;



    public Board(int size) {
        this.dimension = size;
        this.grid = new ArrayList<>();
        for(int i=1 ; i<= dimension*dimension ; i++){
            Cell cell = new Cell();
            cell.setNumber(i);
            grid.add(cell);
        }
        this.obstacleAssignmentStrategy = new RandomObstacleAssignmentStrategy();
        this.obstacleAssignmentStrategy.assignObstacles(this ,  (dimension*dimension)/10 , (dimension*dimension)/10);
    }

    public int getSize() {
        return dimension;
    }

    public List<Cell> getGrid() {
        return grid;
    }

    public void setGrid(List<Cell> grid) {
        this.grid = grid;
    }
    public void display(){
    }
}
