/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exament1;

import exament1.package2.B;
/**
 *
 * @author mianfg
 */
public class ExamenT1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        // PRUEBA
        Prueba obj1 = new Prueba();
        Prueba obj2 = new Prueba();
        //obj1.A = 3; // error
        Prueba.s = "Hola";
        //Prueba.A = 14; // error
        //obj1.b = 3; // error
        //obj2.b = 5; // error
        obj1.c = 4;
        obj2.c = 5;
        
        int[][] c;
        int [5] e;
        int d[];
        A
    }
    
}

class Prueba {
    public static final int A = 1;
    static String s = "";
    private int b= 2;
    int c;
    
    
}

class A {
    void doing() {
        B b = new B();
        //b.atributo1 = "a";
        b.atributo2 = "b";
    }
}