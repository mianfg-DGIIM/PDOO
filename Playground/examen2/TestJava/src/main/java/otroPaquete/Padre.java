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
public class Padre {
    private int privado;
    protected int protegido;
    int paquete;
    public int publico;
    private static int privado_s;
    protected static int protegido_s;
    static int paquete_s;
    public static int publico_s;
    
    public void testInstanciaPadre(Padre o) {
        System.out.println(o.privado);
        System.out.println(privado);
        System.out.println(o.protegido);
        System.out.println(protegido);
        System.out.println(o.paquete);
        System.out.println(paquete);
        System.out.println(o.publico);
        System.out.println(publico);
    }
    
    public static void testClasePadre(Padre o) {
        System.out.println(o.privado);
        //System.out.println(privado);  no son estáticas
        System.out.println(privado_s);
        System.out.println(o.privado_s);    // no recomendado
        System.out.println(o.protegido);
        //System.out.println(protegido);
        System.out.println(o.paquete);
        //System.out.println(paquete);
        System.out.println(o.publico);
        //System.out.println(publico);
    }
}
