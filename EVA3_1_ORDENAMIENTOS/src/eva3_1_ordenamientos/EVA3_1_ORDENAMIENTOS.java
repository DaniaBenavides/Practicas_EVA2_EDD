/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eva3_1_ordenamientos;

import java.util.Arrays;

/**
 *
 * @author rocio
 */
public class EVA3_1_ORDENAMIENTOS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //vamos a ordenar arreglos (int)
        int[] datos = new int[10];
        int[] copiaSel = new int[datos.length];
        int[] copiaIns = new int[datos.length];
        int[] copiaBubble = new int[datos.length];
        int[] copiaQuick = new int[datos.length];

        long iniT, finT;
        llenar(datos);//envio el arreglo a llenar con valores aleatorios
        
        duplicar(datos,copiaSel);
        Arrays.sort(copiaSel);

        System.out.println("PRUEBA CON SELECTION SORT: ");
        duplicar(datos, copiaSel);
        //imprimir(copiaSel);//imprimir contenido
        iniT = System.nanoTime();//tiempo antes de empezar el método
        //System.nanoTime();
        selectionSort(copiaSel);
        finT = System.nanoTime();//tiempo al terminar el método
        //imprimir(copiaSel);//imprimir contenido
        System.out.println("");
        System.out.println("Tiempo en ordenar: " + (finT - iniT));

        System.out.println("PRUEBA CON INSERTION SORT: ");
        duplicar(datos, copiaIns);
        imprimir(copiaIns);//imprimir contenido
        iniT = System.nanoTime();//tiempo antes de empezar el método
        insertionSort(copiaIns);
        finT = System.nanoTime();//tiempo al terminar el método
        imprimir(copiaIns);//imprimir contenido
        System.out.println("");
        System.out.println("Tiempo en ordenar: " + (finT - iniT));

        System.out.println("PRUEBA CON BUBBLE SORT: ");
        duplicar(datos, copiaBubble);
        //imprimir(copiaBubble);//imprimir contenido
        iniT = System.nanoTime();//tiempo antes de empezar el método
        insertionSort(copiaBubble);
        finT = System.nanoTime();//tiempo al terminar el método
        //imprimir(copiaBubble);//imprimir contenido
        System.out.println("");
        System.out.println("Tiempo en ordenar: " + (finT - iniT));
        
        System.out.println("PRUEBA CON QUICK SORT: ");
        duplicar(datos, copiaQuick);
        //imprimir(copiaQuick);//imprimir contenido
        iniT = System.nanoTime();//tiempo antes de empezar el método
        insertionSort(copiaQuick);
        finT = System.nanoTime();//tiempo al terminar el método
        //imprimir(copiaQuick);//imprimir contenido
        System.out.println("");
        System.out.println("Tiempo en ordenar: " + (finT - iniT));

    }

    //llenado de arreglo con valores aleatorios 0-99
    public static void llenar(int[] datos) {
        for (int i = 0; i < datos.length; i++) {
            datos[i] = (int) (Math.random() * 100);
        }
    }

    //duplicar arreglo (arreglos del mismo tamaño)
    public static void duplicar(int[] datos, int[] copia) {
        for (int i = 0; i < datos.length; i++) {
            copia[i] = datos[i];
        }
    }

    //copia de arreglo
    //imprimir arreglo
    public static void imprimir(int[] datos) {
        System.out.println("");
        for (int i = 0; i < datos.length; i++) {
            System.out.print("[" + datos[i] + "]");
        }
        System.out.println("");
    }

    //EFICIENCIA O(N^2)
    public static void selectionSort(int[] datos) {
        for (int i = 0; i < datos.length; i++) {
            int iMin = i; //empieza el siguiente algoritmo, el minimo es el primer elemento
            for (int j = 0; j < datos.length; j++) {//buscar la posicion del valor mas pequeño
                //comparar
                //valor[j] vs valor minimo
                if (datos[j] < datos[iMin]) { //comparo actual vs el minimo actual
                    iMin = j;
                }
            }
            //intercambio
            if (i != iMin) {
                //3 pasos 
                //respaldar un valor
                int iTemp = datos[i];
                //intercambiar un valor
                datos[i] = datos[iMin];
                //reponer el valor reespaldado
                datos[iMin] = iTemp;
            }

        }
    }

    public static void insertionSort(int[] datos) {
        for (int i = 1; i < datos.length; i++) {
            int temp = datos[i];//valor a insertar
            int insP = i;//posicion donde vamos a insertar
            for (int prev = i - 1; prev >= 0; prev--) {//buscar donde insertar
                if (datos[prev] > temp) {
                    datos[insP] = datos[prev];//movemos valor de prev a la posicion de insP
                    insP--;//retrocede una posicion
                } else {
                    break;
                }
            }
            //insertamo9s
            datos[insP] = temp;
        }
    }

    //eficiencia O(N^2)
    public static void bubbleSort(int[] datos) {
        for (int i = 0; i < datos.length; i++) {//pasadas
            for (int j = 0; j < datos.length; j++) {//compara e intercambia
                if (datos[j] > datos[j + 1]) {  //comparamos j vs j+1
                    //intercambiamos
                    int temp = datos[j];
                    datos[j] = datos[j + 1];
                    datos[j + 1] = temp;
                }
            }
        }
    }

    //QUICKSORT DE ARRANQUE
    public static void quickSort(int[] datos) {
        quickSortRecu(datos, 0, datos.length - 1);//quicksort a todo el arreglo
    }

    private static void quickSortRecu(int[] datos, int ini, int fin) {
        int iPivote;//inicio
        int too_big;//busca a los mas grandes que el pivote
        int too_small;//busca a los mas pequeños que el pivote
        boolean stopBig = false, stopSmall = false;
        //controlar recursividad:
        int tama = fin - ini + 1;
        if (tama > 1) {//¿Cuándo SI puedo realizar un quicksort?
            iPivote = ini;
            too_big = ini + 1;
            too_small = fin;
            for (int i = ini + 1; i <= fin; i++) {//numero de veces a recorrer
                if ((datos[too_big] < datos[iPivote]) && (!stopBig)) {//avanzo
                    too_big++;
                } else {
                    stopBig = true;//me detengo cuando encuentro uno mas grande
                }
                if ((datos[too_small] >= datos[iPivote]) && (!stopSmall)) {//retrocedo
                    too_small--;
                } else {
                    stopSmall = true;//me detengo cuando encuentro uno mas pequeño
                }
                //ambos se detienen (swap)
                if (stopBig && stopSmall) {//ambos indices se detuvieron
                    if (too_big < too_small) {//intercambio SWAP
                        int temp = datos[too_big];
                        datos[too_big] = temp;
                        stopBig = false;//seguir avanzando
                        stopSmall = false;//seguir avanzando
                    } else {
                        break;//termino el ciclo
                    }

                }
                //intercambio el pivote
                int temp = datos[iPivote];
                datos[iPivote] = datos[too_small];
                datos[too_small] = temp;
                iPivote = too_small;//tambien cambia la posicion del pivote
                //quicksort (izq)
                quickSortRecu(datos, ini, iPivote - 1);
                //quicksort (der)
                quickSortRecu(datos, iPivote + 1, fin);
            }
        }
    }
}
