package MemoryAllocator;

import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;

public class Allocator {
    private final AllocationDecider allocationDecider;
    ArrayList<Cell> cells = new ArrayList<>();

    public Allocator(AllocationDecider allocationDecider) {
        this.allocationDecider = allocationDecider;
    }

    public void addCell(int size) {
        cells.add(new Cell(size));
    }

    public void addProcess(int size) {
        Cell cell = allocationDecider.decideCell(cells, size);
        if (cell == null)
            throw new RuntimeException("No cell found with the used allocation decider!");
        cell.addProcess(size);
    }

    @Override
    public String toString() {
        return cells.stream().map(Objects::toString).collect(Collectors.joining(" "));
    }
}