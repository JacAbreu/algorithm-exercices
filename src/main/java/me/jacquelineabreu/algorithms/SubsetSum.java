package me.jacquelineabreu.algorithms;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;


public class SubsetSum {
    private final Deque<Integer> subset = new ArrayDeque<>();
    private final PrintSubset printer;

    public SubsetSum(PrintSubset printer) {
        this.printer = printer;
    }

    public void subsetSum(int goal, List<Integer> source) {
        subsetSum(goal, 0, source);
    }

    private void subsetSum(int goal, int i, List<Integer> source) {

        if (goal < 0) {
            return;
        }
        if (goal == 0 && subset.size() > 0) {
            printer.printSubset(new ArrayList<Integer>(subset));
        } else if (source.size() != i) {
            int chosen = source.get(i);
            subsetSum(goal, i + 1, source);
            subset.addLast(chosen);
            subsetSum(goal - chosen, i + 1, source);
            subset.pollLast();
        }
    }
}
