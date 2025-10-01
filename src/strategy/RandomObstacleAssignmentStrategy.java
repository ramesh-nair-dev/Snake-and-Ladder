package strategy;

import models.Board;
import models.Cell;
import models.Ladder;
import models.Snake;

import java.util.List;
import java.util.Random;

public class RandomObstacleAssignmentStrategy implements ObstacleAssignmentStrategy{
    private Random random = new Random();
    @Override
    public void assignObstacles(Board board, int snakesCount, int laddersCount) {
        int size = board.getSize();
        List<Cell> grid = board.getGrid();
        int totalCells = size * size;
        int assignedSnakes = 0;
        int assignedLadders = 0;
        while (assignedSnakes < snakesCount) {
            int head = random.nextInt(totalCells - 1) + 2; // [2..N]
            int tail = random.nextInt(head - 1) + 1;       // [1..head-1]

            if (head == totalCells) continue; // last cell can't have snake head

            Cell headCell = grid.get(head - 1);
            if (headCell.getObstacle() == null) {
                headCell.setObstacle(new Snake(head, tail));
                assignedSnakes++;
            }
        }

        while (assignedLadders < laddersCount) {
            int start = random.nextInt(totalCells - 2) + 2; // [2..N-1]
            int end = random.nextInt(totalCells - start) + start + 1; // (start..N]

            if (end == totalCells) continue; // no ladder to final cell

            Cell startCell = grid.get(start - 1);
            if (startCell.getObstacle() == null) {
                startCell.setObstacle(new Ladder(start, end));
                assignedLadders++;
            }
        }
    }
}
