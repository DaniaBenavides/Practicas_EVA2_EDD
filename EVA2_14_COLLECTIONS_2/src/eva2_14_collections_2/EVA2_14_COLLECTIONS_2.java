/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eva2_14_collections_2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author rocio
 */
public class EVA2_14_COLLECTIONS_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //queue es una lista, pero con comportamiento de queue: insertar al final, leer al inicio
        //interfaz
        Queue<Integer> queue = new LinkedList();
        queue.add(100);
        queue.add(200);
        queue.add(300);
        queue.add(400);
        queue.add(500);
        System.out.println(queue);
        System.out.println(queue.peek());
        System.out.println(queue);
        System.out.println(queue.remove());
        System.out.println(queue);
        
        System.out.println("STACK");
        Stack<Integer> stack = new Stack();
        stack.add(100);
        stack.add(200);
        stack.add(300);
        stack.add(400);
        stack.add(500);
        System.out.println(stack);
        System.out.println(stack.peek());
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack);
    }
    
}
