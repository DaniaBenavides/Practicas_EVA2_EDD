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
public class MyQueue extends Lista{
    //CARACTERÍSTICAS QUEUE
    //COMO LA FILA DE SUPERMERCADO
    //LOS ELEMENTOS SE AGREGAN AL FINAL DE LA LISTA
    //metodo add de la lista --> sin cambios
    //SOLO PODEMOS ACCEDER A LOS ELEMENTOS AL INICIO DE LA LISTA
    
    public int peek() throws Exception{//regresa el valor del elemento al inicio de la lista
    return get(0);
}
    public int poll() throws Exception{//regresa y elimina el elemento al inicio de la lista
        //guardar el valor
        int iVal = get(0);
        //eliminar el valor
        deleteAt(0);
        //enviamos el valor
        return iVal;
    }
}
