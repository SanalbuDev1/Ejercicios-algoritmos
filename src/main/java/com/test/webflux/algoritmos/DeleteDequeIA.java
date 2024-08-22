package com.test.webflux.algoritmos;

import java.util.*;
import java.util.Scanner;

public class DeleteDequeIA {

    /**
     * Esta logica la creo la IA ya que la solucion anterior no es capas de manejar en un tiempo
     * adecuado la respuesta en hackerank 10/12 test pasados*/
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numbers = scanner.nextInt();
        int subconjuntions = scanner.nextInt();

        Deque<Integer> deque = new ArrayDeque<>();
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        int maxUnique = 0;

        for (int i = 0; i < numbers; i++) {
            System.out.println();
            int num = scanner.nextInt();

            deque.add(num);
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
            System.out.println(frequencyMap);
            if (deque.size() == subconjuntions) {
                maxUnique = frequencyMap.size()

                ;
                System.out.println("maxUnique: " + maxUnique);


                int removed = deque.poll();
                System.out.println("removed: " + removed);
                int count = frequencyMap.get(removed);
                System.out.println("count: " + count);
                if (count == 1) {
                    System.out.println("remove: " + removed);
                    frequencyMap.remove(removed);
                } else {
                    System.out.println("put: " + removed + " " + (count - 1));
                    frequencyMap.put(removed, count - 1);
                }
            }
        }

        System.out.println(maxUnique);
    }
}
