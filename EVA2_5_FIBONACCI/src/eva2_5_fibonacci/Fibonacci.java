/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eva2_5_fibonacci;

/**
 *
 * @author rocio
 */
public class Fibonacci {

    public int tamaño;

    public int getTamaño() {
        return tamaño;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }

    public Fibonacci(int tamaño) {
        this.tamaño = tamaño;
    }

    Fibonacci() {

    }

    public void imprimirSerie() {
        System.out.println("Serie de Fibonacci de tamaño " + this.tamaño + ":");
        for (int i = 0; i < tamaño; i++) {
            System.out.print(fibonacci(i) + " ");
        }
        System.out.println();
    }

    int fibonacci(int n) {
        if (n > 1) {
            return fibonacci(n - 1) + fibonacci(n - 2);
        } else if (n == 1) {
            return 1;
        } else if (n == 0) {
            return 0;
        } else {
            return -1;
        }
    }

}
