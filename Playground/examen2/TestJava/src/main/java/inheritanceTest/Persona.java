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
public class Persona {

    private static int numPersonas = 0;
    protected String dni;
    private String nombre;

    final static void helloC() {
        System.out.println("Hi!");
    }

    final void hello() {
        System.out.println("Hi!");
    }

    public Persona(String d, String nom) {
        this.setDni(d);
        this.setNombre(nom);

        numPersonas += 1;
    }

    static int getNumPersonas() {
        return numPersonas;
    }

    protected String getNombre() {
        return this.nombre;
    }

    private String getDni() {
        return this.dni;
    }

    protected void setNombre(String nom) {
        this.nombre = nom;
    }

    void setDni(String d) {
        this.dni = d;
    }

    public void hablar() {
        System.out.println("bla bla bla");
    }
}

class Profesor extends Persona {

    String asignatura;
    public String nombre;
    int experiencia;

    public Profesor(String d, String nom, String asig, int exp) {
        super(d, nom);
        this.asignatura = asig;
        this.experiencia = exp;
    }
    
    
}

class Alumno extends Persona {

    String carrera;
    int curso;

    public Alumno(String d, String nom,
            String carr, int cur) {
        super(d, nom);
        this.carrera = carr;
        this.curso = cur;
    }
}
