/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eva2_11_arbol_b;

/**
 *
 * @author rocio
 */
public class ArbolBinario {
    
    private Nodo root;
    
    public ArbolBinario(){
        this.root=null; //arbol vacio
    }
    
    //a partir de aqui todo es recursivo
    //agregar nodo:
    public void add(int valor){
        Nodo nuevo = new Nodo(valor);
        //verificamos si hay nodos en el arbol
        if(root==null){//arbol vacio
            root=nuevo;
        }else{//hay nodos
            ////metodo recursivo para agregar nodos
            addRecu(root, nuevo);
        }
    }
    
    //metodo recursivo (nodo actual, nodo nuevo)
    private void addRecu(Nodo actual, Nodo nuevo){
        //verficar el lado al que va el nodo
        if(nuevo.getDato()<actual.getDato()){//izquierda: valor nuevo menor que nodo actual
            if(actual.getIzquierda()==null){//tenemos espacio, aqui insertamos el nodo nuevo
                actual.setIzquierda(nuevo);
            }else{//llamar de nuevo al metodo recursivo, pero moviendome a la izquierda
                addRecu(actual.getIzquierda(), nuevo);
            }
        }else if(nuevo.getDato()>actual.getDato()){//derecha
            if(actual.getDerecha()==null){//tenemos espacio, aqui insertamos el nodo nuevo
                actual.setDerecha(nuevo);
            }else{//llamar de nuevo al metodo recursivo, pero moviendome a la derecha
                addRecu(actual.getDerecha(), nuevo);
            }
        }else{//valor igual al actual
            System.out.println("El valor ya existe en el árbol");
        }
    }
 
    //imprimir nodos del arbol
    public void printPreOrder(){
        preOrder(root);//llama al metodo recursivo pre order
    }
    
    public void preOrder(Nodo actual){
        if(actual != null){
            System.out.print("["+actual.getDato()+"]");//visit node
            preOrder(actual.getIzquierda());//travers left subtree
            preOrder(actual.getDerecha());//travers right subtree
        }
    }
    
    //POST ORDER
    public void printPostOrder(){
        postOrder(root);//llama al metodo recursivo pre order
    }
    
    public void postOrder(Nodo actual){
        if(actual != null){
            postOrder(actual.getIzquierda());//travers left subtree
            postOrder(actual.getDerecha());//travers right subtree
            System.out.print("["+actual.getDato()+"]");//visit node
        }
    }
    //IN ORDER
    public void printInOrder(){
        inOrder(root);//llama al metodo recursivo pre order
    }
    
    public void inOrder(Nodo actual){
        if(actual != null){
            inOrder(actual.getIzquierda());//travers left subtree
            System.out.print("["+actual.getDato()+"]");//visit node
            inOrder(actual.getDerecha());//travers right subtree
        }
    }
}
