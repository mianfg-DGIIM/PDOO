/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractTest;

/**
 *
 * @author Miguel Ángel Fernández Gutiérrez, Sergio Quijano Rey
 */
abstract class SerVivo {
    static int decir() {
        return 1;
    }
    String planeta;
    SerVivo(String p) {
        planeta = p;
    }
    
    public String existir() {
        return "Existiendo";
    }
    
    public abstract String vivir();
}

class Humano extends SerVivo {
    String nombre;
    Humano(String p, String n) {
        super(p);
        nombre=n;
    }
    
    public String vivir() {
        return "Viviendo como humano";
    }
    
    public String existir() {
        return super.existir() + " como humano";
    }
}