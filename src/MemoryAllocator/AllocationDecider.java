package MemoryAllocator;

import java.util.ArrayList;

public interface AllocationDecider {
    public Cell decideCell(ArrayList<Cell> cells, int processSize);
}