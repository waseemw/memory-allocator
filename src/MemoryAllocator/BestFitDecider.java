package MemoryAllocator;

import java.util.ArrayList;

public class BestFitDecider implements AllocationDecider {
    @Override
    public Cell decideCell(ArrayList<Cell> cells, int processSize) {
        Cell bestCell = null;
        for (Cell cell : cells)
            if (cell.getMemoryLeft() >= processSize && difference(cell, processSize) < difference(bestCell, processSize))
                bestCell = cell;
        return bestCell;
    }

    private int difference(Cell cell, int size) {
        if (cell == null)
            return Integer.MAX_VALUE;
        return Math.abs(cell.getMemoryLeft() - size);
    }
}