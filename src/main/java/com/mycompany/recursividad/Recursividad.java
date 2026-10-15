/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.recursividad;

/**
 *
 * @author victo
 */
public class Recursividad {
    
    // Este método es el que voy a llamar desde el main
    // Recibe la frase completa y la limpia
    public static boolean esPalindromo(String frase) {
        // 1. Paso todo a minusculas para que 'A' y 'a' sean lo mismo
        // 2. Quito todo lo que no sea letra o numero. Los espacios, comas, etc
        //    Ej: "Anita lava la tina" -> "anitalavalatina"
        String limpio = frase.toLowerCase().replaceAll("[^a-z0-9]", "");
        
        // Llamo al metodo recursivo real.
        // Empiezo con izq = 0 y der = ultima posicion
        return esPalindromoRec(limpio, 0, limpio.length() - 1);
    }

    // Este es el metodo recursivo. Es el que se va a llamar a si mismo
    // izq = indice de la izquierda, der = indice de la derecha
    private static boolean esPalindromoRec(String s, int izq, int der) {
        
        // CASO BASE 1
        // Significa que ya revise toda la palabra y todo coincidio
        // Ej: en "ana", cuando izq=1 y der=1
        if (izq >= der) {
            return true; // Si llegue aqui, es palindromo
        }

        // CASO BASE 2: Si la letra de la izq es diferente a la de la der
        // Aqui ya valio, no es palindromo y paro todo
        // Ej: "casa" -> c != a
        if (s.charAt(izq) != s.charAt(der)) {
            return false;
        }

        // PASO RECURSIVO: Si las letras de las orillas si son iguales
        // Entonces me muevo 1 a la derecha y 1 a la izquierda
        // Y vuelvo a revisar la palabra "de adentro"
        // Ej: "radar" -> r==r, ahora reviso "ada"
        return esPalindromoRec(s, izq + 1, der - 1);
    }

    public static void main(String[] args) {
        String palabra1 = "Radar";
        String palabra2 = "Casa";
        String frase = "Anita lava la tina";

        // Pruebo mi metodo con 3 ejemplos
        System.out.println(palabra1 + " -> " + esPalindromo(palabra1)); // Deberia dar true
        System.out.println(palabra2 + " -> " + esPalindromo(palabra2)); // Deberia dar false
        System.out.println(frase + " -> " + esPalindromo(frase)); // Deberia dar true
    }
}