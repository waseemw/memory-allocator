package MemoryAllocator;

import java.util.ArrayList;

public class FirstFitDecider implements AllocationDecider {
    @Override
    public Cell decideCell(ArrayList<Cell> cells, int processSize) {
        for (Cell cell : cells)
            if (cell.getMemoryLeft() >= processSize)
                return cell;
        return null;
    }
}