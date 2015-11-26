package me.jacquelineabreu.algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {
        int goal = 6;
        ArrayList<Integer> source = new ArrayList<Integer>();
        source.addAll(Arrays.asList(1, 2, 3, 4, 6));
        PrintSet printer = new PrintSubset();
        new SubsetSum(printer).subsetSum(goal, source);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;

        presentation(reader);
        SubsetSum subsetSum = new SubsetSum(printer);
        while ((line = readInput(reader)) != null) {
            try {
                String[] elements = line.split("-");
                presentationSum(reader, elements[0].trim());
                subsetSum.subsetSum(new Integer(elements[0].trim()),castStringToInteger(elements[1]));
            } catch (Exception e) {
                System.out.println("O formato da entrada deve ser somatório-conjunto (os elementos do conjunto devem ser separados por vírgulas)\nVerifique se os dados necessários foram inseridos da forma correta");
                e.printStackTrace();

            }
        }
    }

    private static void presentation(BufferedReader reader) throws IOException {
        System.out.println("Olá\nInsira o somatório-conjunto (os elementos do conjunto devem ser separados por vírgulas) ");
    }

    private static void presentationSum(BufferedReader reader, String sum) throws IOException {
        System.out.println("O somatório a ser obtido é " + sum);
    }

    private static String readInput(BufferedReader reader) throws IOException {
        System.out.print("> ");
        return reader.readLine();
    }

    private  static List<Integer> castStringToInteger(String source){
        List<Integer> set = new ArrayList<Integer>();

        String[] sourceSanitized = source.split(",");

        for (String i : sourceSanitized) {
            set.add(new Integer(i.trim()));
        }

        return set;
    }

}

