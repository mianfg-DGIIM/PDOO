/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

/**
 *
 * Visibilidad
 */
class ClaseA {
    public int publico;
    private int privado;
    int paquete;
    protected int protegido;
    
    public static int publico_s;
    private static int privado_s;
    static int paquete_s;
    protected static int protegido_s;
    
    public void testInstanciaPadre(ClaseA o) {
        System.out.println(publico);
        System.out.println(privado);
        System.out.println(paquete);
        System.out.println(protegido);
        System.out.println(o.publico);
        System.out.println(o.privado);
        System.out.println(o.paquete);
        System.out.println(o.protegido);
        System.out.println(publico_s);
        System.out.println(privado_s);
        System.out.println(paquete_s);
        System.out.println(protegido_s);
        System.out.println(o.publico_s);
        System.out.println(o.privado_s);
        System.out.println(o.paquete_s);
        System.out.println(o.protegido_s);
    }
    
    public static void testClasePadre(ClaseA o) {
        //NECESARIAS INSTANCIAS:
        //System.out.println(publico);
        //System.out.println(privado);
        //System.out.println(paquete);
        //System.out.println(protegido);
        System.out.println(o.publico);
        System.out.println(o.privado);
        System.out.println(o.paquete);
        System.out.println(o.protegido);
        System.out.println(publico_s);
        System.out.println(privado_s);
        System.out.println(paquete_s);
        System.out.println(protegido_s);
        //NO RECOMENDABLE:
        System.out.println(o.publico_s);
        System.out.println(o.privado_s);
        System.out.println(o.paquete_s);
        System.out.println(o.protegido_s);
    }
    
    public void testInstanciaPadre(ClaseB o) {
        System.out.println(publico);
        System.out.println(privado);
        System.out.println(paquete);
        System.out.println(protegido);
        System.out.println(o.publico);
        //System.out.println(o.privado);
            // o es de una clase diferente a ClaseA
        System.out.println(o.paquete);
        System.out.println(o.protegido);
        System.out.println(publico_s);
        System.out.println(privado_s);
        System.out.println(paquete_s);
        System.out.println(protegido_s);
        System.out.println(o.publico_s);
        //System.out.println(o.privado_s);
            // o es de una clase diferente a ClaseA
        System.out.println(o.paquete_s);
        System.out.println(o.protegido_s);
    }
    
    public static void testClasePadre(ClaseB o) {
        //Estamos en ámbito de clase:
        //System.out.println(publico);
        //System.out.println(privado);
        //System.out.println(paquete);
        //System.out.println(protegido);
        System.out.println(o.publico);
        //System.out.println(o.privado);
            // o es de una clase diferente a ClaseA
        System.out.println(o.paquete);
        System.out.println(o.protegido);
        System.out.println(publico_s);
        System.out.println(privado_s);
        System.out.println(paquete_s);
        System.out.println(protegido_s);
        System.out.println(o.publico_s);
        //System.out.println(o.privado_s);
            // o es de una clase diferente a ClaseA
        System.out.println(o.paquete_s);
        System.out.println(o.protegido_s);
    }
}

class ClaseB extends ClaseA {
    public void testInstanciaHijo(ClaseA o) {
        System.out.println(publico);
        //System.out.println(privado);
            // o es de una clase diferente a ClaseB
        System.out.println(paquete);
        System.out.println(protegido);
        System.out.println(o.publico);
        //System.out.println(o.privado);
            // o es de una clase diferente a ClaseB
        System.out.println(o.paquete);
        System.out.println(o.protegido);
        System.out.println(publico_s);
        //System.out.println(privado_s);
            // o es de una clase diferente a ClaseB
        System.out.println(paquete_s);
        System.out.println(protegido_s);
        System.out.println(o.publico_s);
        //System.out.println(o.privado_s);
            // o es de una clase diferente a ClaseB
        System.out.println(o.paquete_s);
        System.out.println(o.protegido_s);
    }
    
    public static void testClaseHijo(ClaseA o) {
        //Estamos en ámbito de clase:
        //System.out.println(publico);
        //System.out.println(privado);
        //System.out.println(paquete);
        //System.out.println(protegido);
        System.out.println(o.publico);
        //System.out.println(o.privado);
            // o es de una clase diferente a ClaseB
        System.out.println(o.paquete);
        System.out.println(o.protegido);
        System.out.println(publico_s);
        System.out.println(privado_s);
        System.out.println(paquete_s);
        System.out.println(protegido_s);
        System.out.println(o.publico_s);
        System.out.println(o.privado_s);
        System.out.println(o.paquete_s);
        System.out.println(o.protegido_s);
    }
    
    public void testInstanciaHijo(ClaseB o) {
        System.out.println(publico);
        System.out.println(privado);
        System.out.println(paquete);
        System.out.println(protegido);
        System.out.println(o.publico);
        System.out.println(o.privado);
        System.out.println(o.paquete);
        System.out.println(o.protegido);
        System.out.println(publico_s);
        System.out.println(privado_s);
        System.out.println(paquete_s);
        System.out.println(protegido_s);
        System.out.println(o.publico_s);
        System.out.println(o.privado_s);
        System.out.println(o.paquete_s);
        System.out.println(o.protegido_s);
    }
    
    public static void testClaseHijo(ClaseB o) {
        System.out.println(publico);
        System.out.println(privado);
        System.out.println(paquete);
        System.out.println(protegido);
        System.out.println(o.publico);
        System.out.println(o.privado);
        System.out.println(o.paquete);
        System.out.println(o.protegido);
        System.out.println(publico_s);
        System.out.println(privado_s);
        System.out.println(paquete_s);
        System.out.println(protegido_s);
        System.out.println(o.publico_s);
        System.out.println(o.privado_s);
        System.out.println(o.paquete_s);
        System.out.println(o.protegido_s);
    }
    
}

public class Test5 {
    public static void main(String[] args) {
        System.out.println("Ejecutando test...");
    }
}
