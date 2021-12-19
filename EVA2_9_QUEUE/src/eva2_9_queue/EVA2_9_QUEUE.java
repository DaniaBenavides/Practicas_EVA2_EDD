/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eva2_9_queue;

/**
 *
 * @author rocio
 */
public class EVA2_9_QUEUE extends Lista{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MyQueue myQueue= new MyQueue();
        myQueue.add(100);
        myQueue.add(200);
        myQueue.add(300);
        myQueue.add(400);
        myQueue.add(500);
        myQueue.printList();
        try{
          System.out.println("Primer elemento de la lista: "+myQueue.poll());  
        }catch(Exception ex){
            ex.printStackTrace();
        }
        myQueue.printList();
        
    }
    
}
