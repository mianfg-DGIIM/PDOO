/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polymorphismTest;

/**
 *
 * @author Miguel Ángel Fernández Gutiérrez, Sergio Quijano Rey
 */
public class MainClass {
    public static void main(String[] args) {
        System.out.println("polymorphismTest:\n");
        
        Persona p = new Persona();
        Persona p2 = new Profesor();
        
        //p2.darClase();
        //p = new Object();
        
        ((Profesor) p2).darClase();
        //((Profesor) p).darClase();
        
        //Profesor profe = (Profesor) p;
        Profesor profe2 = (Profesor) p2;
        
        //profe.hablar();
        profe2.hablar();
        
        //((Persona) profe).hablar();
        ((Persona) profe2).hablar();
        
        Persona p3 = profe2;
        p3.hablar();
        
        Persona.decir("-----");
        
        Persona P = new Persona();
        //Profesor Profe = (Profesor) P;
        //((Profesor) new Persona());
        //((Profesor) P).darClase();
        ((Profesor) ((Object) new Profesor())).darClase();
    }
}

class Persona {
    public static void decir(String s) {
        System.out.println(s);
    }
    public void andar() {
        decir("Ando como una persona");
    }
    
    public void hablar() {
        decir( "Hablo como una persona");
    }
}

class Profesor extends Persona {
    @Override
    public void hablar() {
        decir("Hablo como un profesor");
    }
    
    public void darClase() {
        decir("Doy clase, porque soy un profesor");
    }
}