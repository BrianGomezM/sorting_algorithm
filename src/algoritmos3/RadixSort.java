
package algoritmos3;

import java.util.ArrayList;
import java.util.Arrays;


public class RadixSort {

    public static void radixSort(int[] arr) {
        int[][] bucket = new int[10][arr.length];
        int[] bucketOfElement = new int[10];
        int max = 0;
        // Encuentra el elemento más grande en la matriz
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        // Calcula el número de bits del elemento más grande
        int maxLength = (max + "").length();
        for (int m = 0, n = 1; m < maxLength; m++, n *= 10) {
            // Coloca los números en arr en los cubos correspondientes según sus unidades, decenas, centenas, etc.
            for (int i = 0; i < arr.length; i++) {
                int digit = arr[i] / n % 10;
                // Asignar el valor de arr [i] a la matriz bidimensional en el depósito
                bucket[digit][bucketOfElement[digit]] = arr[i];
                bucketOfElement[digit]++;
            }
            int index = 0;
            // Leer los elementos en el depósito y reasignarlos a arr
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < bucketOfElement[j]; k++) {
                    arr[index] = bucket[j][k];
                    index++;
                }
                bucketOfElement[j] = 0;// Borrar el número de elementos en cada uno
            }
        }
    }
    
    public static void radixSortA(int[] arr){
		radixSort(arr);
		System.out.println("\nMetodo de ordenamiento RADIX SORT\n"+Arrays.toString(arr));
	}

}
