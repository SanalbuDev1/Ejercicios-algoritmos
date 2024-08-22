package com.test.webflux.algoritmos;

import java.util.*;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

public class ComparatorPlayers {



    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Leer el número de jugadores
        int n = scanner.nextInt();
        scanner.nextLine(); // Consumir la línea restante

        // Crear una lista para almacenar los jugadores
        List<Player> listaJugadores = new ArrayList<>();

        // Leer los jugadores
        for (int i = 0; i < n; i++) {
            String nombre = scanner.next();
            int puntaje = scanner.nextInt();
            listaJugadores.add(new Player(nombre, puntaje));
        }

        listaJugadores.sort(Comparator.comparing(Player::getScore).reversed().thenComparing(Player::getName));

        listaJugadores.forEach(player ->
                System.out.printf("%s %s\n", player.getName(), player.getScore()));
    }
}

class Player {
    private String name;
    private int score;

    Player(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
}





