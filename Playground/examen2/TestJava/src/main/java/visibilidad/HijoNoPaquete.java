/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visibilidad;

import otroPaquete.Padre;

/**
 *
 * @author Miguel Ángel Fernández Gutiérrez, Sergio Quijano Rey
 */
public class HijoNoPaquete extends Padre {
    int paquete_hijo;
    public void testInstanciaHijoNoPaquete(Padre o) {
        //System.out.println(o.privado);      // es privado en Padre
        //System.out.println(privado);        // la herencia de un privado hace que sea privado en el hijo
        //System.out.println(o.protegido);    // el objeto es superior
        System.out.println(protegido);      // el objeto es igual o inferior
        //System.out.println(o.paquete);      // está en otro paquete
        //System.out.println(paquete);        // está en otro paquete
        System.out.println(o.publico);
        System.out.println(publico);
    }
    
    public void testInstanciaHijoNoPaquete(HijoNoPaquete o) {
        //System.out.println(o.privado);      // es privado en Padre
        System.out.println(o.protegido);    // el objeto es igual o inferior
        //System.out.println(o.paquete);      // estamos en otro paquete
        System.out.println(o.publico);
    }
    
    public void testInstanciaHijoNoPaquete(NietaNoPaquete o) {
        //System.out.println(o.privado);      // es privado en Padre
        System.out.println(o.protegido);    // el objeto es igual o inferior
        //System.out.println(o.paquete);      // estamos en otro paquete
        System.out.println(o.publico);
    }
    
    public void testClaseHijoNoPaquete(Padre o) {
        // exactamente igual
        //System.out.println(o.privado);    
        //System.out.println(privado);  
        //System.out.println(o.protegido); 
        System.out.println(protegido); 
        //System.out.println(o.paquete);
        //System.out.println(paquete);
        System.out.println(o.publico);
        System.out.println(publico);
    }
    
    public void testClaseHijoNoPaquete(HijoNoPaquete o) {
        // exactamente igual
        //System.out.println(o.privado);
        System.out.println(o.protegido);
        //System.out.println(o.paquete);
        System.out.println(o.publico);
    }
}
