package com.test.webflux.algoritmos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class ValidarEstructura {

    /*Validar estructura*/

    public static void main(String args[]){
        String validarEstructura = "((({{})))[][({})";
        Stack<Character> pila = new Stack<>();

        for(int i=0; i < validarEstructura.length(); i++){
            Character temp = validarEstructura.charAt(i);


            if(temp == '(' | temp == '{' | temp == '['){
                pila.push(temp);
            }else{
                Character temporal = pila.get(pila.size() - 1);
                if(temp == ')'){
                    if( pila.isEmpty() || pila.pop() != '('){
                        System.out.println("No coincide el cierre  ) -> " + temporal);
                        return;
                    }
                } else if (temp == '}') {
                    if( pila.isEmpty() || pila.pop() != '{'){
                        System.out.println("No coincide el cierre  } -> " + temporal);
                        return;
                    }
                } else {
                    if( pila.isEmpty() || pila.pop() != '['){
                        System.out.println("No coincide el cierre  ] -> " + temporal);
                        return;
                    }
                }

            }



        }

        if(!(pila.isEmpty())){
            System.out.println("No termino de cerrar bien el formato");
            return;
        }



    }

}
