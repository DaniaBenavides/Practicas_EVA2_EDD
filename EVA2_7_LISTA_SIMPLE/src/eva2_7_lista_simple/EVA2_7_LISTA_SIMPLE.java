/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eva2_7_lista_simple;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rocio
 */
public class EVA2_7_LISTA_SIMPLE {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //CREAR LISTA
        Lista miLista = new Lista();//creo una lista vacía
        miLista.printList();
        Nodo nodoNuevo = new Nodo(100);
        miLista.add(nodoNuevo);
        miLista.add(new Nodo(200));
        miLista.add(new Nodo(300));
        miLista.add(new Nodo(400));
        miLista.add(new Nodo(500));
        System.out.println("Conteo: "+miLista.length());
        miLista.printList();
        //System.out.println("Cantidad de nodos: " + miLista.length());
        miLista.insertAt(4, new Nodo(9999));
        System.out.println("Conteo: "+miLista.length());
        System.out.println("\nDespués de incertar al inicio");
        miLista.printList();
        System.out.println("\nDespués de BORRAR");
        miLista.deleteAt(5);
        miLista.printList();
        System.out.println("Conteo: "+miLista.length());
        miLista.add(new Nodo(777777));
        System.out.println("\nDespués de agregar");
        miLista.printList();
        System.out.println("Conteo: "+miLista.length());

        /* PRUEBA GET
        try {
            System.out.println("Posición " + miLista.get(10));
        } catch (Exception ex) {//AQUI SE RESUELVE EL ERROR
            ex.printStackTrace();//IMPRIMIR EL ERROR
        }
        //SEGUIR CON EL PROGRAMA
        System.out.println("El programa continua");
         */
 /* VERIFICACIÓN MÉTODO CLEAR
            miLista.clear();
            System.out.println("\nDESPUÉS DEL BORRADO");
            miLista.printList();
            miLista.add(new Nodo(1000));
            miLista.add(new Nodo(2000));
            System.out.println("");
            miLista.printList();*/
 /*   int[] miArreglo = new int[1000000];
            for (int i = 0; i < miArreglo.length; i++) {
            miArreglo[i] = (int) (Math.random() * 1000);
            }
            for (int i = 0; i < 1000000; i++) {
            //miLista.add(new Nodo((int)(Math.random())*1000));
            //Nodo nuevo = new Nodo ((int)(Math.random())*1000);
            miLista.add(new Nodo(1));
            }*/
    }

}
