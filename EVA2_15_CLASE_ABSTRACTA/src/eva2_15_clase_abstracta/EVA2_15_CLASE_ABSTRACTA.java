/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eva2_15_clase_abstracta;

/**
 *
 * @author rocio
 */
public class EVA2_15_CLASE_ABSTRACTA implements Algo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Prueba prueba = new Prueba();
        prueba.algo();
    }

    @Override
    public void a() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int b() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean c() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

abstract class Prueba{
    abstract public void algo();
    public void d(){} //si lo permite
}

interface Algo{
    public void a();
    public int b();
    public boolean c();
    // public void d(){} <-- No lo permite la interfaz
}