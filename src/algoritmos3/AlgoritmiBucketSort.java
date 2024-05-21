package algoritmos3;

import java.util.Vector;

public class AlgoritmiBucketSort {

    public static Vector<Integer> sort(Vector<Integer> lista, int inferior, int superior) {
        int rango = (superior - inferior);
        int bucket_size = rango / 10;

        Vector<Vector> listas = new Vector<>();
        /* creamos las listas de ordenamiento */
        for (int i = 0; i < 10; i++) {
            listas.addElement(new Vector<Integer>());
        }

        /*
               agregamos cada uno de los elemento en la lista que corresponde
         */
        for (int i = 0; i < lista.size(); i++) {
            /* calculamos en la lista que le corresponde */
            int casilla = (lista.elementAt(i) - inferior) / bucket_size;
            /* Agregamos el elemento a la lista calculada */
            Vector<Integer> vCasilla = listas.elementAt(casilla);
            vCasilla.addElement(lista.elementAt(i));
        }

        /* Ordenamos las listas con un metodo de ordenamiento
               en este caso utilizaremos el mismo metodo de ordenamiento
               el BucketSort recursivo.  */
        Vector<Integer> out = new Vector<Integer>();
        for (int i = 0; i < listas.size(); i++) {
            int inf = inferior + (i * bucket_size);
            int sup = inferior + (i * bucket_size) + bucket_size;
            /* en tmp vamos a guardar cada una de las listas pero ya ordenadas */
            Vector<Integer> tmp = null;
            /* si el rango es igual a 1 quiere decir que ya no hay por que ordenar si la lista tiene un elemento quiere decir que la lista esta ordenada */
            if (sup - inf == 1 || listas.elementAt(i).size() == 1) {
                tmp = listas.elementAt(i);
            } else {
                /*si no se cumple ninguna de las condiciones anteriores entonces la lista no esta ordenada pero procedemos a ordenarla */
                tmp = AlgoritmiBucketSort.sort(listas.elementAt(i), inf, sup);
            }
            /*
                   temp contiene los elementos de una lista ordenada
                   Agregamos todos los elementos de las listas a una sola lista
             */
            for (int j = 0; j < tmp.size(); j++) {
                out.addElement(tmp.elementAt(j));
            }
        }
        /*regresamos el contenido de todas las listas en una sola */
        return out;
    }

    public static void BucketSort(Vector<Integer> lista) {
        Vector<Integer> resultado = AlgoritmiBucketSort.sort(lista, 0, 1000);
        System.out.println("Metodo de ordenamiento BUCKETSORT");
        for (int i = 0; i < resultado.size(); i++) {
            System.out.print(resultado.elementAt(i)+ ", ");
        }
    }
}
