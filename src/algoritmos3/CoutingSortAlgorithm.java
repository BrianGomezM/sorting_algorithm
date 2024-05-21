/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmos3;

import java.util.Arrays;

/**
 *
 * @author braya
 */
public class CoutingSortAlgorithm {

    public static int findMax(int[] elements) {
         // Encuentra el elemento más grande de la matriz 
        int max = elements[0];
        for (int i = 1; i < elements.length; i++) {
            if (elements[i] > max) {
                max = elements[i];
            }
        }
        return max;
    }

    public static void CoutingSort(int[] elements) {
        int maxValue = findMax(elements);
        int[] counts = new int[maxValue + 1];
        // Fase 1: Recuento 
        for (int i = 0; i < elements.length; i++) {
            counts[elements[i]]++;
        }
        // Fase 2: Agregado 
        for (int i = 1; i <= maxValue; i++) {
            counts[i] += counts[i - 1];
        }
        // Fase 3: Escribir en la matriz de destino 
        int[] target = new int[elements.length];
        for (int i = elements.length - 1; i >= 0; i--) {
            int element = elements[i];
            target[--counts[element]] = element;
        }
         // Copiar el destino de nuevo a la matriz de entrada 
        System.arraycopy(target, 0, elements, 0, elements.length);

        // Imprime la matriz 
        printArray(elements);
    }

    public static void printArray(int[] elements) {
       // Imprime la matriz ordenada 
        System.out.println( "\nMetodo de ordenamiento COUTING SORT: \n"+Arrays.toString(elements));
    }
    
     
}

