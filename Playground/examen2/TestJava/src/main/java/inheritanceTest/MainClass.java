/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inheritanceTest;

/**
 *
 * @author Miguel Ángel Fernández Gutiérrez, Sergio Quijano Rey
 */
public class MainClass {
    public static void other(String[] args) {
        System.out.println("inheritanceTest:\n");
        Profesor profe= new Profesor("44444","Pedro", "PDOO",8);
        //System.out.println(profe.nombre);
        Profesor.getNumPersonas();
        Persona.getNumPersonas();
        profe.getNombre();
        //profe.getDni(); ERROR - no definido ¿?
        profe.setDni("123");
        profe.nombre="Luis";
        
        Profesor prof = (Profesor) new Persona("44", "a");
        var exp = prof.experiencia;
    }
}
