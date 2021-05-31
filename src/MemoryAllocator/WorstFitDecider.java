package MemoryAllocator;

import java.util.ArrayList;

public class WorstFitDecider implements AllocationDecider {
    @Override
    public Cell decideCell(ArrayList<Cell> cells, int processSize) {
        Cell worstCell = null;
        for (Cell cell : cells)
            if (cell.getMemoryLeft() >= processSize && difference(cell, processSize) > difference(worstCell, processSize))
                worstCell = cell;
        return worstCell;
    }

    private int difference(Cell cell, int size) {
        if (cell == null)
            return -1;
        return Math.abs(cell.getMemoryLeft() - size);
    }
}