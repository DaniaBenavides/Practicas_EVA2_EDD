/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eva2_7_lista_simple;

/**
 *
 * @author rocio
 */
public class Lista { //LISTA SIEMPRE ENLAZADA (LINKED LIST)

    private Nodo inicio; //ACCESO A LA LISTA (PUNTO DE PARTIDA)
    private Nodo fin;
    private int tama;//contador de nodos

    public Lista() {
        inicio = null; //LISTA VACÍA
        fin = null;
        tama = 0;
    }

    //AGREGAR NODOS
    public void add(Nodo nuevo) {
        if (inicio == null) { //LISTA VACÍA
            inicio = nuevo; //conectamos el primer nodo a la lista 
            fin = nuevo;
        } else { //LISTA CON NODOS
            //hay que movernos al final de la lista
            //usando temp, nodo por nodo hasta llegar al final
            /* Nodo temp = inicio;//aqui empezamos
            //while
            while (temp.getSiguiente() != null) { //mientras temp.siguiente != null nos vamos a mover
                temp = temp.getSiguiente(); //mover a temp al siguiente nodo
            }
            temp.setSiguiente(nuevo);//conectamos al final de la lista el nuevo nodo
             */
            //agregar el nodo al final
            fin.setSiguiente(nuevo);
            fin = nuevo; //nos movemos al final de la lista
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

    public void clear() {
        inicio = null;
        fin = null;
        tama = 0;
    }

    //CONTAR LOS NODOS
    public int length() {
        /* int iCont = 0;
        Nodo temp = inicio;//aqui empezamos
        while (temp != null) { //mientras temp != null nos vamos a mover
            iCont++;
            temp = temp.getSiguiente(); //mover a temp al siguiente nodo
        }
        return iCont;*/
        return tama;

    }

    //La lista está vacía: true; con nodos: false
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
            if ((pos < 0) || (pos >= (length() - 1))) {//si pos es menor a cero o pos es mayor o igual a N
                throw new Exception("El valor " + pos + " no es una posición valida en la lista");
            }
        }

        Nodo temp = inicio;
        for (int i = 0; i < pos; i++) {
            temp = temp.getSiguiente(); //mover a temp al siguiente nodo
        }
        return temp.getDato();
    }

    public void insertAtBeginning(Nodo nuevo) {
        nuevo.setSiguiente(inicio);//PRIMERO CONECTAMOS EL NODO NUEVO A LA LISTA
        inicio = nuevo;//CONECTAR LA LISTA AL NUEVO NODO
    }

    public void insertAt(int pos, Nodo nuevo) {
        //VALIDAR
        //SITUACIONES:
        //INSERTAR AL INICIO
        if (pos == 0) {
            insertAtBeginning(nuevo);
        } else { //CUALQUIER OTRO CASO
            //movernos al nodo previo a la posición
            Nodo temp = inicio;
            for (int i = 0; i < (pos - 1); i++) {
                temp = temp.getSiguiente();//mover a temp al siguiente nodo
            }

            //FALTA RECONECTAR
            //primero conectamos el nuevo nodo
            nuevo.setSiguiente(temp.getSiguiente());
            //conectamos la lista al nuevo nodo
            temp.setSiguiente(nuevo);
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
