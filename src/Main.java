import MemoryAllocator.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Please enter file name");
            return;
        }
        try {
            String[] outputs = new Main().readFromFile(args[0], new FirstFitDecider(), new BestFitDecider(), new WorstFitDecider());
            FileWriter fileWriter = new FileWriter("output.txt");
            fileWriter.write("Best-Fit Memory Allocation\n");
            fileWriter.append("-----------------------------------------------------------------------------------------------\n");
            fileWriter.append(outputs[0]);

            fileWriter.write("\n\nBest-Fit Memory Allocation\n");
            fileWriter.append("-----------------------------------------------------------------------------------------------\n");
            fileWriter.append(outputs[1]);

            fileWriter.write("\n\nBest-Fit Memory Allocation\n");
            fileWriter.append("-----------------------------------------------------------------------------------------------\n");
            fileWriter.append(outputs[2]);
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }

    String[] readFromFile(String fileName, AllocationDecider... deciders) throws IOException {
        ArrayList<Allocator> allocators = new ArrayList<>();
        for (AllocationDecider decider : deciders)
            allocators.add(new Allocator(decider));
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        for (String cellSize : br.readLine().split(","))
            allocators.forEach(allocator -> allocator.addCell(Integer.parseInt(cellSize)));
        StringBuilder[] outputs = new StringBuilder[allocators.size()];
        for (int i = 0; i < allocators.size(); i++) {
            outputs[i] = new StringBuilder();
            outputs[i].append("start => ").append(allocators.get(i)).append("\n");
        }
        for (String processSize : br.readLine().split(","))
            for (int i = 0; i < allocators.size(); i++) {
                outputs[i].append(processSize).append(" => ");
                try {
                    allocators.get(i).addProcess(Integer.parseInt(processSize));
                    outputs[i].append(allocators.get(i));
                } catch (Exception e) {
                    outputs[i].append("not allocated, must wait");
                }
                outputs[i].append("\n");
            }
        String[] o = new String[outputs.length];
        for (int i = 0; i < outputs.length; i++)
            o[i] = outputs[i].toString();
        return o;
    }
}