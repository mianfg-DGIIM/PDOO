/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otroPaquete;

/**
 *
 * @author Miguel Ángel Fernández Gutiérrez, Sergio Quijano Rey
 */
public class Hijo extends Padre {
    public void testInstanciaHijo(Padre o) {
        //System.out.println(o.privado);      // es privado en Padre
        //System.out.println(privado);        // la herencia de un privado hace que sea privado en el hijo
        System.out.println(o.protegido);    // estamos en el mismo paquete
        System.out.println(protegido);      // 
        System.out.println(o.paquete);
        System.out.println(paquete);
        System.out.println(o.publico);
        System.out.println(publico);
    }
    
    public void testInstanciaHijo(Hijo o) {
        //System.out.println(o.privado);      // es privado en Padre
        System.out.println(o.protegido);    // estamos en el mismo paquete
        System.out.println(o.paquete);
        System.out.println(o.publico);
    }
    
    public void testClaseHijo(Padre o) {
        // exactamente igual
        //System.out.println(o.privado);    
        //System.out.println(privado);  
        System.out.println(o.protegido); 
        System.out.println(protegido); 
        System.out.println(o.paquete);
        System.out.println(paquete);
        System.out.println(o.publico);
        System.out.println(publico);
    }
    
    public void testClaseHijo2(Hijo o) {
        // exactamente igual
        //System.out.println(o.privado);
        System.out.println(o.protegido);
        System.out.println(o.paquete);
        System.out.println(o.publico);
    }
    
    public void func(Hijo h) {
        System.out.println("func de Hijo");
    }
    public void func(Padre h) {
        System.out.println("func de Padre");
    }
    
    //PROBAR:
    Padre p = new Padre();
    Padre p2 = new Hijo();
    Hijo h = new Hijo();
    
    //func(p);
    //func(p2);
    //func(h);
}
