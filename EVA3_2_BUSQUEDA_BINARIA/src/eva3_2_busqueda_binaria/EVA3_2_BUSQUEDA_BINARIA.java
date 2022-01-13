/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eva3_2_busqueda_binaria;

import java.util.Scanner;

/**
 *
 * @author rocio
 */
public class EVA3_2_BUSQUEDA_BINARIA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] datos = new int[20];
        llenar(datos);// envio el arreglo a llenar con valores aleatorios
        imprimir(datos);
        insertionSort(datos);
        imprimir(datos);
        Scanner input = new Scanner(System.in);
        System.out.println("Valor a buscar: ");
        int valor = input.nextInt();
        int iResu = binarySearch(datos, valor);
        System.out.println("El elemento esta en la posición: " + (iResu + 1));
    }

    //llenado de arreglo con valores aleatorios 0-99
    public static void llenar(int[] datos) {
        for (int i = 0; i < datos.length; i++) {
            datos[i] = (int) (Math.random() * 100);
        }
    }

    //copia de arreglo
    //imprimir arreglo
    public static void imprimir(int[] datos) {
        System.out.print("");
        for (int i = 0; i < datos.length; i++) {
            System.out.print("[" + datos[i] + "]");
        }
        System.out.println("");
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

    //la busqueda binaria es recursiva
    //O(logN)
    public static int binarySearch(int[] datos, int valBuscar) {
        return binarySearchRecu(datos, valBuscar, 0, datos.length - 1);
    }

    private static int binarySearchRecu(int[] datos, int valBuscar, int ini, int fin) {
        int iMid, iResu;
        iMid = ini + ((fin - ini) / 2); //posicion a la mitad de la busqueda
        iResu = -1;//si el valor no existe regresamos -1

        if (fin >= ini) {//buscamos
            if (valBuscar == datos[iMid]) {//el valor esta a la mitad
                iResu = iMid;//aqui esta el valor y lo regresamos
            } else if (valBuscar < datos[iMid]) {//no esta a la mitad, pero puede estar a la izq
                iResu = binarySearchRecu(datos, valBuscar, ini, iMid - 1);
            } else {//no esta, pero puede estar a la der
                iResu = binarySearchRecu(datos, valBuscar, iMid + 1, fin);
            }
        }//se detiene el proceso

        return iResu;

    }

}
