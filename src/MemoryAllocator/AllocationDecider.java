package MemoryAllocator;

import java.util.ArrayList;

public interface AllocationDecider {
    Cell decideCell(ArrayList<Cell> cells, int processSize);
}