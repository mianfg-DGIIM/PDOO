/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

/**
 *
 * Test herencia 1
 */

class Persona {
    static void clase() {
        System.out.println("Clase no sé si puedo dar");
    }
    
    void hablar() {
        System.out.println("Hablo como una persona");
    }
    void saltar() {
        System.out.println("Salto como una persona");
    }
}

class Profe extends Persona {
    static void clase() {
        System.out.println("Puedo dar clase");
    }
    
    void hablar() {
        System.out.println("Hablo como un profesor");
    }
    void darclase() {
        System.out.println("Doy clase porque sí");
    }
}
public class Test1 {
    public static void main (String[] args) {
        Persona p = new Persona();
        Profe pr = new Profe();
        Persona prof = new Profe();
        
        p.hablar();
        p.saltar();
        
        pr.hablar();
        pr.saltar();
        pr.darclase();
        pr.clase(); // se puede hacer directamente
        
        prof.hablar();
        prof.saltar();
        //prof.darclase();
        //prof.clase();
        
        Persona.clase();    // Clase no sé si puedo dar
        Profe.clase();      // Puedo dar clase
        p.clase();          // Clase no sé si puedo dar
        pr.clase();         // Puedo dar clase
        prof.clase();       // Clase no sé si puedo dar
    }
}
