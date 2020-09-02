/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaceTest;

/**
 *
 * @author Miguel Ángel Fernández Gutiérrez, Sergio Quijano Rey
 */
public interface Saludo {
    public void diHola();
    public default void diAdios() {
        System.out.println("ciao");
    }
    public static void diAlgo() {
        System.out.println("algo");
    }
}

interface Despedida {
    public default void diAdios() {
        System.out.println("adioo");
    }
}

class MiSaludo implements Saludo {
    @Override
    public void diHola() {
        System.out.println("hola");
    }
    
    public static void diAlgo() {
        System.out.println("algoo");
    }
}

class CBienEducado implements Saludo, Despedida {
    public void diHola() {
        System.out.println("hola, mlady");
    }
    
    public void diAdios() {
        Despedida.super.diAdios();
    }
}

abstract class CBuenaEducacion implements Saludo, Despedida {
    public void diHola() {
        System.out.println("hola, mlady");
    }
    
    @Override
    public abstract void diAdios();
}

interface BuenEducado extends Saludo, Despedida {
    @Override
    public void diAdios();
}