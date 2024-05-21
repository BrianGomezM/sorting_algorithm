package algoritmos3;

import static algoritmos3.AlgoritmiBucketSort.BucketSort;
import static algoritmos3.CoutingSortAlgorithm.CoutingSort;
import static algoritmos3.RadixSort.radixSortA;
import java.util.Random;
import java.util.Vector;

public class Algoritmos3 {

    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {

        Random r = new Random();
        Vector<Integer> lista1 = new Vector<Integer>();
        for (int i = 0; i < 100; i++) {
            lista1.addElement(r.nextInt(100));
        }
        int[] lista2 = lista1.stream().mapToInt(i -> i).toArray();

        System.out.print("Lista de numeros para ordenar:\n");
        for (int i = 0; i < lista1.size(); i++) {
            System.out.print(lista1.elementAt(i) + " - ");
        }
        
        long TInicio, TFin, tiempo; //Variables para determinar el tiempo de ejecución
        System.out.println("\n");
        
        TInicio = System.currentTimeMillis(); //Tomamos la hora en que inicio el algoritmo y la almacenamos en la variable inicio
        CoutingSort(lista2);
        TFin = System.currentTimeMillis(); //Tomamos la hora en que finalizó el algoritmo y la almacenamos en la variable T
        tiempo = TFin - TInicio; //Calculamos los milisegundos de diferencia
        System.out.println("\n||||Tiempo de ejecución en milisegundos: " + tiempo+"||||\n"); //Mostramos en pantalla el tiempo de ejecución en milisegundos
        
        TInicio = System.currentTimeMillis(); //Tomamos la hora en que inicio el algoritmo y la almacenamos en la variable inicio
        BucketSort(lista1);
        TFin = System.currentTimeMillis(); //Tomamos la hora en que finalizó el algoritmo y la almacenamos en la variable T
        tiempo = TFin - TInicio; //Calculamos los milisegundos de diferencia
        System.out.println("\n|||Tiempo de ejecución en milisegundos: " + tiempo+"|||\n"); //Mostramos en pantalla el tiempo de ejecución en milisegundos
        
        TInicio = System.currentTimeMillis(); //Tomamos la hora en que inicio el algoritmo y la almacenamos en la variable inicio
        radixSortA(lista2);
        TFin = System.currentTimeMillis(); //Tomamos la hora en que finalizó el algoritmo y la almacenamos en la variable T
        tiempo = TFin - TInicio; //Calculamos los milisegundos de diferencia
        System.out.println("\n|||Tiempo de ejecución en milisegundos: " + tiempo+"|||\n"); //Mostramos en pantalla el tiempo de ejecución en milisegundos
    }

}
