package com.test.webflux.algoritmos;

import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;

public class QueuePriorityJ {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Leer el número de estudiantes
        int n = scanner.nextInt();
        scanner.nextLine(); // Consumir la línea restante

        // Crear una lista para almacenar los jugadores
        List<String> listaEventos = new ArrayList<>();

        // añadir los eventos
        for (int i = 0; i < n; i++) {
            String evento = scanner.nextLine();
            listaEventos.add(evento);
        }

        // crear lista de estudiantes
        List<Student> students = Priority.getStudents(listaEventos);

        //leer los estudiantes
        if(students.isEmpty()){
            System.out.println("EMPTY");
            return;
        }

        students.forEach(student -> {
           System.out.println(student.getName() + "->" + student.getCgpa() + "->" + student.getId());
        });
    }

}

class Student {

    private int id;
    private String name;
    private double cgpa;

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }
}

class Priority{

    static List<Student> getStudents(List<String> events) {
        PriorityQueue<Student> temporal = new PriorityQueue<>(
                Comparator.comparing(Student::getCgpa).reversed()  // Primero por puntaje descendente
                        .thenComparing(Student::getName)         // Luego por nombre ascendente
                        .thenComparing(Student::getId)           // Finalmente por ID ascendente
        );

        events.forEach(event -> {
            String[] eventArray = event.split(" ");
            if (eventArray[0].equals("ENTER")) {
                Student student = new Student(Integer.parseInt(eventArray[3]), eventArray[1], Double.parseDouble(eventArray[2]));
                temporal.add(student);
            } else {
                // Aquí puedes definir qué quieres hacer cuando no es "ENTER"
                if (!temporal.isEmpty()) {
                    temporal.poll();
                }
            }
           // System.out.println(event);
        });

        if(temporal.isEmpty()){
            return new ArrayList<>();
        }
        // Convertir a lista y ordenar explícitamente
        return temporal.stream()
                .sorted(Comparator.comparing(Student::getCgpa).reversed()
                        .thenComparing(Student::getName)
                        .thenComparing(Student::getId))
                .collect(Collectors.toList());
    }

}