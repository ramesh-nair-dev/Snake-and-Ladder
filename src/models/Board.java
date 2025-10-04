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
        this.obstacleAssignmentStrategy.assignObstacles(this ,  10 , 10);
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

    public void display() {
        int size = dimension * dimension;
        int cellWidth = String.valueOf(size).length() + 6; // width = digits + extra space for obstacles/players

        for (int i = 0; i < dimension; i++) {
            if (i % 2 == 0) {
                // Right → Left row
                int start = size;
                for (int j = start; j > start - dimension; j--) {
                    Cell cell = this.grid.get(j - 1);

                    StringBuilder sb = new StringBuilder();
                    sb.append(cell.getNumber());

                    if (cell.getObstacle() != null) {
                        if (cell.getObstacle().getType().equals(ObstacleType.SNAKE)) {
                            sb.append("🐍");
                        } else {
                            sb.append("🪜");
                        }
                    }

                    if (!cell.getPlayers().isEmpty()) {
                        sb.append("<");
                        for (Player player : cell.getPlayers()) {
                            sb.append(player.getSymbol().getSymbol());
                        }
                        sb.append(">");
                    }

                    System.out.print(String.format("[%-" + cellWidth + "s]", sb.toString()));
                }
                size -= dimension;
            } else {
                // Left → Right row
                int start = size - dimension + 1;
                for (int j = start; j <= size; j++) {
                    Cell cell = this.grid.get(j - 1);

                    StringBuilder sb = new StringBuilder();
                    sb.append(cell.getNumber());

                    if (cell.getObstacle() != null) {
                        if (cell.getObstacle().getType().equals(ObstacleType.SNAKE)) {
                            sb.append("🐍");
                        } else {
                            sb.append("🪜");
                        }
                    }

                    if (!cell.getPlayers().isEmpty()) {
                        sb.append("<");
                        for (Player player : cell.getPlayers()) {
                            sb.append(player.getSymbol().getSymbol());
                        }
                        sb.append(">");
                    }

                    System.out.print(String.format("[%-" + cellWidth + "s]", sb.toString()));
                }
                size -= dimension;
            }
            System.out.println();
        }
    }


}
