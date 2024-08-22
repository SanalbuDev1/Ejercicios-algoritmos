package com.test.webflux.algoritmos;

import java.util.*;

public class DeleteDeque {

    public static void main(String[] args) {

        /* TO STDIN
        *   6 3
            5 3 5 2 3 2
        * */

        Scanner scanner = new Scanner(System.in);

        // Leer numero enteros y subconjunto
        Integer numbers = scanner.nextInt();
        Integer subconjuntions = scanner.nextInt();

        System.out.println(numbers);
        System.out.println(subconjuntions);

        scanner.nextLine(); // Consumir la línea restante

        // build deque
        Deque<Integer> d = new ArrayDeque<>();

        // read the numbers
        for (int i = 0; i < numbers; i++) {
            Integer number = scanner.nextInt();
            //System.out.println(number);
            d.addLast(number);
        }

        Set<Integer> subconjuntsSet = new HashSet<>();
        List<Integer> uniqueNumbers = new ArrayList<>();

        uniqueNumbers = deleteDeque(d, subconjuntions);

        System.out.println("numeros unicos");
        for (Integer valor: uniqueNumbers){
            System.out.println(valor);
        }

        System.out.println(uniqueNumbers
                .stream()
                .max(Integer::compareTo)
                .get());
    }

    public static List<Integer> deleteDeque(Deque<Integer> d, Integer subconjuntions){
        Set<Integer> subconjuntsSet = new HashSet<>();
        List<Integer> uniqueNumbers = new ArrayList<>();

        while (d.size() >= subconjuntions){
            // initializate the subconjunts
            subconjuntsSet = new HashSet<>();

            System.out.println(d + " " +subconjuntions);
            int contador = 0;
            for (Integer valor: d){
                if(subconjuntions > contador++) {
                    subconjuntsSet.add(valor);
                }
            }

            uniqueNumbers.add(subconjuntsSet.size());

            d.pop();
            System.out.println();
            System.out.println(d);
        }

        return uniqueNumbers;
    }



}
