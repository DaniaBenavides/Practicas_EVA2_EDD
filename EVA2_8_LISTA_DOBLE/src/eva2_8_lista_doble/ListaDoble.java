/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eva2_8_lista_doble;

/**
 *
 * @author rocio
 */
public class ListaDoble {
    private Nodo inicio;
    private Nodo fin;
    private int tama;
    
    public ListaDoble(){
        inicio= null;
        fin=null;
        tama=0;
    }
    
    //AGREGAR NODOS
        public void add(int valor) { //O(1)
        Nodo nuevo = new Nodo(valor);
        //HAY NODOS EN LA LISTA?
        if (inicio == null) { //LISTA VACIA
            inicio = nuevo; //CONECTAMOS EL PRIMER NODO A LA LISTA
            fin= nuevo;

        } else {//LISTA CON NODOS
            fin.setSiguiente(nuevo);
            nuevo.setPrevio(fin);
            fin=nuevo; //NOS MOVEMOS AL FINAL DE LA LISTA
        }
        tama++;
    }
    
    //IMPRIMIR LA LISTA
    public void printList() {
        Nodo temp = inicio; //aqui empezamos
        //while
        while (temp != null) { //mientras temp != null nos vamos a mover
            System.out.print(temp.getDato() + " - ");
            temp = temp.getSiguiente(); //mover a temp al siguiente nodo
        }

    }
    
    //IMPRIMIR LISTA EN ORDEN INVERSO
    
    //BORRAR LA LISTA
    public void clear() {
        inicio = null;
        fin = null;
        tama = 0;
    }
    
    //CONTAR LOS NODOS
    public int length() {
        int iCont = 0;
        Nodo temp = inicio;//aqui empezamos
        while (temp != null) { //mientras temp != null nos vamos a mover
            iCont++;
            temp = temp.getSiguiente(); //mover a temp al siguiente nodo
        }
        return iCont;
        //return tama;

    }
    
     public boolean isEmpty() {
        if (inicio == null) {
            return true;
        } else {
            return false;
        }
    }
     
     //RECUPERAR UN VALOR DE UNA LISTA
    public int get(int pos) throws Exception {
        //VERIFICACIÓN

        if (isEmpty()) {//LISTA ESTÉ VACÍA
            throw new Exception("¡¡No hay valores almacenados en la lista!!");
        } else { //POSICIÓN QUE NO EXISTA: POSICIÓN NEGATIVA O QUE NOS PASEMOS
            //pos tiene que estar entre 0 y N-1 --> N es el tamaño (length)
            if ((pos < 0) || (pos >= length())) {//si pos es menor a cero o pos es mayor o igual a N
                throw new Exception("El valor " + pos + " no es una posición valida en la lista");
            }
        }

        Nodo temp = inicio;
        for (int i = 0; i < pos; i++) {
            temp = temp.getSiguiente(); //mover a temp al siguiente nodo
        }
        return temp.getDato();
    }
    
    private void insertAtBeginning(Nodo nuevo) {
        nuevo.setSiguiente(inicio);//PRIMERO CONECTAMOS EL NODO NUEVO A LA LISTA
        inicio.setPrevio(nuevo);
        inicio = nuevo;//CONECTAR LA LISTA AL NUEVO NODO
    }

    public void insertAt(int pos, int valor) {
        Nodo nuevo = new Nodo(valor);
        //VALIDAR
        //SITUACIONES:
        //INSERTAR AL INICIO
        if (pos == 0) {
            insertAtBeginning(nuevo);
        } else { //CUALQUIER OTRO CASO
            //movernos al nodo previo a la posición
            Nodo temp = inicio;
            for (int i = 0; i < pos; i++) {
                temp = temp.getSiguiente();//mover a temp al siguiente nodo
            }

            //FALTA RECONECTAR
            //primero conectamos el nuevo nodo
            nuevo.setSiguiente(temp);
            nuevo.setPrevio(temp.getPrevio());
            //conectamos la lista al nuevo nodo
            temp.getPrevio().setSiguiente(nuevo);
            temp.setPrevio(nuevo);
        }
        tama++;
    }
    
    public void deleteAt(int pos) {
        int iTamaLista = length();
        //validar
        if (iTamaLista == 1) {
            clear();
        } else {
            //situaciones
            if (pos == 0) {//borrar un nodo al inicio
                inicio = inicio.getSiguiente();
            } else {//cualquier otro caso
                //MOVEMOS AL NODO PREVIO A LA POSICIÓN
                Nodo temp = inicio;
                for (int i = 0; i < (pos - 1); i++) {
                    temp = temp.getSiguiente(); //mover a temp al siguiete nodo
                }
                //falta reconectar
                temp.setSiguiente(temp.getSiguiente().getSiguiente());
                if (pos == (iTamaLista - 1)) //verifico si es el ultimo nodo de la lista
                {
                    fin = temp;
                }
            }
            tama--;
        }
    }
}
