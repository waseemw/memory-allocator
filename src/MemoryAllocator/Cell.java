package MemoryAllocator;

import java.util.ArrayList;

class Cell {
    private int memoryLeft;
    ArrayList<Integer> processes = new ArrayList<>();

    Cell(int memoryLeft) {
        this.memoryLeft = memoryLeft;
    }

    public void addProcess(int size) {
        if (size > memoryLeft)
            throw new RuntimeException("Can't insert a process with size larger than the cell's available memory");
        memoryLeft -= size;
        processes.add(size);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int process : processes)
            s.append(process).append("* ");
        if (memoryLeft != 0)
            s.append(memoryLeft);
        else
            s.delete(s.length() - 1, s.length());
        return s.toString();
    }


    public int getMemoryLeft() {
        return memoryLeft;
    }

}