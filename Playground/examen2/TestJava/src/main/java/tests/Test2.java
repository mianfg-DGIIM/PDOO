/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

/**
 *
 * Test para super, @Override
 */
class Padre {
    void metodo1() {
        System.out.println("Padre.metodo1");
    }
    
    void metodo2() {
        System.out.println("Padre.metodo2");
    }
}

class Hijo extends Padre {
    @Override
    void metodo1() {
        System.out.println("Hijo.metodo1");
    }
    
    // @Override -- ERROR: no se está sobreescribiendo nada
    void metodo3() {
        System.out.println("Hijo.metodo3");
    }
    
    void llamar() {
        metodo1();
        super.metodo1();
        metodo2();
        super.metodo2();
        metodo3();
        //super.metodo3();  no existe
    }
}

public class Test2 {
    public static void main(String[] args) {
        new Hijo().llamar();
    }
}
