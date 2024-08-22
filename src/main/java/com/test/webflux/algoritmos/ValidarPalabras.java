package com.test.webflux.algoritmos;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class ValidarPalabras {

    public static void main(String[] args) {
        String palabra1 = "PAOLABRA1";
        String palabra2 ="PAALABRO1";

        if(palabra1.length() != palabra2.length()){
            System.out.println("no tienen la misma longitud");
            return;
        }else{

            for(int i=0; i<palabra1.length();i++){
                if(palabra1.charAt(i) != palabra2.charAt(i)){
                    System.out.println("No son iguales " + palabra1.charAt(i) +"-"+ palabra2.charAt(i));
                    return;
                }
            }

        }
    }

}
