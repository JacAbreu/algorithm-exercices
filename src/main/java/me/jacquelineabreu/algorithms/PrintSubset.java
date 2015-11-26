package me.jacquelineabreu.algorithms;

public class PrintSubset implements PrintSet {

    public void printSubset(Iterable<Integer> subset){
        System.out.print("( ");
        for (Integer i : subset) {
            System.out.print(i + " ");
        }
        System.out.println(")");
    }
}
